package com.mercadolibre.solarsystem.dtos;

public class PredictionDto {

    private int optimalDays;
    private int droughtDays;
    private int rainyDays;
    private DetailedDayDto mostRainyday;

    public PredictionDto(int optimalDays, int droughtDays, int rainyDays, DetailedDayDto mostRainyday) {
        this.optimalDays = optimalDays;
        this.droughtDays = droughtDays;
        this.rainyDays = rainyDays;
        this.mostRainyday = mostRainyday;
    }

    public PredictionDto() {
    }

    public int getOptimalDays() {
        return optimalDays;
    }

    public int getDroughtDays() {
        return droughtDays;
    }

    public int getRainyDays() {
        return rainyDays;
    }

    public DetailedDayDto getMostRainyday() {
        return mostRainyday;
    }
}
