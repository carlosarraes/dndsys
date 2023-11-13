package com.carraes.dndsys.controllers;

import com.carraes.dndsys.models.Weapon;
import com.carraes.dndsys.services.WeaponService;
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
@RequestMapping("/armas")
public class WeaponController {
  @Autowired private WeaponService weaponService;

  @GetMapping("")
  public ResponseEntity<?> getAll() {
    List<Weapon> armas =
        StreamSupport.stream(weaponService.findAll().spliterator(), false)
            .collect(Collectors.toList());

    return ResponseEntity.ok(armas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    Weapon arma = weaponService.findById(id);

    return ResponseEntity.ok(arma);
  }

  @PostMapping("")
  public ResponseEntity<?> create(@RequestBody Weapon arma) {
    Integer id = weaponService.create(arma);

    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    weaponService.delete(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Weapon arma) {
    weaponService.update(id, arma);

    return ResponseEntity.ok().build();
  }
}
