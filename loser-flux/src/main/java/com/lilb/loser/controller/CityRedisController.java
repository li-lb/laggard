package com.lilb.loser.controller;

import com.lilb.loser.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/cityRedis")
public class CityRedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        City city = operations.get(key);

        if (!hasKey) {
            return Mono.create(monoSink -> monoSink.success(null));
        }
        return Mono.create(monoSink -> monoSink.success(city));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Mono<City> saveCity(@RequestBody City city) {
        String key = "city_" + city.getId();
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        operations.set(key, city, 6000, TimeUnit.SECONDS);

        return Mono.create(monoSink -> monoSink.success(city));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
        return Mono.create(monoSink -> monoSink.success(id));
    }
}