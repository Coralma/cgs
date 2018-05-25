package com.coral.cgs.calculation;


import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingEngine {

    public static RatingTrace calculate(RatingNode root, Long policyId) {
        List<RatingStage> ratingStages = RatingConfiguration.getInstance().getSortedRatingStages();
        RatingTrace ratingTrace = new RatingTrace();
        for(RatingStage ratingStage : ratingStages) {
            //累加
            accumulate(root, ratingStage, ratingTrace);
            //拆分
            apportion(root, ratingStage, ratingTrace);
        }
        return ratingTrace;
    }

    private static void accumulate(RatingNode node, RatingStage ratingStage, RatingTrace ratingTrace) {
        if(node.hasChild()) {
            node.setCurrentValue(BigDecimal.ZERO);
            for(RatingNode ratingNode : node.getChildren()) {
                accumulate(ratingNode, ratingStage, ratingTrace);
            }
            ratingTrace.createFormulaTrace(node, ratingStage);
        }
        sumToParent(node, ratingStage, ratingTrace);
    }

    private static void apportion(RatingNode node, RatingStage ratingStage, RatingTrace ratingTrace) {
        if(node.hasChild()) {
            apportionToChild(node, ratingStage, ratingTrace);
            for(RatingNode ratingNode : node.getChildren()) {
                apportion(ratingNode, ratingStage, ratingTrace);
            }
        }
    }

    private static RatingTrace sumToParent(RatingNode node, RatingStage ratingStage, RatingTrace ratingTrace) {
        RatingNode parentNode = node.getParent();
        if(parentNode != null) {
            BigDecimal parentValue = parentNode.getCurrentValue();
            //adjust the current node value.
            BigDecimal adjustedValue = attachAdjustment(node, ratingStage, ratingTrace);
            parentValue = parentValue.add(adjustedValue);
            parentNode.setCurrentValue(parentValue);
        }
        return ratingTrace;
    }

    private static BigDecimal attachAdjustment(RatingNode node, RatingStage ratingStage, RatingTrace ratingTrace) {
        List<RatingAdjust> ratingAdjusts = node.getCurrentAdjustByStage(ratingStage);
        BigDecimal value = node.getCurrentValue();
        if(ratingAdjusts != null) {
            for (RatingAdjust ratingAdjust : ratingAdjusts) {
                BigDecimal adjustFactor = ratingAdjust.getAdjustmentFactor();
                if (RatingAdjust.FIX_AMOUNT == ratingAdjust.getAdjustmentType()) {
                    value = value.add(adjustFactor);
                } else if (RatingAdjust.PERCENTAGE == ratingAdjust.getAdjustmentType()) {
                    value = value.multiply(adjustFactor);
                } else if (RatingAdjust.MAX == ratingAdjust.getAdjustmentType()) {
                    if (value.compareTo(adjustFactor) > 0) {
                        value = adjustFactor;
                    }
                } else if (RatingAdjust.MIN == ratingAdjust.getAdjustmentType()) {
                    if (value.compareTo(adjustFactor) < 0) {
                        value = adjustFactor;
                    }
                }
                // add trace log
                ratingTrace.createFormulaTrace(node, ratingStage, ratingAdjust);
            }
            node.setCurrentValue(value);
            node.addStageValue(ratingStage, value);
        } else {
            ratingTrace.createFormulaTrace(node, ratingStage);
        }
        return value;
    }

    private static RatingTrace apportionToChild(RatingNode node, RatingStage ratingStage, RatingTrace ratingTrace) {
        List<RatingNode> children = node.getChildren();
        BigDecimal parentValue = node.getCurrentValue();
        int size = children.size();
        /*BigDecimal percent = BigDecimal.ONE.divide(new BigDecimal(size), 2);*/
        if(size > 1) {
            BigDecimal childrenTotal = BigDecimal.ZERO;
            for (RatingNode child : node.getChildren()) {
                childrenTotal = childrenTotal.add(child.getCurrentValue());
            }
            BigDecimal siblingTotal = BigDecimal.ZERO;
            for (int i = 0; i < size; i++) {
                RatingNode child = children.get(i);
                if (i < (size - 1)) {
                    BigDecimal childValue = child.getCurrentValue();
                    BigDecimal parentAmount = childValue.multiply(parentValue);
                    BigDecimal newChildValue = parentAmount.divide(childrenTotal, BigDecimal.ROUND_UP);
                    /*BigDecimal percent = childValue.divide(childrenTotal, 9, BigDecimal.ROUND_UP);
                    BigDecimal newChildValue = percent.multiply(parentValue).setScale(2, BigDecimal.ROUND_UP);*/
                    child.setCurrentValue(newChildValue);
                    siblingTotal = siblingTotal.add(newChildValue);
                } else {
                    BigDecimal childValue = parentValue.subtract(siblingTotal);
                    child.setCurrentValue(childValue);
                }
            }
        }
        return ratingTrace;
    }
}
