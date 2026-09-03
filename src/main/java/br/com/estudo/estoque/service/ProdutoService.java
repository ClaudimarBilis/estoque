package br.com.estudo.estoque.service;

import br.com.estudo.estoque.model.Produto;
import br.com.estudo.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrar(Produto produto) {
        if (produtoRepository.buscarPorCodigo(produto.getCodigo()) != null) {
            throw new RuntimeException("Já existe um produto com esse código.");
        }
        else {
            produtoRepository.salvar(produto);
        }
        return produto;
    }

    public Produto buscarPorId(Long id){
        Produto resultado = produtoRepository.buscarPorId(id);
        if (resultado == null){
            throw new RuntimeException("Produto não encontrado.");
        }
        else {
            return resultado;
        }
    }

    public List<Produto> listarTodos(){
        return produtoRepository.listarTodos();
    }

    public void atualizar(Produto produto) {
        Produto buscarId = produtoRepository.buscarPorId(produto.getId());
        if (buscarId == null) {
            throw new RuntimeException("Produto não encontrado.");
        } else {
            produtoRepository.atualizar(produto);
        }
    }

    public void deletar(Long id){
        Produto produto = produtoRepository.buscarPorId(id);
        if(produto == null){
            throw new RuntimeException("Produto não encontrado.");
        }
        else{
            produtoRepository.deletar(id);
        }
    }
}
