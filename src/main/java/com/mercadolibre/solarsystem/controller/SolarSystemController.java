package com.mercadolibre.solarsystem.controller;

import com.mercadolibre.solarsystem.dtos.DayDto;
import com.mercadolibre.solarsystem.dtos.PredictionDto;
import com.mercadolibre.solarsystem.services.SolarSystemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class SolarSystemController {

    @Autowired
    private SolarSystemService service;

    @ApiOperation(
            value = "Calculates the forecast of the weather condition of a given day",
            notes = "The forecast is limited to just 3650 days, or 10 years ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The forecast was calculated successfully", response = DayDto.class),
    })
    @GetMapping(path="/{day}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DayDto> forecastDay(
            @ApiParam(value = "The day that will be predicted", allowableValues = "range[1,3650]", required = true)
            @PathVariable("day") int day) {
        return ResponseEntity.ok(service.predictWeather(day));
    }

    @ApiOperation(
            value = "Calculates the forecast of the weather condition of the next 3600 days",
            notes = "This prediction includes: number of drought days, number of rainy days, "
                    + "day with maximum amount of rain and days with optimum weather conditions")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The prediction was calculated successfully", response = PredictionDto.class),
    })
    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PredictionDto> weatherForecast() {
        return ResponseEntity.ok(service.weatherForecast());
    }

}
