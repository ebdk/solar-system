package com.mercadolibre.solarsystem.controller;

import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.dtos.MessageResponse;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/day")
public class DayController {

    @Autowired
    private DayService service;

    @GetMapping
    public List<Day> getAll() {
        return service.getAll();
    }

}
