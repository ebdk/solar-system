package com.mercadolibre.solarsystem.dtos;

import com.mercadolibre.solarsystem.models.Day;

public class DetailedDayDto extends DayDto {

    private double precipiation;

    public DetailedDayDto(Day day) {
        super(day);
        this.precipiation = day.getPrecipitation();
    }

    public DetailedDayDto() {
    }

    public double getPrecipiation() {
        return precipiation;
    }
}
