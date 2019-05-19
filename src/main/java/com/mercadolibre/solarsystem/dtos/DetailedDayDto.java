package com.mercadolibre.solarsystem.dtos;

public class DetailedDayDto extends com.mercadolibre.solarsystem.dtos.DayDto {

    private double precipiation;

    public DetailedDayDto(com.mercadolibre.solarsystem.models.Day day) {
        super(day);
        this.precipiation = day.getWeatherPrecipitation();
    }

    public DetailedDayDto() {
    }

    public double getPrecipiation() {
        return precipiation;
    }
}
