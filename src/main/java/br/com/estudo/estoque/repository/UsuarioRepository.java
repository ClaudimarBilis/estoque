package br.com.estudo.estoque.repository;

import br.com.estudo.estoque.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Usuario usuario){
        entityManager.persist(usuario);
    }

    public Usuario buscarPorNomeUsuario(String nomeUsuario){
        List<Usuario> buscarPorNomeUsuarioResultado = entityManager.createQuery("SELECT p FROM Usuario p WHERE p.nomeUsuario = :nomeUsuario", Usuario.class).
                setParameter("nomeUsuario", nomeUsuario).getResultList();
        return buscarPorNomeUsuarioResultado.isEmpty() ? null : buscarPorNomeUsuarioResultado.get(0);
    }
}
