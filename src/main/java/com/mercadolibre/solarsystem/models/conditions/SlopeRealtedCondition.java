package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.models.Weather.Type;

import java.awt.geom.Point2D;

public abstract class SlopeRealtedCondition extends WeatherCondition {

    public SlopeRealtedCondition(Type weatherType) {
        super(weatherType);
    }

    /**
     * https://stackoverflow.com/questions/3813681/checking-to-see-if-3-points-are-on-the-same-line
     */
    public static double getLineSlope(final Point2D point1, final Point2D point2) {
        return (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
    }

    public boolean arePlanetsCollinear(Point2D A, Point2D B, Point2D C) {
        double slopeAnB = getLineSlope(A, B);
        double slopeBnC = getLineSlope(B, C);
        double slopeAnC = getLineSlope(A, C);
        return (slopeAnB == slopeBnC)
                && (slopeAnC == slopeBnC);
    }

}
