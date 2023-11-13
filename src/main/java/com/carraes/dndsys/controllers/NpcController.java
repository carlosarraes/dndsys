package com.carraes.dndsys.controllers;

import com.carraes.dndsys.models.Npc;
import com.carraes.dndsys.services.NpcService;
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
@RequestMapping("/npcs")
public class NpcController {
  @Autowired private NpcService npcService;

  @GetMapping("")
  public ResponseEntity<?> getAll() {
    List<Npc> npcs =
        StreamSupport.stream(npcService.findAll().spliterator(), false)
            .collect(Collectors.toList());

    return ResponseEntity.ok(npcs);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    Npc npc = npcService.findById(id);

    return ResponseEntity.ok(npc);
  }

  @PostMapping("")
  public ResponseEntity<?> create(@RequestBody Npc npc) {
    Integer id = npcService.create(npc);

    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    npcService.delete(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Npc npc) {
    npcService.update(id, npc);

    return ResponseEntity.ok().build();
  }
}
