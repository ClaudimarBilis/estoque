package br.com.estudo.estoque.controller;

import br.com.estudo.estoque.dto.MovimentacaoDTO;
import br.com.estudo.estoque.model.Movimentacao;
import br.com.estudo.estoque.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao registrar(@RequestBody MovimentacaoDTO dto){
        return movimentacaoService.registrar(dto);
    }

    @GetMapping("/{id}")
    public Movimentacao buscarPorId(@PathVariable Long id){
        return movimentacaoService.buscarPorId(id);
    }

    @GetMapping
    public List<Movimentacao> listarTodos(){
        return movimentacaoService.listarTodos();
    }
}
