package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather.Type;

import java.awt.geom.Point2D;
import java.util.List;

public class DroughtCondition extends SlopeRealtedCondition {


  public DroughtCondition(Type weatherType) {
    super(weatherType);
  }

  @Override
  public boolean isOfCondition(List<Point2D> points) {
    Point2D center = SolarSystem.getSunPosition();
    Point2D A = points.get(0);
    Point2D B = points.get(1);
    Point2D C = points.get(2);
    return arePlanetsAndCenterCollinear(center, A, B, C);
  }

  private boolean arePlanetsAndCenterCollinear(Point2D center, Point2D A, Point2D B, Point2D C) {
    double slopeCenternA = getLineSlope(center, A);
    double slopeAnB = getLineSlope(A, B);
    return (slopeCenternA == slopeAnB) && (arePlanetsCollinear( A,  B,  C));
  }

}
