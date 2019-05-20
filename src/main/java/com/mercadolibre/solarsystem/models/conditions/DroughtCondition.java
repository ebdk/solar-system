package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather.Type;
import com.mercadolibre.solarsystem.utils.MathCalculationUtils;

import java.awt.geom.Point2D;

public class DroughtCondition extends WeatherCondition {


  public DroughtCondition(Type weatherType) {
    super(weatherType);
  }

  @Override
  public boolean isOfCondition(SolarSystem solarSystem) {
    Point2D center = solarSystem.getSunPosition();
    Point2D firstPlanetPosition = solarSystem.getPlanetsPositions().get(0);
    Point2D secondPlanetPosition = solarSystem.getPlanetsPositions().get(1);
    Point2D thirdPlanetPosition =solarSystem.getPlanetsPositions().get(2);
    return arePlanetsAndCenterCollinear(center, firstPlanetPosition, secondPlanetPosition, thirdPlanetPosition);
  }

  private boolean arePlanetsAndCenterCollinear(Point2D center, Point2D firstPlanetPosition, Point2D secondPlanetPosition, Point2D thirdPlanetPosition) {
    double slopeCenterAndBetasoide = MathCalculationUtils.getLineSlope(center, firstPlanetPosition);
    double slopeBetasoideAndFerengi = MathCalculationUtils.getLineSlope(firstPlanetPosition, secondPlanetPosition);
    double slopeFerengiAndVulcano = MathCalculationUtils.getLineSlope(secondPlanetPosition, thirdPlanetPosition);
    return (slopeCenterAndBetasoide == slopeBetasoideAndFerengi)
        && (slopeBetasoideAndFerengi == slopeFerengiAndVulcano)
        && (slopeCenterAndBetasoide == slopeFerengiAndVulcano);
  }

}
