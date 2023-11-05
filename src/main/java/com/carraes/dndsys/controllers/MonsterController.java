package com.carraes.dndsys.controllers;

import com.carraes.dndsys.models.Monstro;
import com.carraes.dndsys.services.MonstroService;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {
  @Autowired private MonstroService monstroService;

  @GetMapping("/monstros")
  public ResponseEntity<?> getAll() {
    try {
      List<Monstro> monstros =
          StreamSupport.stream(monstroService.findAll().spliterator(), false)
              .collect(Collectors.toList());

      return ResponseEntity.ok(monstros);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Collections.singletonMap("error", e.getMessage()));
    }
  }

  @GetMapping("/monstros/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    try {
      Monstro monstro = monstroService.findById(id);

      return ResponseEntity.ok(monstro);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Collections.singletonMap("error", e.getMessage()));
    }
  }

  @PostMapping("/monstros")
  public ResponseEntity<?> create(@RequestBody Monstro monstro) {
    try {
      Integer id = monstroService.create(monstro);

      return ResponseEntity.ok(id);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(Collections.singletonMap("error", e.getMessage()));
    }
  }

  @DeleteMapping("/monstros/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    try {
      monstroService.delete(id);

      return ResponseEntity.ok().build();
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Collections.singletonMap("error", e.getMessage()));
    }
  }

  @PutMapping("/monstros/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Monstro monstro) {
    try {
      monstroService.update(id, monstro);

      return ResponseEntity.ok().build();
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Collections.singletonMap("error", e.getMessage()));
    }
  }
}
