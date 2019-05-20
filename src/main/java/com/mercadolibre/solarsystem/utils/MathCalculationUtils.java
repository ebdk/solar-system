package com.mercadolibre.solarsystem.utils;

import java.awt.geom.Point2D;

public class MathCalculationUtils {

  public static double getLineSlope(final Point2D point1, final Point2D point2) {
    return (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
  }

  public static double triangleArea(final Point2D point1, final Point2D point2, final Point2D point3) {
    return Math.abs(
        (point1.getX() * (point2.getY() - point3.getY())
            + point2.getX() * (point3.getY() - point1.getY())
            + point3.getX() * (point1.getY() - point2.getY())
        ) / 2.0d
    );
  }

  public static double trianglePerimeter(final Point2D point1, final Point2D point2, final Point2D point3) {
    return point1.distance(point2) + point2.distance(point3) + point3.distance(point1);
  }
}
