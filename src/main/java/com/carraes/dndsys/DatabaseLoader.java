package com.carraes.dndsys;

import com.carraes.dndsys.models.Hero;
import com.carraes.dndsys.models.Monstro;
import com.carraes.dndsys.models.Npc;
import com.carraes.dndsys.models.Weapon;
import com.carraes.dndsys.services.HeroService;
import com.carraes.dndsys.services.MonstroService;
import com.carraes.dndsys.services.NpcService;
import com.carraes.dndsys.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
  @Autowired private MonstroService monstroService;
  @Autowired private WeaponService weaponService;
  @Autowired private HeroService heroService;
  @Autowired private NpcService npcService;

  @Bean
  CommandLineRunner initDatabase() {
    return args -> {
      monstroService.create(
          new Monstro(
              "Goblin",
              "Uma criatura verde pequena e maliciosa",
              "Humanoide",
              "Pequeno",
              7,
              5,
              false));

      weaponService.create(new Weapon(10, "Corte", "Espada curta"));

      heroService.create(
          new Hero("Adam", "Um guerreiro com uma espada curta", 1, 100, "Guerreiro"));
      heroService.assignWeapon(1, 1);

      npcService.create(new Npc("Alan", "Um mercante viajante", 1, "Ferreiro", true));
    };
  }
}
