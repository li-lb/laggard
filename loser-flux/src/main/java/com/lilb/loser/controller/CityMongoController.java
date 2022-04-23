package com.lilb.loser.controller;

import com.lilb.loser.entity.City;
import com.lilb.loser.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/cityMongo")
public class CityMongoController {

    @Autowired
    private CityServiceImpl cityHandler;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Mono<City> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }
}