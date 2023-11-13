package com.carraes.dndsys.repositories;

import com.carraes.dndsys.models.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer> {}
