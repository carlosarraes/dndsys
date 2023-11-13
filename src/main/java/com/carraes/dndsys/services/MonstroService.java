package com.carraes.dndsys.services;

import com.carraes.dndsys.models.Monstro;
import com.carraes.dndsys.repositories.MonstroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonstroService {
  @Autowired private MonstroRepository monstroRepository;

  public Iterable<Monstro> findAll() {
    return monstroRepository.findAll();
  }

  public Monstro findById(Integer id) {
    return monstroRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Monstro não encontrado"));
  }

  public Integer create(Monstro monstro) {
    Monstro newMonster = monstroRepository.save(monstro);

    return newMonster.getId();
  }

  public void update(Integer id, Monstro monstro) {
    Monstro monstroToUpdate =
        monstroRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Monstro não encontrado"));

    monstroToUpdate.setNome(monstro.getNome());
    monstroToUpdate.setDescricao(monstro.getDescricao());
    monstroToUpdate.setTipo(monstro.getTipo());
    monstroToUpdate.setTamanho(monstro.getTamanho());
    monstroToUpdate.setPontosDeVida(monstro.getPontosDeVida());
    monstroToUpdate.setDano(monstro.getDano());
    monstroToUpdate.setChefe(monstro.getChefe());

    monstroRepository.save(monstroToUpdate);
  }

  public void delete(Integer id) {
    Monstro monstroToDelete =
        monstroRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Monstro não encontrado"));

    monstroRepository.delete(monstroToDelete);
  }
}
