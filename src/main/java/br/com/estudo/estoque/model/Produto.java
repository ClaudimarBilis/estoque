package br.com.estudo.estoque.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    private String codigo;
    private String nome;
    private Integer quantidade;
    private Integer estoqueMinimo;
    private String localizacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(Integer estoqueMinimo){
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }

    public Produto(){
    }

    public Produto(String codigo, String nome,Integer quantidade, Integer estoqueMinimo, String localizacao){
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.localizacao = localizacao;
    }
}
