package com.carraes.dndsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "herois")
public class Hero extends Character {
  private Integer pontosDeVida;
  private String classe;

  @ManyToOne
  @JoinColumn(name = "arma_id")
  private Weapon arma;

  public Hero() {}

  public Hero(String nome, String descricao, Integer nivel, Integer pontosDeVida, String classe) {
    super(nome, descricao, nivel);
    this.pontosDeVida = pontosDeVida;
    this.classe = classe;
  }

  public Integer getPontosDeVida() {
    return pontosDeVida;
  }

  public void setPontosDeVida(Integer pontosDeVida) {
    this.pontosDeVida = pontosDeVida;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public Weapon getArma() {
    return arma;
  }

  public void setArma(Weapon arma) {
    this.arma = arma;
  }
}
