package com.carraes.dndsys.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_personagem", discriminatorType = DiscriminatorType.STRING)
@Table(name = "personagens")
public abstract class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private String descricao;
  private Integer nivel;

  public Character() {}

  public Character(String nome, String descricao, Integer nivel) {
    this.nome = nome;
    this.descricao = descricao;
    this.nivel = nivel;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  @Override
  public String toString() {
    return "Personagem [descricao="
        + descricao
        + ", id="
        + id
        + ", nivel="
        + nivel
        + ", nome="
        + nome
        + "]";
  }
}
