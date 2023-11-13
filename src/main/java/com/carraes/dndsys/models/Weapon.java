package com.carraes.dndsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Weapon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer dano;
  private String tipo;
  private String nome;

  @OneToOne private Hero hero;

  public Weapon() {}

  public Weapon(Integer dano, String tipo, String nome) {
    this.dano = dano;
    this.tipo = tipo;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDano() {
    return dano;
  }

  public void setDano(Integer dano) {
    this.dano = dano;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Hero getHero() {
    return hero;
  }

  public void setHero(Hero hero) {
    this.hero = hero;
  }

  @Override
  public String toString() {
    return "Weapon [dano="
        + dano
        + ", hero="
        + hero
        + ", id="
        + id
        + ", nome="
        + nome
        + ", tipo="
        + tipo
        + "]";
  }
}
