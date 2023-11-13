package com.carraes.dndsys.controllers;

import com.carraes.dndsys.dto.CreateResponse;
import com.carraes.dndsys.models.Monstro;
import com.carraes.dndsys.services.MonstroService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monstros")
public class MonsterController {
  @Autowired private MonstroService monstroService;

  @GetMapping("")
  public ResponseEntity<?> getAll() {
    List<Monstro> monstros =
        StreamSupport.stream(monstroService.findAll().spliterator(), false)
            .collect(Collectors.toList());

    return ResponseEntity.ok(monstros);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    Monstro monstro = monstroService.findById(id);

    return ResponseEntity.ok(monstro);
  }

  @PostMapping("")
  public ResponseEntity<?> create(@RequestBody Monstro monstro) {
    Integer id = monstroService.create(monstro);

    CreateResponse response = new CreateResponse("Monstro criado com id " + id);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    monstroService.delete(id);

    CreateResponse response = new CreateResponse("Monstro com id " + id + " deletado com sucesso");

    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Monstro monstro) {
    monstroService.update(id, monstro);

    CreateResponse response =
        new CreateResponse("Monstro com id " + id + " atualizado com sucesso");

    return ResponseEntity.ok(response);
  }
}
