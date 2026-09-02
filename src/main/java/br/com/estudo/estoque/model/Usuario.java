package br.com.estudo.estoque.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario{
  @Id
  @GeneratedValue
  private Long id;
  private String nome;
  private String nomeUsuario;
  private String senha;

  public Long getId(){
    return id;
  }

  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }

  public String getNomeUsuario(){
    return nomeUsuario;
  }
  public void setNomeUsuario(String nomeUsuario){
    this.nomeUsuario = nomeUsuario;
  }

  public String getSenha(){
    return senha;
  }
  public void setSenha(String senha){
    this.senha = senha;
  }

  public Usuario(){
  }

  public Usuario(Long id, String nome, String nomeUsuario, String senha){
    this.id = id;
    this.nome = nome;
    this.nomeUsuario = nomeUsuario;
    this.senha = senha;
  }
}
