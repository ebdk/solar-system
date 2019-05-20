package com.mercadolibre.solarsystem.factories;

import com.google.common.collect.ImmutableList;
import com.mercadolibre.solarsystem.models.Planet;

import java.util.List;

import static com.mercadolibre.solarsystem.models.Planet.MovementType.ANTI_CLOCKWISE;
import static com.mercadolibre.solarsystem.models.Planet.MovementType.CLOCKWISE;

public class PlanetFactory {

    private static Planet createFerengi() {
        return new Planet("Ferengi", 500, 1, CLOCKWISE);
    }

    private static Planet createBetasoide() {
        return new Planet("Betasoide", 3000, 3,  CLOCKWISE);
    }

    private static Planet createVulcano() {
        return new Planet("Vulcano", 1000, 5, ANTI_CLOCKWISE);
    }

    public static List<Planet> createPlanets() {
        return ImmutableList.of(createBetasoide(),
                createFerengi(),
                createVulcano());
    }

}
