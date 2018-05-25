package com.coral.cgs.calculation;

import com.google.common.base.Optional;

import java.math.BigDecimal;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingAdjust {

    private RatingStage ratingStage;
    private BigDecimal adjustmentFactor;
    //private Observable<BigDecimal> adjustmentFactor;
    private int adjustmentType = 1; // 1 means fixAmount, 2 means percentage, 3 means max, 4 means min
    public static int FIX_AMOUNT = 1;
    public static int PERCENTAGE = 2;
    public static int MAX = 3;
    public static int MIN = 4;

    public RatingAdjust(BigDecimal adjustmentFactor, RatingStage ratingStage, int adjustmentType) {
        this.ratingStage = ratingStage;
        this.adjustmentFactor = adjustmentFactor;
        this.adjustmentType = adjustmentType;
    }

    public static RatingAdjust fixedAmount(BigDecimal amount, String stage) {
        RatingAdjust ratingAdjust = new RatingAdjust(amount, RatingConfiguration.getInstance().getRatingStage(stage), FIX_AMOUNT);
        return ratingAdjust;
    }

    public static RatingAdjust percentage(BigDecimal amount, String stage) {
        return new RatingAdjust(amount, RatingConfiguration.getInstance().getRatingStage(stage), PERCENTAGE);
    }

    public static RatingAdjust max(BigDecimal amount, String stage) {
        return new RatingAdjust(amount, RatingConfiguration.getInstance().getRatingStage(stage), MAX);
    }

    public static RatingAdjust min(BigDecimal amount, String stage) {
        return new RatingAdjust(amount, RatingConfiguration.getInstance().getRatingStage(stage), MIN);
    }

    /*public static RatingAdjust fixedAmount(Observable<BigDecimal> amountObservable, String stage) {
        RatingAdjust ratingAdjust = new RatingAdjust(amountObservable, RatingConfiguration.getInstance().getRatingStage(stage));
        return ratingAdjust;
    }*/

    public RatingStage getRatingStage() {
        return ratingStage;
    }

    public void setRatingStage(RatingStage ratingStage) {
        this.ratingStage = ratingStage;
    }

    public BigDecimal getAdjustmentFactor() {
        return adjustmentFactor;
    }

    public void setAdjustmentFactor(BigDecimal adjustmentFactor) {
        this.adjustmentFactor = adjustmentFactor;
    }

    public int getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(int adjustmentType) {
        this.adjustmentType = adjustmentType;
    }
}
