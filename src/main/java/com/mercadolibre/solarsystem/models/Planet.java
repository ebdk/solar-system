package com.mercadolibre.solarsystem.models;

import java.awt.geom.Point2D;

public class Planet {

    private String name;
    private TypeOfMovement typeOfMovement;
    private double radius;
    private int angularSpeed;
    private Point2D position;

    public Planet(String name, TypeOfMovement typeOfMovement, double radius, int angularSpeed, Point2D position) {
        this.name = name;
        this.typeOfMovement = typeOfMovement;
        this.radius = radius;
        this.angularSpeed = angularSpeed;
        this.position = position;
    }

    public void moveForGivenDays(int days) {




    }

}
