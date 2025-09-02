package com.senac.projeto2.service;

import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(){
        return this.categoriaRepository.listarCategoriasAtivas();
    }

    public Categoria listarCategoriaPorId(int idCategoria){
        return this.categoriaRepository.obterCategoriaAtivaPorId(idCategoria);
    }

    public void apagar(Integer idCategoria){
        Categoria categoria = listarCategoriaPorId(idCategoria);
        if (categoria != null) {
            this.categoriaRepository.apagadorLogico(idCategoria);
        }else{
            System.out.println("Id não existe no banco de dados.");
        }
    }

}
