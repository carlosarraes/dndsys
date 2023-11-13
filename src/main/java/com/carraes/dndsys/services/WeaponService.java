package com.carraes.dndsys.services;

import com.carraes.dndsys.exceptions.ItemInUseException;
import com.carraes.dndsys.models.Weapon;
import com.carraes.dndsys.repositories.HeroRepository;
import com.carraes.dndsys.repositories.WeaponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {
  private String weaponNotFound = "Arma não encontrada";
  @Autowired private WeaponRepository weaponRepository;
  @Autowired private HeroRepository heroRepository;

  public Iterable<Weapon> findAll() {
    return weaponRepository.findAll();
  }

  public Weapon findById(Integer id) {
    return weaponRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(weaponNotFound));
  }

  @Transactional
  public Integer create(Weapon weapon) {
    Weapon newWeapon = weaponRepository.save(weapon);

    return newWeapon.getId();
  }

  @Transactional
  public void update(Integer id, Weapon weapon) {
    Weapon weaponToUpdate =
        weaponRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(weaponNotFound));

    weaponToUpdate.setNome(weapon.getNome());
    weaponToUpdate.setDano(weapon.getDano());
    weaponToUpdate.setTipo(weapon.getTipo());

    weaponRepository.save(weaponToUpdate);
  }

  @Transactional
  public void delete(Integer id) {
    Weapon weaponToDelete =
        weaponRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(weaponNotFound));

    if (heroRepository.findByArma_Id(id) != null) {
      throw new ItemInUseException("Arma está sendo usada por um herói");
    }

    weaponRepository.delete(weaponToDelete);
  }
}
