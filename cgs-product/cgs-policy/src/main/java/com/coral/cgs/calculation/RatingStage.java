package com.coral.cgs.calculation;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingStage {

    private String name;
    private RatingStage previousStage;

    RatingStage(String name, RatingStage previousStage) {
        this.name = name;
        this.previousStage = previousStage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RatingStage getPreviousStage() {
        return previousStage;
    }

    public void setPreviousStage(RatingStage previousStage) {
        this.previousStage = previousStage;
    }
}
