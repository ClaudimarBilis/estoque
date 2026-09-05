package br.com.estudo.estoque.service;

import br.com.estudo.estoque.model.Categoria;
import br.com.estudo.estoque.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrar(Categoria categoria) {
        if (categoriaRepository.buscarPorNome(categoria.getNome()) != null) {
            throw new RuntimeException("Essa categoria já existe.");
        } else {
            categoriaRepository.salvar(categoria);
        }
        return categoria;
    }

    public Categoria buscarPorId(Long id){
        Categoria resultado = categoriaRepository.buscarPorId(id);
        if(resultado == null){
            throw new RuntimeException("Categoria não encontrada.");
        }
        else{
            return resultado;
        }
    }

    public List<Categoria> listarTodos(){
        return categoriaRepository.listarTodos();
    }

    public void atualizar(Categoria categoria){
        Categoria buscarId = categoriaRepository.buscarPorId(categoria.getId());
        if(buscarId == null){
            throw new RuntimeException("Categoria não encontrada.");
        }
        else{
            categoriaRepository.atualizar(categoria);
        }
    }

    public void deletar(Long id){
        Categoria buscarId = categoriaRepository.buscarPorId(id);
        if(buscarId == null){
            throw new RuntimeException("Categoria não encontrada.");
        }
        else{
            categoriaRepository.deletar(id);
        }
    }
}
