package br.com.estudo.estoque.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Categoria{
  @Id
  @GeneratedValue
  private Long id;
  private String nome;

  public Long getId(){
    return id;
  }

  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }

  public Categoria(){
  }

  public Categoria(String nome){
    this.nome = nome;
  }
}
