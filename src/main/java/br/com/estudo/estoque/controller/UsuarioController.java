package br.com.estudo.estoque.controller;

import br.com.estudo.estoque.model.Usuario;
import br.com.estudo.estoque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrar (@RequestBody Usuario usuario){
        return usuarioService.cadastrar(usuario);
    }

}
