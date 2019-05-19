package com.mercadolibre.solarsystem.dtos;

import com.mercadolibre.solarsystem.models.Day;

public class DayDto {

    private int date;
    private String weather;

    public DayDto(Day day) {
        this.date = day.getDate();
        this.weather = day.getWeather().toString();
    }

    public DayDto() {
    }

    public int getDate() {
        return date;
    }

    public String getWeather() {
        return weather;
    }
}
