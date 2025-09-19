package com.senac.projeto2.dto.request;

import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.entity.Participante;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InscricaoDtoRequest {

    @NotBlank(message = "A data é obrigatória")
    private LocalDateTime data;

    @NotBlank(message = "É obrigatório um participante.")
    private Integer participanteId;

    @NotBlank(message = "É obrigatório um jogo.")
    private Integer jogoId;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }

    public Integer getJogoId() {
        return jogoId;
    }

    public void setJogoId(int jogoId) {
        this.jogoId = jogoId;
    }
}
