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
    if (!monstroRepository.existsById(id)) {
      throw new RuntimeException("Monstro não encontrado");
    }

    return monstroRepository.findById(id).get();
  }

  public Integer create(Monstro monstro) {
    System.out.println(monstro);
    Monstro newMonster = monstroRepository.save(monstro);

    return newMonster.getId();
  }

  public void update(Integer id, Monstro monstro) {
    Monstro monstroToUpdate = monstroRepository.findById(id).get();
    if (monstroToUpdate == null) {
      throw new RuntimeException("Monstro não encontrado");
    }

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
    if (!monstroRepository.existsById(id)) {
      throw new RuntimeException("Monstro não encontrado");
    }

    monstroRepository.deleteById(id);
  }
}
