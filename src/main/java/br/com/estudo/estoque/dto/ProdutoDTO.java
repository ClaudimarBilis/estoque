package br.com.estudo.estoque.dto;

public class ProdutoDTO {
    private String codigo;
    private String nome;
    private Integer quantidade;
    private Integer estoqueMinimo;
    private String localizacao;
    private Long categoriaId;
    private Long fornecedorId;

    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public Integer getEstoqueMinimo(){
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(Integer estoqueMinimo){
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getLocalizacao(){
        return localizacao;
    }
    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }

    public Long getCategoriaId(){
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId){
        this.categoriaId = categoriaId;
    }

    public Long getFornecedorId(){
        return fornecedorId;
    }
    public void setFornecedorId(Long fornecedorId){
        this.fornecedorId = fornecedorId;
    }
}
