package br.com.estudo.estoque.controller;

import br.com.estudo.estoque.model.Categoria;
import br.com.estudo.estoque.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria cadastrar(@RequestBody Categoria categoria){
        return categoriaService.cadastrar(categoria);
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @GetMapping
    public List<Categoria> listarTodos(){
        return categoriaService.listarTodos();
    }

    @PutMapping("/{id}")
    public void atualizar (@PathVariable Long id, @RequestBody Categoria categoria){
        categoria.setId(id);
        categoriaService.atualizar(categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar( @PathVariable Long id){
        categoriaService.deletar(id);
    }
}
