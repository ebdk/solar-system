package com.mercadolibre.solarsystem.controller;

import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.dtos.MessageResponse;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService service;

    @GetMapping(value = "testHelloMessage")
    public MessageResponse sayHello() {
        return service.sayHello();
    }

    @GetMapping(value = "inject")
    public MessageResponse injectDays() {
        return service.mockDays();
    }

    @PostMapping
    public MessageResponse saveDay(@RequestBody DetailedDayDto day) {
        return service.saveDay(day);
    }

    @GetMapping(path="/{date}")
    public Day getDay(@PathVariable("date") Long date) {
        return service.getDay(date);
    }

    @GetMapping
    public List<Day> getAll() {
        return service.getAll();
    }

}
