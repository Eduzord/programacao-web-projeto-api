package com.senac.projeto2.controller;

import com.senac.projeto2.dto.response.UsuarioDtoResponse;
import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.repository.CategoriaRepository;
import com.senac.projeto2.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
@Tag(name="Categoria", description = "API para gerenciamento das categorias do sistema.")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar categorias no sistema.")
    public ResponseEntity<List<Categoria>> listar(){
        return  ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/listarPorIdCategoria/{idCategoria}")
    @Operation(summary = "Listar categorias no sistema pelo Id.")
    public ResponseEntity<Categoria> listarPorIdCategoria(@PathVariable("idCategoria")Integer idCategoria){
        Categoria categoria = categoriaService.listarCategoriaPorId(idCategoria);
        if (categoria == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(categoria);
        }
    }

    @DeleteMapping("/apagar/{idCategoria}")
    @Operation(summary = "Deleta uma categoria do sistema pelo id.")
    public String apagar(@PathVariable("idCategoria") Integer idCategoria){
        categoriaService.apagar(idCategoria);
        return "Categoria deletada com sucesso";
    }
}
