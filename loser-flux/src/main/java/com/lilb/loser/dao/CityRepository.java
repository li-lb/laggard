package com.lilb.loser.dao;

import com.lilb.loser.entity.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {

}