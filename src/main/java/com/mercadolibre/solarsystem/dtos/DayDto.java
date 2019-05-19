package com.mercadolibre.solarsystem.dtos;

public class DayDto {

    private int date;
    private String weather;

    public DayDto(com.mercadolibre.solarsystem.models.Day day) {
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
