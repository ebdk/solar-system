package com.mercadolibre.solarsystem.entity;

import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.models.Day;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DayEntity {

    //ATTRIBUTES
    @Id
    private Long date;

    private String weather;
    private double precipiation;

    public DayEntity(Long date, String weather, double precipiation) {
        this.date = date;
        this.weather = weather;
        this.precipiation = precipiation;
    }

    public DayEntity(DetailedDayDto day) {
        this.date = Long.valueOf(day.getDate());
        this.weather = day.getWeather();
        this.precipiation = day.getPrecipiation();
    }

    public DayEntity(Day day) {
        this.date = Long.valueOf(day.getDate());
        this.weather = day.getWeatherType();
        this.precipiation = day.getWeatherPrecipitation();
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
