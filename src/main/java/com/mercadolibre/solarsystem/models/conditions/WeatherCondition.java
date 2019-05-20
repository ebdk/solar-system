package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.factories.WeatherFactory;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather;
import com.mercadolibre.solarsystem.models.Weather.Type;

public abstract class WeatherCondition {

    private Type weatherType;

    public WeatherCondition(Type weatherType) {
        this.weatherType = weatherType;
    }

    /**
     * Checks if it can getWeather the weather for the galaxy's solar system in it current day applying the rule for the
     * corresponding weather type.
     *
     * @param solarSystem The solary system to be checked. It cannot be null.
     * @return <b><true</b> if it can getWeather weather for galaxy's solar system in its current day; otherwise, it returns
     * <b>false</b>.
     */
    public abstract boolean isOfCondition(final SolarSystem solarSystem);

    /**
     * Resolves the weather of the galaxy's current day of the corresponding weather type.
     *
     * @return The weather of the galaxy's current day of the corresponding weather type. It's never null.
     * @param solarSystem
     */
    public Weather getWeather(SolarSystem solarSystem) {
        return WeatherFactory.createWeather(weatherType);
    }

}
