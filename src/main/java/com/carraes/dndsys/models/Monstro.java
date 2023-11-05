package com.carraes.dndsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monstros")
public class Monstro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private String descricao;
  private String tipo;
  private String tamanho;

  private Integer pontosDeVida;
  private Integer dano;

  private Boolean chefe;

  public Monstro() {}

  public Monstro(
      String nome,
      String descricao,
      String tipo,
      String tamanho,
      Integer pontosDeVida,
      Integer dano,
      Boolean chefe) {
    this.nome = nome;
    this.descricao = descricao;
    this.tipo = tipo;
    this.tamanho = tamanho;
    this.pontosDeVida = pontosDeVida;
    this.dano = dano;
    this.chefe = chefe;
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

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getTamanho() {
    return tamanho;
  }

  public void setTamanho(String tamanho) {
    this.tamanho = tamanho;
  }

  public Integer getPontosDeVida() {
    return pontosDeVida;
  }

  public void setPontosDeVida(Integer pontosDeVida) {
    this.pontosDeVida = pontosDeVida;
  }

  public Integer getDano() {
    return dano;
  }

  public void setDano(Integer dano) {
    this.dano = dano;
  }

  public Boolean getChefe() {
    return chefe;
  }

  public void setChefe(Boolean chefe) {
    this.chefe = chefe;
  }

  @Override
  public String toString() {
    return "Monstro [chefe="
        + chefe
        + ", dano="
        + dano
        + ", descricao="
        + descricao
        + ", id="
        + id
        + ", nome="
        + nome
        + ", pontosDeVida="
        + pontosDeVida
        + ", tamanho="
        + tamanho
        + ", tipo="
        + tipo
        + "]";
  }
}
