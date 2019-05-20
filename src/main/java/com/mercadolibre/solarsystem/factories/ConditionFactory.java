package com.mercadolibre.solarsystem.factories;

import com.google.common.collect.ImmutableList;
import com.mercadolibre.solarsystem.models.Weather.Type;
import com.mercadolibre.solarsystem.models.conditions.*;

import java.util.List;

public class ConditionFactory {

    public static CommonCondition createCommonCondition() {
        return new CommonCondition(Type.COMMON);
    }

    private static DroughtCondition createDroughtCondition() {
        return new DroughtCondition(Type.DRY);
    }

    private static OptimalCondition createOptimalCondition() {
        return new OptimalCondition(Type.IDEAL);
    }

    private static RainyCondition createRainyCondition() {
        return new RainyCondition(Type.RAINY);
    }

    public static List<WeatherCondition> createConditions() {
        return ImmutableList.of(createDroughtCondition(),
                createOptimalCondition(),
                createRainyCondition());
    }

}
