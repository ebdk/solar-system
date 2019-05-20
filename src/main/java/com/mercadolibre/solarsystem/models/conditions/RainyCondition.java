package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.factories.WeatherFactory;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather;
import com.mercadolibre.solarsystem.models.Weather.Type;

import java.awt.geom.Point2D;
import java.util.List;


public class RainyCondition extends WeatherCondition {

    public RainyCondition(Type weatherType) {
        super(weatherType);
    }

    /**
     * https://www.youtube.com/watch?v=HYAgJN3x4GA
     * https://github.com/SebLague/Gamedev-Maths/blob/master/PointInTriangle.cs
     */
    @Override
    public boolean isOfCondition(List<Point2D> points) {
        Point2D center = SolarSystem.getSunPosition();
        Point2D A = points.get(0);
        Point2D B = points.get(1);
        Point2D C = points.get(2);

        double s1 = C.getY() - A.getY();
        double s2 = C.getX() - A.getX();
        double s3 = B.getY() - A.getY();
        double s4 = center.getY() - A.getY();

        double w1 = ( (A.getX() * s1 ) + (s4 * s2) - ( center.getX() * s1) ) / ( (s3 * s2 ) - ( B.getX() - A.getX() ) * s1) ;
        double w2 = ( s4 - (w1 * s3) ) / s1;
        return w1 >= 0 && w2 >= 0 && (w1 + w2) <= 1;
    }

    @Override
    public Weather getWeather(SolarSystem solarSystem) {
        double precipitation = calculatePerimeter(solarSystem.getPlanetsPositions());
        return WeatherFactory.createRainyWeather(precipitation);
    }

    /**
     * https://www.quora.com/How-do-you-find-a-triangles-perimeter-using-coordinates
     */
    private double calculatePerimeter(List<Point2D> planetsPositions) {
        Point2D A = planetsPositions.get(0);
        Point2D B = planetsPositions.get(1);
        Point2D C = planetsPositions.get(2);
        return A.distance(B) + B.distance(C) + C.distance(A);
    }

}
