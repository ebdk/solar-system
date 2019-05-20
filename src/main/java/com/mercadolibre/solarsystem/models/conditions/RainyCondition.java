package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.factories.WeatherFactory;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather;
import com.mercadolibre.solarsystem.models.Weather.Type;
import com.mercadolibre.solarsystem.utils.MathCalculationUtils;

import java.awt.geom.Point2D;

public class RainyCondition extends WeatherCondition {

  public RainyCondition(Type weatherType) {
    super(weatherType);
  }

  @Override
  public boolean isOfCondition(SolarSystem solarSystem) {
    Point2D center = solarSystem.getSunPosition();
    Point2D firstPlanetPosition = solarSystem.getPlanetsPositions().get(0);
    Point2D secondPlanetPosition = solarSystem.getPlanetsPositions().get(1);
    Point2D thirdPlanetPosition =solarSystem.getPlanetsPositions().get(2);
    if (!doPlanetsFormATriangle(firstPlanetPosition, secondPlanetPosition, thirdPlanetPosition)) {
      return false;
    }
    return isCenterInsidePlanetsTriangle(center, firstPlanetPosition, secondPlanetPosition, thirdPlanetPosition);
  }

  private boolean isCenterInsidePlanetsTriangle(Point2D center, Point2D firstPlanetPosition, Point2D secondPlanetPosition, Point2D thirdPlanetPosition) {
    BarycentricCoordinate barycentricCoordinate = getBarycentricCoordinate(firstPlanetPosition,
            secondPlanetPosition, thirdPlanetPosition, center);
    return (0 <= barycentricCoordinate.getA() && barycentricCoordinate.getA() <= 1)
        && (0 <= barycentricCoordinate.getB() && barycentricCoordinate.getB() <= 1)
        && (0 <= barycentricCoordinate.getC() && barycentricCoordinate.getC() <= 1);
  }

  @Override
  public Weather getWeather(SolarSystem solarSystem) {
    Point2D firstPlanetPosition = solarSystem.getPlanetsPositions().get(0);
    Point2D secondPlanetPosition = solarSystem.getPlanetsPositions().get(1);
    Point2D thirdPlanetPosition = solarSystem.getPlanetsPositions().get(2);
    double precipitation = MathCalculationUtils
        .trianglePerimeter(firstPlanetPosition, secondPlanetPosition, thirdPlanetPosition);
    return WeatherFactory.createRainyWeather(precipitation);
  }

  private boolean doPlanetsFormATriangle(Point2D firstPlanetPosition, Point2D secondPlanetPosition, Point2D thirdPlanetPosition) {
    return
        MathCalculationUtils.triangleArea(firstPlanetPosition, secondPlanetPosition, thirdPlanetPosition) != 0;
  }

  private BarycentricCoordinate getBarycentricCoordinate(final Point2D point1, final Point2D point2,
                                                         final Point2D point3, final Point2D p) {
    double denominator = ((point2.getY() - point3.getY())
        * (point1.getX() - point3.getX())
        + (point3.getX() - point2.getX())
        * (point1.getY() - point3.getY()));

    double a = ((point2.getY() - point3.getY()) * (p.getX() - point3.getX())
        + (point3.getX() - point2.getX()) * (p.getY() - point3.getY()))
        / denominator;

    double b = ((point3.getY() - point1.getY()) * (p.getX() - point3.getX())
        + (point1.getX() - point3.getX()) * (p.getY() - point3.getY()))
        / denominator;

    double c = 1 - a - b;
    return new BarycentricCoordinate(a, b, c);
  }

  private class BarycentricCoordinate {

    double a, b, c;

    public BarycentricCoordinate(double a, double b, double c) {
    }

    public double getA() {
      return a;
    }

    public double getB() {
      return b;
    }

    public double getC() {
      return c;
    }

  }

}
