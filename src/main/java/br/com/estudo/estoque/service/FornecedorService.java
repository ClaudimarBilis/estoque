package br.com.estudo.estoque.service;

import br.com.estudo.estoque.model.Fornecedor;
import br.com.estudo.estoque.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor cadastrar(Fornecedor fornecedor){
        Fornecedor buscaNome = fornecedorRepository.buscarPorNome(fornecedor.getNome());
        if(buscaNome != null){
            throw new RuntimeException("Esse fornecedor já existe.");
        }
        else{
            fornecedorRepository.salvar(fornecedor);
        }
        return fornecedor;
    }

    public Fornecedor buscarPorId(Long id){
        Fornecedor buscaId = fornecedorRepository.buscarPorId(id);
        if(buscaId == null){
            throw new RuntimeException("Esse fornecedor não existe.");
        }
        else{
            return buscaId;
        }
    }

    public List<Fornecedor> listarTodos(){
        return fornecedorRepository.listarTodos();
    }

    public void atualizar (Fornecedor fornecedor){
        Fornecedor buscarId = fornecedorRepository.buscarPorId(fornecedor.getId());
        if(buscarId == null){
            throw new RuntimeException("Esse fornecedor não existe.");
        }
        else{
            fornecedorRepository.atualizar(fornecedor);
        }
    }

    public void deletar(Long id){
        Fornecedor buscarId = fornecedorRepository.buscarPorId(id);
        if(buscarId == null){
            throw new RuntimeException("Esse fornecedor não existe.");
        }
        else{
            fornecedorRepository.deletar(id);
        }
    }
}
