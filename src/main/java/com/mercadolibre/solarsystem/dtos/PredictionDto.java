package com.mercadolibre.solarsystem.dtos;

public class PredictionDto {

    private int periodOfOptimalDays;
    private int periodOfDroughtDays;
    private int periodOfRainyDays;
    private DetailedDayDto mostRainyday;

    public PredictionDto(int periodOfOptimalDays, int periodOfDroughtDays, int periodOfRainyDays, com.mercadolibre.solarsystem.dtos.DetailedDayDto mostRainyday) {
        this.periodOfOptimalDays = periodOfOptimalDays;
        this.periodOfDroughtDays = periodOfDroughtDays;
        this.periodOfRainyDays = periodOfRainyDays;
        this.mostRainyday = mostRainyday;
    }

    public PredictionDto() {
    }

    public int getPeriodOfOptimalDays() {
        return periodOfOptimalDays;
    }

    public int getPeriodOfDroughtDays() {
        return periodOfDroughtDays;
    }

    public int getPeriodOfRainyDays() {
        return periodOfRainyDays;
    }

    public com.mercadolibre.solarsystem.dtos.DetailedDayDto getMostRainyday() {
        return mostRainyday;
    }
}
