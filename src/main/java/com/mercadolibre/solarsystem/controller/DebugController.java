package com.mercadolibre.solarsystem.controller;

import com.mercadolibre.solarsystem.dtos.MessageDto;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.services.DayService;
import com.mercadolibre.solarsystem.services.PredictionService;
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
@RequestMapping("/api/debug")
public class DebugController {

    @Autowired
    private DayService dayService;

    @Autowired
    private PredictionService predictionService;

    @ApiOperation(
            value = "Retreives all the days")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The days were retreived successfully"),
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<Day>> getAll() {
        return ResponseEntity.ok(dayService.getAll());
    }

    @ApiOperation(
            value = "Injects mocked days")

    @ApiResponses({
            @ApiResponse(code = 200, message = "The mocked days were injected successfully"),
    })
    @PostMapping(path="/mock", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDto> injectDays() {
        return ResponseEntity.ok(dayService.mockDays());
    }

    @ApiOperation(
            value = "Predict days",
            notes = "Calculates the forecast of the weather condition of the next 3600 days")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The days were predicted successfully"),
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDto> predictDays() {
        return ResponseEntity.ok(predictionService.fullfilPrediction(3650));
    }

}
