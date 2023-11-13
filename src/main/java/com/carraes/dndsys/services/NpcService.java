package com.carraes.dndsys.services;

import com.carraes.dndsys.models.Npc;
import com.carraes.dndsys.repositories.NpcRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcService {
  private String npcNotFoundMessage = "NPC não encontrado";
  @Autowired private NpcRepository npcRepository;

  public Iterable<Npc> findAll() {
    return npcRepository.findAll();
  }

  public Npc findById(Integer id) {
    return npcRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(npcNotFoundMessage));
  }

  public Integer create(Npc npc) {
    Npc newNpc = npcRepository.save(npc);

    return newNpc.getId();
  }

  public void update(Integer id, Npc npc) {
    Npc npcToUpdate =
        npcRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(npcNotFoundMessage));

    npcToUpdate.setNome(npc.getNome());
    npcToUpdate.setDescricao(npc.getDescricao());
    npcToUpdate.setNivel(npc.getNivel());
    npcToUpdate.setClasse(npc.getClasse());
    npcToUpdate.setMercador(npc.getMercador());

    npcRepository.save(npcToUpdate);
  }

  public void delete(Integer id) {
    Npc npcToDelete =
        npcRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(npcNotFoundMessage));

    npcRepository.delete(npcToDelete);
  }
}
