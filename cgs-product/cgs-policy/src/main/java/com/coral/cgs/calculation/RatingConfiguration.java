package com.coral.cgs.calculation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by ccc on 2018/5/23.
 */
public class RatingConfiguration {

    private static RatingConfiguration INSTANCE = new RatingConfiguration();

    public static RatingConfiguration getInstance() {
        return INSTANCE;
    }

    private final Map<String, RatingStage> ratingStages = Maps.newHashMap();

    private List<RatingStage> sortedRatingStages = Lists.newArrayList();

    private RatingConfiguration() {
        String[] stages = {"SGP","POI","MIN","NGP"};
        RatingStage previousStage = null;
        for(String stage : stages) {
            RatingStage ratingStage = new RatingStage(stage, previousStage);
            sortedRatingStages.add(ratingStage);
            ratingStages.put(stage, ratingStage);
        }
    }

    public List<RatingStage> getSortedRatingStages() {
        return sortedRatingStages;
    }

    public void setSortedRatingStages(List<RatingStage> sortedRatingStages) {
        this.sortedRatingStages = sortedRatingStages;
    }

    public RatingStage getRatingStage(String stage) {
        return ratingStages.get(stage);
    }
}
