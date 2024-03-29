package com.lilb.service.impl;

import com.lilb.dao.CityRepository;
import com.lilb.entity.City;
import com.lilb.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public Mono<City> save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Mono<City> findCityById(Long id) {

        return cityRepository.findById(id);
    }

    @Override
    public Flux<City> findAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public Mono<City> modifyCity(City city) {

        return cityRepository.save(city);
    }

    @Override
    public Mono<Long> deleteCity(Long id) {
        cityRepository.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }
}