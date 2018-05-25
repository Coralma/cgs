package com.coral.cgs.calculation;

import java.math.BigDecimal;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingNodeFactory {

    public static RatingNode createNode(RatingNode parent, String name) {
        RatingNode rootNode = new RatingNode(parent);
        rootNode.setName(name);
        return rootNode;
    }

    public static RatingNode createRootNode(String name) {
        return createNode(null, name);
    }

    public static RatingNode createAggregateChildNode(RatingNode parent, String name) {
        return createNode(parent, name);
    }

    public static RatingNode createChildNode(RatingNode parent, String name, BigDecimal value) {
        return createObservableChildNode(parent, name, value);
    }

    public static RatingNode createObservableChildNode(RatingNode parent, String name, BigDecimal value) {
        RatingNode dataNode = new RatingNode(parent);
        dataNode.setName(name);
        dataNode.setCurrentValue(value);
        //dataNode.setInitObservable(Observable.just(value));
        return dataNode;
    }

    /*public static RatingNode createObservableChildNode(RatingNode parent, String name, Observable<BigDecimal> initObservable) {
        RatingNode dataNode = new RatingNode(parent);
        dataNode.setName(name);
        dataNode.setInitObservable(initObservable);
        return dataNode;
    }*/


}
