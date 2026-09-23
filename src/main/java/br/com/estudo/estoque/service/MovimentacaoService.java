package br.com.estudo.estoque.service;


import br.com.estudo.estoque.dto.MovimentacaoDTO;
import br.com.estudo.estoque.exception.RecursoNaoEncontradoException;
import br.com.estudo.estoque.exception.RegraDeNegocioException;
import br.com.estudo.estoque.model.Movimentacao;
import br.com.estudo.estoque.model.Produto;
import br.com.estudo.estoque.model.TipoMovimentacao;
import br.com.estudo.estoque.repository.MovimentacaoRepository;
import br.com.estudo.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Movimentacao registrar(MovimentacaoDTO dto) {
        Produto produtoBuscaPorId = produtoRepository.buscarPorId(dto.getProdutoId());
        if(produtoBuscaPorId == null){
            throw new RecursoNaoEncontradoException("Produto não encontrado.");
        }
        else if(dto.getQuantidade() <= 0) {
            throw new RegraDeNegocioException("Quantidade inválida.");
        }
        else if(dto.getTipo() == TipoMovimentacao.ENTRADA && dto.getQuantidade() > 0){
            produtoBuscaPorId.setQuantidade(produtoBuscaPorId.getQuantidade() + dto.getQuantidade());
        }
        else if(dto.getQuantidade() > produtoBuscaPorId.getQuantidade()) {
            throw new RegraDeNegocioException("Estoque insuficiente.");
        }
        else {
            produtoBuscaPorId.setQuantidade(produtoBuscaPorId.getQuantidade() - dto.getQuantidade());
        }
        produtoRepository.atualizar(produtoBuscaPorId);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setProduto(produtoBuscaPorId);
        movimentacao.setTipo(dto.getTipo());
        movimentacao.setQuantidade(dto.getQuantidade());
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setObservacao(dto.getObservacao());
        movimentacaoRepository.salvar(movimentacao);

        return movimentacao;
    }

    public Movimentacao buscarPorId(Long id) {
        Movimentacao resultado = movimentacaoRepository.buscarPorId(id);
        if ( resultado == null) {
            throw new RecursoNaoEncontradoException("Id não encontrado.");
        } else {
            return resultado;
        }
    }

    public List<Movimentacao> listarTodos() {
        return movimentacaoRepository.listarTodos();
    }
}
