package br.com.estudo.estoque.service;


import br.com.estudo.estoque.dto.MovimentacaoDTO;
import br.com.estudo.estoque.model.Movimentacao;
import br.com.estudo.estoque.model.Produto;
import br.com.estudo.estoque.model.TipoMovimentacao;
import br.com.estudo.estoque.repository.MovimentacaoRepository;
import br.com.estudo.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Movimentacao registrar(MovimentacaoDTO dto) {
        Produto buscaPorId = produtoRepository.buscarPorId(dto.getProdutoId());
        if(buscaPorId == null){
            throw new RuntimeException("Produto não encontrado.");
        }
        if(dto.getTipo() == TipoMovimentacao.ENTRADA){

        }else{
            Produto quantidade =
        }
    }

    public Movimentacao buscarPorId(Long id) {
        Movimentacao resultado = movimentacaoRepository.buscarPorId(id);
        if ( resultado == null) {
            throw new RuntimeException("Id não encontrado.");
        } else {
            return resultado;
        }
    }

    public List<Movimentacao> listarTodos() {
        return movimentacaoRepository.listarTodos();
    }
}
