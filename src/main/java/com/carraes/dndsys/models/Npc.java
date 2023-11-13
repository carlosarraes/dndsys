package com.carraes.dndsys.models;

import jakarta.persistence.Entity;

@Entity
public class Npc extends Character {
  private String classe;
  private Boolean mercador;

  public Npc() {}

  public Npc(String nome, String descricao, Integer nivel, String classe, Boolean mercador) {
    super(nome, descricao, nivel);
    this.classe = classe;
    this.mercador = mercador;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public Boolean getMercador() {
    return mercador;
  }

  public void setMercador(Boolean mercador) {
    this.mercador = mercador;
  }
}
