package br.com.estudo.estoque.service;

import br.com.estudo.estoque.exception.RegraDeNegocioException;
import br.com.estudo.estoque.model.Usuario;
import br.com.estudo.estoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        Usuario nomeUsuario = usuarioRepository.buscarPorNomeUsuario(usuario.getNomeUsuario());
        String senhaEmTextoPuro = usuario.getSenha();
        if(nomeUsuario != null) {
            throw new RegraDeNegocioException("Usuário já cadastrado");
        }
        String senhaEnconded = passwordEncoder.encode(senhaEmTextoPuro);
        usuario.setSenha(senhaEnconded);
        usuarioRepository.salvar(usuario);
        return usuario;
    }
}
