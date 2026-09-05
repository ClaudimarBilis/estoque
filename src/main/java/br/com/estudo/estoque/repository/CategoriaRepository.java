package br.com.estudo.estoque.repository;

import br.com.estudo.estoque.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoriaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Categoria categoria){
        entityManager.persist(categoria);
    }

    public Categoria buscarPorId(Long id){
        return entityManager.find(Categoria.class, id);
    }

    public List<Categoria> listarTodos(){
        return entityManager.createQuery("SELECT p FROM Categoria p", Categoria.class).getResultList();
    }

    @Transactional
    public Categoria atualizar(Categoria categoria){
        return entityManager.merge(categoria);
    }

    @Transactional
    public void deletar(Long id){
        Categoria categoria = entityManager.find(Categoria.class, id);
        entityManager.remove(categoria);
    }

    public Categoria buscarPorNome(String nome){
        List<Categoria> resultado = entityManager.
                createQuery("SELECT p FROM Categoria p WHERE p.nome = :nome", Categoria.class).
                setParameter("nome", nome).getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
