package br.com.estudo.estoque.service;

import br.com.estudo.estoque.dto.ProdutoDTO;
import br.com.estudo.estoque.model.Categoria;
import br.com.estudo.estoque.model.Produto;
import br.com.estudo.estoque.repository.CategoriaRepository;
import br.com.estudo.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto cadastrar(ProdutoDTO dto) {

        Categoria categoria = categoriaRepository.buscarPorId(dto.getCategoriaId());

        if(categoria == null){
            throw new RuntimeException("Categoria não encontrada.");
        }

        if(produtoRepository.buscarPorCodigo(dto.getCodigo()) != null){
            throw new RuntimeException("Já existe um produto com esse código.");
        }

        Produto produto = new Produto();
        produto.setCodigo(dto.getCodigo());
        produto.setNome(dto.getNome());
        produto.setQuantidade(dto.getQuantidade());
        produto.setEstoqueMinimo(dto.getEstoqueMinimo());
        produto.setLocalizacao(dto.getLocalizacao());

        produto.setCategoria(categoria);

        produtoRepository.salvar(produto);

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

    public void atualizar(Long id, ProdutoDTO dto) {

        Produto produto = produtoRepository.buscarPorId(id);
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado.");
        }

        Categoria categoria = categoriaRepository.buscarPorId(dto.getCategoriaId());
        if(categoria == null){
            throw new RuntimeException("Categoria não encontrada.");
        }

        produto.setCodigo(dto.getCodigo());
        produto.setNome(dto.getNome());
        produto.setQuantidade(dto.getQuantidade());
        produto.setEstoqueMinimo(dto.getEstoqueMinimo());
        produto.setLocalizacao(dto.getLocalizacao());

        produto.setCategoria(categoria);

        produtoRepository.atualizar(produto);

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
