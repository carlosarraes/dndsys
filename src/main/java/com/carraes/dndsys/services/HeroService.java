package com.carraes.dndsys.services;

import com.carraes.dndsys.models.Hero;
import com.carraes.dndsys.repositories.HeroRepository;
import com.carraes.dndsys.repositories.WeaponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
  private String heroNotFoundMessage = "Herói não encontrado";
  private String weaponNotFoundMessage = "Arma não encontrada";

  @Autowired private HeroRepository heroRepository;
  @Autowired private WeaponRepository weaponRepository;

  public Iterable<Hero> findAll() {
    return heroRepository.findAll();
  }

  public Hero findById(Integer id) {
    return heroRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(heroNotFoundMessage));
  }

  @Transactional
  public Integer create(Hero hero) {
    Hero newHero = heroRepository.save(hero);

    return newHero.getId();
  }

  @Transactional
  public void assignWeapon(Integer id, Integer weaponId) {
    Hero heroToUpdate =
        heroRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(heroNotFoundMessage));

    heroToUpdate.setArma(
        weaponRepository
            .findById(weaponId)
            .orElseThrow(() -> new EntityNotFoundException(weaponNotFoundMessage)));

    heroRepository.save(heroToUpdate);
  }

  @Transactional
  public void update(Integer id, Hero hero) {
    Hero heroToUpdate =
        heroRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(heroNotFoundMessage));

    heroToUpdate.setNome(hero.getNome());
    heroToUpdate.setDescricao(hero.getDescricao());
    heroToUpdate.setNivel(hero.getNivel());
    heroToUpdate.setPontosDeVida(hero.getPontosDeVida());
    heroToUpdate.setClasse(hero.getClasse());

    heroRepository.save(heroToUpdate);
  }

  @Transactional
  public void delete(Integer id) {
    Hero heroToDelete =
        heroRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(heroNotFoundMessage));

    heroRepository.delete(heroToDelete);
  }
}
