package br.com.estudo.estoque.dto;

import br.com.estudo.estoque.model.TipoMovimentacao;

public class MovimentacaoDTO {
    private Long produtoId;
    private TipoMovimentacao tipo;
    private Integer quantidade;
    private String observacao;

    public Long getProdutoId(){
        return produtoId;
    }
    public void setProdutoId(Long produtoId){
        this.produtoId = produtoId;
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

    public String getObservacao(){
        return observacao;
    }
    public void setObservacao(String observacao){
        this.observacao = observacao;
    }
}
