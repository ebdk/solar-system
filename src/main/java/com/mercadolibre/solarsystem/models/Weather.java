package com.mercadolibre.solarsystem.models;

public class Weather {

    private com.mercadolibre.solarsystem.models.Weather.Type weather;
    private double precipitation;

    public enum Type {
        RAINY(100),
        DRY(0),
        IDEAL(50),
        COMMON(20);

        private int defaultPrecipitation;

        Type(int defaultPrecipitation) {
            this.defaultPrecipitation = defaultPrecipitation;
        }

        public int getDefaultPrecipitation() {
            return this.defaultPrecipitation;
        }
    }

    public Weather(String weather, double precipitation) {
        this.weather = com.mercadolibre.solarsystem.models.Weather.Type.valueOf(weather);
        this.precipitation = precipitation;
    }

    public Weather(com.mercadolibre.solarsystem.models.Weather.Type weather, double precipitation) {
        this.weather = weather;
        this.precipitation = precipitation;
    }

    public com.mercadolibre.solarsystem.models.Weather.Type getWeather() {
        return weather;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}
