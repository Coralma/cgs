package com.coral.cgs.calculation;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingTrace {

    private static String SUM ="SUM";
    private static String APPORTION="APPORTION";
    private List<FormulaTrace> formulaTraces = Lists.newArrayList();

    public void createFormulaTrace(RatingNode ratingNode, RatingStage ratingStage) {
        formulaTraces.add(new FormulaTrace(SUM,ratingNode.getName(),ratingNode.getLevel(),
                ratingNode.getCurrentValue(),
                ratingStage.getName(),null,null));
    }

    public void createFormulaTrace(RatingNode ratingNode, RatingStage ratingStage, RatingAdjust ratingAdjust) {
        formulaTraces.add(new FormulaTrace(SUM, ratingNode.getName(),
                ratingNode.getLevel(),
                ratingNode.getCurrentValue(),
                ratingStage.getName(),
                ratingAdjust.getAdjustmentType(),
                ratingAdjust.getAdjustmentFactor()));
    }


    public void createApportionTrace(RatingNode ratingNode, RatingStage ratingStage) {
        formulaTraces.add(new FormulaTrace(APPORTION, ratingNode.getName(),ratingNode.getLevel(),
                ratingNode.getCurrentValue(),
                ratingStage.getName(),null,null));
    }


    public String toString() {
        String text = "";
        for(FormulaTrace formulaTrace : formulaTraces) {
            text += formulaTrace.toString() + "\n";
        }
        return text;
    }

    class FormulaTrace {
        String name,type,stage,adjustType;
        BigDecimal value,amount,result;
        int level;

        public FormulaTrace(String type, String name, int level, BigDecimal value, String stage, Integer adjustType, BigDecimal amount) {
            this.type = type;
            this.name = name;
            this.level = level;
            this.value = value;
            this.stage = stage;
            this.amount = amount;

            if(adjustType != null) {
                if (RatingAdjust.FIX_AMOUNT == adjustType.intValue()) {
                    this.adjustType = "+";
                    this.result = value.add(amount);
                } else if (RatingAdjust.PERCENTAGE == adjustType.intValue()) {
                    this.adjustType = "*";
                    this.result = value.multiply(amount);
                } else if (RatingAdjust.MAX == adjustType.intValue()) {
                    this.adjustType = "MAX";
                    this.result = amount;
                } else if (RatingAdjust.MIN == adjustType.intValue()) {
                    this.adjustType = "MIN";
                    this.result = amount;
                }
            }
        }

        public String toString() {
            String text = "";
            if(adjustType == null) {
                text += "{"+
                        "type: " + type + ", " +
                        "level: " + level + ", " +
                        "name: " + name + ", " +
                        "stage: " + stage + ", " +
                        "value: " + value  +
                        "}";
            } else {
                text += "{"+
                        "type: " + type + ", " +
                        "level: " + level + ", " +
                        "name: " + name + ", " +
                        "stage: " + stage + ", " +
                        "beforeValue: " + value + ", " +
                        "adjust: " + value + adjustType + amount + "=" + result+
                        "}";
            }
            return text;
        }
    }
}
