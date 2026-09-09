package br.com.estudo.estoque.repository;

import br.com.estudo.estoque.model.Movimentacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovimentacaoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Movimentacao movimentacao){
        entityManager.persist(movimentacao);
    }

    public Movimentacao buscarPorId(Long id){
        return entityManager.find(Movimentacao.class, id);
    }

    public List<Movimentacao> listarTodos(){
        return entityManager.createQuery("SELECT p FROM Movimentacao p", Movimentacao.class).getResultList();
    }
}
