package com.senac.projeto2.service;

import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.repository.PatrocinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinadorService {
    private final PatrocinadorRepository patrocinadorRepository;

    public PatrocinadorService(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }

    public List<Patrocinador> listarPatrocinadores(){
        return  patrocinadorRepository.findAll();
    }

    public Patrocinador listarPatrocinadorPorId(int idPatrocinador){
        return patrocinadorRepository.findById(idPatrocinador).orElse(null);
    }
}
