package com.mercadolibre.solarsystem.models;

import org.apache.commons.math3.util.Precision;

import java.awt.geom.Point2D;

public class Planet {

    private String name;
    private MovementType movementType;
    private double distanceFromSun; //radius
    private int rotationSpeed; //angularVelocity
    private Point2D position;

    public enum MovementType {
        CLOCKWISE(-1),
        ANTI_CLOCKWISE(1);

        private int multiplier;

        MovementType(int multiplier) {
            this.multiplier = multiplier;
        }

        public int getMultiplier() {
            return this.multiplier;
        }
    }

    public Planet(String name, double distanceFromSun, int rotationSpeed, MovementType movementType) {
        this.name = name;
        this.movementType = movementType;
        this.distanceFromSun = distanceFromSun;
        this.rotationSpeed = rotationSpeed;
        this.position = new Point2D.Double(distanceFromSun, 0.0d);
    }

    public void moveGivenDays(int days) {
        double angleInDegrees = (getRotationSpeed() * days) % 360;
        if (getRotationSpeed() < 0) {
            angleInDegrees = 360 + angleInDegrees;
        }
        double radianAngle = Math.toRadians(angleInDegrees);

        double x = Precision.round(Math.cos(radianAngle) * distanceFromSun, 10);
        double y = Precision.round(Math.sin(radianAngle) * distanceFromSun, 10);

        position = new Point2D.Double(x, y);
    }

    public String getName() {
        return name;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRotationSpeed() {
        return rotationSpeed * movementType.getMultiplier();
    }

    public java.awt.geom.Point2D getPosition() {
        return position;
    }
}
