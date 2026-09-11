package br.com.estudo.estoque.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn
    private Produto produto;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;
    private Integer quantidade;
    private LocalDateTime data;
    private String observacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public TipoMovimentacao getTipo(){
        return tipo;
    }
    public void setTipo(TipoMovimentacao tipo){
        this.tipo = tipo;
    }

    public Integer getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public LocalDateTime getData(){
        return data;
    }
    public void setData(LocalDateTime data){
        this.data = data;
    }

    public String getObservacao(){
        return observacao;
    }
    public void setObservacao(String observacao){
        this.observacao = observacao;
    }

    public Movimentacao(){
    }

    public Movimentacao(Produto produto, TipoMovimentacao tipo, Integer quantidade, LocalDateTime data, String observacao){
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.observacao = observacao;
    }
}