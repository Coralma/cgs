package com.coral.cgs.calculation;

import java.math.BigDecimal;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingMain {

    public static void main(String[] args) {
        RatingNode rootNode = RatingNodeFactory.createRootNode("root");
        RatingNode insureNode1 = RatingNodeFactory.createAggregateChildNode(rootNode, "insured1");
        insureNode1.addRatingAdjust(RatingAdjust.fixedAmount(new BigDecimal(200),"SGP"));
        RatingNodeFactory.createChildNode(insureNode1, "cover1", new BigDecimal(1000));
        RatingNodeFactory.createChildNode(insureNode1, "cover2", new BigDecimal(1000));
        RatingNodeFactory.createChildNode(insureNode1, "cover3", new BigDecimal(1000));

        RatingNode insureNode2 = RatingNodeFactory.createAggregateChildNode(rootNode, "insured2");
        insureNode2.addRatingAdjust(RatingAdjust.fixedAmount(new BigDecimal(100),"NGP"));
        RatingNodeFactory.createChildNode(insureNode2, "cover4", new BigDecimal(1000));
        RatingNodeFactory.createChildNode(insureNode2, "cover5", new BigDecimal(1000));

        System.out.println("Before calculation");
        System.out.println(rootNode);
        System.out.println("After calculation");
        RatingTrace ratingTrace = RatingEngine.calculate(rootNode, 10001l);
        System.out.println(rootNode);
        System.out.println(ratingTrace);
    }
}
