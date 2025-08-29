package com.senac.projeto2.service;

import com.senac.projeto2.dto.request.UsuarioDtoRequest;
import com.senac.projeto2.dto.response.UsuarioDtoResponse;
import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario listarUsuarioPorId(int idUsuario){
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    public UsuarioDtoResponse salvar(UsuarioDtoRequest usuarioDtoRequest){
        //Preciso passar os valores do objeto usuarioDto para o usuario
        Usuario usuario = modelMapper.map(usuarioDtoRequest, Usuario.class);
        usuario.setStatus(1);

        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSalvo, UsuarioDtoResponse.class);
    }

    public void deletarUsuarioPorId(int idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }
}
