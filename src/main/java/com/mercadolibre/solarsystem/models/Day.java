package com.mercadolibre.solarsystem.models;

import com.mercadolibre.solarsystem.entity.DayEntity;
import com.mercadolibre.solarsystem.models.Weather.Type;

public class Day {

    private int date;
    private Weather weather;

    public Day(DayEntity entity) {
        this.date = Math.toIntExact(entity.getDate());
        this.weather = new Weather(entity.getWeather(), entity.getPrecipiation());
    }

    public Day(int date, Type weather, double precipitation) {
        this.date = date;
        this.weather = new Weather(weather, precipitation);
    }

    public Day(int date, com.mercadolibre.solarsystem.models.Weather weather) {
        this.date = date;
        this.weather = weather;
    }

    public int getDate() {
        return date;
    }

    public Type getWeather() {
        return weather.getWeather();
    }

    public double getPrecipitation() {
        return weather.getPrecipitation();
    }

}
