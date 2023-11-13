package com.carraes.dndsys.services;

import com.carraes.dndsys.models.Weapon;
import com.carraes.dndsys.repositories.WeaponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {
  @Autowired private WeaponRepository weaponRepository;

  public Iterable<Weapon> findAll() {
    return weaponRepository.findAll();
  }

  public Weapon findById(Integer id) {
    return weaponRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Arma não encontrada"));
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
            .orElseThrow(() -> new EntityNotFoundException("Arma não encontrada"));

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
            .orElseThrow(() -> new EntityNotFoundException("Arma não encontrada"));

    weaponRepository.delete(weaponToDelete);
  }
}
