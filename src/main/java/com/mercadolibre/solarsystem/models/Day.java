package com.mercadolibre.solarsystem.models;

public class Day {

    private int date;
    private Weather weather;

    public Day(int date, String weather, double precipitation) {
        this.date = date;
        this.weather = new Weather(weather, precipitation);
    }

    public Day(com.mercadolibre.solarsystem.entity.DayEntity entity) {
        this.date = Math.toIntExact(entity.getDate());
        this.weather = new Weather(entity.getWeather(), entity.getPrecipiation());
    }

    public Day(int date, Weather.TypeOfWeather weather, double precipitation) {
        this.date = date;
        this.weather = new Weather(weather, precipitation);
    }

    public int getDate() {
        return date;
    }

    public String getWeatherType() {
        return weather.getWeather().toString();
    }

    public double getWeatherPrecipitation() {
        return weather.getPrecipitation();
    }

}
