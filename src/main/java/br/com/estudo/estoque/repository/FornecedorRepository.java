package br.com.estudo.estoque.repository;

import br.com.estudo.estoque.model.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FornecedorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Fornecedor fornecedor){
        entityManager.persist(fornecedor);
    }

    public Fornecedor buscarPorId(Long id){
        return entityManager.find(Fornecedor.class, id);
    }

    public List<Fornecedor> listarTodos(){
        return entityManager.createQuery("SELECT p FROM Fornecedor p", Fornecedor.class).
                getResultList();
    }

    @Transactional
    public Fornecedor atualizar (Fornecedor fornecedor){
        return entityManager.merge(fornecedor);
    }

    @Transactional
    public void deletar (Long id){
        Fornecedor fornecedor = entityManager.find(Fornecedor.class, id);
        entityManager.remove(fornecedor);
    }

    public Fornecedor buscarPorNome(String nome){
        List<Fornecedor> resultado = entityManager.
                createQuery("SELECT p FROM Fornecedor p WHERE p.nome = :nome", Fornecedor.class).
        setParameter("nome", nome).getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
