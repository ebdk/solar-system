package com.mercadolibre.solarsystem.factories;

import com.mercadolibre.solarsystem.models.Weather;
import com.mercadolibre.solarsystem.models.Weather.Type;

public class WeatherFactory {

    public static Weather createWeather(Type weatherType) {
        return new Weather(weatherType, weatherType.getDefaultPrecipitation());
    }

    public static Weather createRainyWeather(double precipitation) {
        return new Weather(Type.RAINY, precipitation);
    }

}
