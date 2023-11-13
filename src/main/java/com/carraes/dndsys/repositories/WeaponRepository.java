package com.carraes.dndsys.repositories;

import com.carraes.dndsys.models.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Integer> {}
