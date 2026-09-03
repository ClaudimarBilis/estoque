package br.com.estudo.estoque.repository;

import br.com.estudo.estoque.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProdutoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Produto produto) {
        entityManager.persist(produto);
    }

    public Produto buscarPorId(Long id){
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> listarTodos(){
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    @Transactional
    public Produto atualizar(Produto produto){
        return entityManager.merge(produto);
    }

    @Transactional
    public void deletar (Long id){
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.remove(produto);
    }

    public Produto buscarPorCodigo(String codigo){
        List<Produto> resultado = entityManager.
            createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo", Produto.class)
            .setParameter("codigo", codigo)
            .getResultList();

        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
