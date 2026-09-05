package br.com.estudo.estoque.controller;

import br.com.estudo.estoque.model.Fornecedor;
import br.com.estudo.estoque.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public Fornecedor cadastrar(@RequestBody Fornecedor fornecedor){
        return fornecedorService.cadastrar(fornecedor);
    }

    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id){
        return fornecedorService.buscarPorId(id);
    }

    @GetMapping
    public List<Fornecedor> listarTodos(){
        return fornecedorService.listarTodos();
    }

    @PutMapping("/{id}")
    public void atualizar (@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        fornecedor.setId(id);
        fornecedorService.atualizar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        fornecedorService.deletar(id);
    }
}
