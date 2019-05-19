package com.mercadolibre.solarsystem.services;

import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.dtos.MessageResponse;
import com.mercadolibre.solarsystem.models.Day;

import java.util.List;

public interface DayService {

    Day getDay(Long date);

    List<Day> getAll();

    com.mercadolibre.solarsystem.dtos.MessageResponse mockDays();
}
