package com.mercadolibre.solarsystem.controller;

import com.mercadolibre.solarsystem.dtos.MessageResponse;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.services.DayService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/day")
public class DayController {

    @Autowired
    private DayService service;

    @ApiOperation(
            value = "Retreives all the days")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The days were retreived successfully"),
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<Day>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @ApiOperation(
            value = "Injects all the days")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The days were injected successfully"),
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> injectDays() {
        return ResponseEntity.ok(service.mockDays());
    }

}
