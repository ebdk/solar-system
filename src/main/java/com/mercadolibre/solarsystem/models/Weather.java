package com.mercadolibre.solarsystem.models;

public class Weather {

    private TypeOfWeather weather;
    private double precipitation;



    public enum TypeOfWeather {
        RAINY,
        DRY,
        IDEAL,
        COMMON
    }

    public Weather(String weather, double precipitation) {
        this.weather = TypeOfWeather.valueOf(weather);
        this.precipitation = precipitation;
    }

    public Weather(com.mercadolibre.solarsystem.models.Weather.TypeOfWeather weather, double precipitation) {
        this.weather = weather;
        this.precipitation = precipitation;
    }

    public com.mercadolibre.solarsystem.models.Weather.TypeOfWeather getWeather() {
        return weather;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}
