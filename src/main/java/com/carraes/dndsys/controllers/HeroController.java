package com.carraes.dndsys.controllers;

import com.carraes.dndsys.dto.CreateResponse;
import com.carraes.dndsys.models.Hero;
import com.carraes.dndsys.services.HeroService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/herois")
public class HeroController {
  @Autowired private HeroService heroService;

  @GetMapping("")
  public ResponseEntity<?> getAll() {
    List<Hero> herois =
        StreamSupport.stream(heroService.findAll().spliterator(), false)
            .collect(Collectors.toList());

    return ResponseEntity.ok(herois);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    Hero heroi = heroService.findById(id);

    return ResponseEntity.ok(heroi);
  }

  @PostMapping("")
  public ResponseEntity<?> create(@RequestBody Hero heroi) {
    Integer id = heroService.create(heroi);

    CreateResponse response = new CreateResponse("Herói criado com id " + id);

    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{heroId}/add/{weaponId}")
  public ResponseEntity<?> addWeapon(@PathVariable Integer heroId, @PathVariable Integer weaponId) {
    heroService.assignWeapon(heroId, weaponId);

    CreateResponse response = new CreateResponse("Arma adicionada ao herói com id " + heroId);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    heroService.delete(id);

    CreateResponse response = new CreateResponse("Herói com id " + id + " deletado com sucesso");

    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Hero heroi) {
    heroService.update(id, heroi);

    CreateResponse response = new CreateResponse("Herói com id " + id + " atualizado com sucesso");

    return ResponseEntity.ok(response);
  }
}
