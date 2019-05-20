package com.mercadolibre.solarsystem.models.conditions;

import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.Weather.Type;

public class CommonCondition extends WeatherCondition {

  public CommonCondition(Type weatherType) {
    super(weatherType);
  }

  @Override
  public boolean isOfCondition(SolarSystem solarSystem) {
    return false;
  }

}
