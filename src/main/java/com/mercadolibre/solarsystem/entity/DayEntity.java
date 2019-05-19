package com.mercadolibre.solarsystem.entity;

import com.mercadolibre.solarsystem.models.Day;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DayEntity {

    @Id
    private Long date;

    private String weather;
    private double precipiation;

    public DayEntity(Day day) {
        this.date = Long.valueOf(day.getDate());
        this.weather = day.getWeather().toString();
        this.precipiation = day.getPrecipitation();
    }

    public DayEntity() {
    }

    public Long getDate() {
        return date;
    }

    public String getWeather() {
        return weather;
    }

    public double getPrecipiation() {
        return precipiation;
    }
}
