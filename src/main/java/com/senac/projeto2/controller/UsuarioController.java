package com.senac.projeto2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description ="API para gerenciamento dos usuários do sistema.")
public class UsuarioController {

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public String listar(){
        return "Listando com sucesso";
    }

    @GetMapping("/listarPorIdUsuario/{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema pelo id do usuário.")
    public String listarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        return "Listando usuário "+ idUsuario +" por Id com sucesso";
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar usuário no sistema.")
    public String criar(){
        return "Usuario criado com sucesso!";
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualiza todos os parametros de um usuário do sistema.")
    public String atualizar(){
        return "Usuario atualizado com sucesso!";
    }

    @PatchMapping("/atualizarParametro")
    @Operation(summary = "Atualiza um dos parametros de um usuário do sistema.")
    public String atualizarParametro(){
        return "Parametro atualizado com sucesso!";
    }

    @DeleteMapping("/apagar")
    @Operation(summary = "Deleta um usuário do sistema.")
    public String apagar(){
        return "Usuario apagado com sucesso!";
    }


}
