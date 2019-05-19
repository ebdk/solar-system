package com.mercadolibre.solarsystem.services;

import com.mercadolibre.solarsystem.dtos.MessageDto;
import com.mercadolibre.solarsystem.models.Day;

import java.util.List;

public interface DayService {

    Day getDay(Long date);

    List<Day> getAll();

    MessageDto mockDays();
}
