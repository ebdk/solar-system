package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.factories.WeatherFactory;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather;
import com.mercadolibre.solarsystem.models.Weather.Type;

import java.awt.geom.Point2D;
import java.util.List;

public abstract class WeatherCondition {

    private Type weatherType;

    public WeatherCondition(Type weatherType) {
        this.weatherType = weatherType;
    }

    public abstract boolean isOfCondition(final List<Point2D> solarSystem);

    public Weather getWeather(SolarSystem solarSystem) {
        return WeatherFactory.createWeather(weatherType);
    }

}
