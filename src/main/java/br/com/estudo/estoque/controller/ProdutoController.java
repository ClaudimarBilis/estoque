package br.com.estudo.estoque.controller;

import br.com.estudo.estoque.dto.ProdutoDTO;
import br.com.estudo.estoque.model.Produto;
import br.com.estudo.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto cadastrar(@RequestBody ProdutoDTO dto){
        return produtoService.cadastrar(dto);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        produtoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}
