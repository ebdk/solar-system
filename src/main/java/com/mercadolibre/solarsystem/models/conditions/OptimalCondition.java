package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.models.Weather.Type;

import java.awt.geom.Point2D;

public class OptimalCondition extends SlopeRealtedCondition {

  public OptimalCondition(Type weatherType) {
    super(weatherType);
  }

  @Override
  public boolean isOfCondition(java.util.List<java.awt.geom.Point2D> points) {
    Point2D center = com.mercadolibre.solarsystem.models.SolarSystem.getSunPosition();
    Point2D A = points.get(0);
    Point2D B = points.get(1);
    Point2D C = points.get(2);
    return arePlanetsNotAllinedWithCenter(center, A, B, C);
  }

  private boolean arePlanetsNotAllinedWithCenter(Point2D center, Point2D A, Point2D B, Point2D C) {
    double slopeCenternA = getLineSlope(center, A);
    double slopeAnB = getLineSlope(A, B);
    return (slopeCenternA != slopeAnB) && (arePlanetsCollinear( A,  B,  C));
  }

}
