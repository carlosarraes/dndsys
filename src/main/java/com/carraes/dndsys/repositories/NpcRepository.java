package com.carraes.dndsys.repositories;

import com.carraes.dndsys.models.Npc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcRepository extends CrudRepository<Npc, Integer> {}
