package com.lilb.laggard.controller;

import com.lilb.laggard.entity.City;
import com.lilb.laggard.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/cityMongo")
public class CityMongoController {

    @Autowired
    private CityService cityService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Flux<City> findAllCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Mono<City> saveCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityService.modifyCity(city);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityService.deleteCity(id);
    }
}