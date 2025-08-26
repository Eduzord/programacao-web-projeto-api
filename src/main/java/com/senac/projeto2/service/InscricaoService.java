package com.senac.projeto2.service;

import com.senac.projeto2.entity.Inscricao;
import com.senac.projeto2.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {
    private final InscricaoRepository inscricaoRepository;


    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public List<Inscricao> listarInscricoes(){
        return inscricaoRepository.findAll();
    }

    public Inscricao listarInscricaoPorId(int idInscricao){
        return inscricaoRepository.findById(idInscricao).orElse(null);
    }

}
