package com.carraes.dndsys.repositories;

import com.carraes.dndsys.models.Monstro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonstroRepository extends CrudRepository<Monstro, Integer> {}
