package com.mercadolibre.solarsystem.models;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.stream.Collectors;

public class SolarSystem {

    private List<Planet> planets;
    private static Point2D sunPosition;
    private int day;

    public void movePlanetsGivenDays(int days) {
        this.day = days;
        planets.forEach(planet -> planet.moveGivenDays(days));
    }

    public SolarSystem(List<Planet> planets) {
        this.planets = planets;
        this.day = 0;
        sunPosition = new Point2D.Double(0.0d, 0.0d);
    }

    public List<Point2D> getPlanetsPositions() {
        return planets.stream().map(Planet::getPosition).collect(Collectors.toList());
    }

    public static Point2D getSunPosition() {
        return sunPosition;
    }

    public int getDay() {
        return day;
    }

    public void reset() {
        this.day = 0;
        planets.forEach(Planet::reset);
    }
}
