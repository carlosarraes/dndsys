package com.carraes.dndsys;

import com.carraes.dndsys.models.Monstro;
import com.carraes.dndsys.services.MonstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
  @Autowired private MonstroService monstroService;

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
    };
  }
}
