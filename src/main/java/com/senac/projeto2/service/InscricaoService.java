package com.senac.projeto2.service;

import com.senac.projeto2.dto.request.InscricaoDtoRequest;
import com.senac.projeto2.dto.response.InscricaoDtoResponse;
import com.senac.projeto2.entity.Inscricao;
import com.senac.projeto2.repository.InscricaoRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {
    private final InscricaoRepository inscricaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }


    public List<Inscricao> listarInscricoes(){
        return this.inscricaoRepository.listarInscricoesAtivas();
    }

    public Inscricao listarInscricaoPorId(int idInscricao){
        return this.inscricaoRepository.obterInscricaoAtivaPorId(idInscricao);
    }

    public InscricaoDtoResponse salvar(InscricaoDtoRequest inscricaoDtoRequest) {
        Inscricao inscricao = modelMapper.map(inscricaoDtoRequest, Inscricao.class);
        inscricao.setStatus(1);

        Inscricao inscricaoSalva = this. inscricaoRepository.save(inscricao);

        return modelMapper.map(inscricaoSalva, InscricaoDtoResponse.class);
    }

    public InscricaoDtoResponse atualizar(Integer idInscricao, InscricaoDtoRequest inscricaoDtoRequest){
        Inscricao inscricao = this.listarInscricaoPorId(idInscricao);
        if (inscricao != null){
            modelMapper.map(inscricaoDtoRequest, inscricao);
            Inscricao inscricaoTemp = this.inscricaoRepository.save(inscricao);

            return modelMapper.map(inscricaoTemp,InscricaoDtoResponse.class);
        }else{
            return null;
        }
    }

    public void apagar(Integer idInscricao){
        Inscricao inscricao = listarInscricaoPorId(idInscricao);
        if (inscricao != null){
            this.inscricaoRepository.apagadorLogico(idInscricao);
        }else{
            System.out.println("Id não existe no banco de dados.");
        }
    }
}
