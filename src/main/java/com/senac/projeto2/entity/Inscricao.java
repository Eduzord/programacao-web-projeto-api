package com.senac.projeto2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name="inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscricao_id")
    private int id;

    @Column(name = "inscricao_data", nullable = false, length = 50)
    private LocalDate data;

    @Column(name = "inscricao_status", nullable = false, length = 11)
    private int status;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    @JsonIgnore
    private Participante participante;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "jogo_id",nullable = false)
    private Jogo jogo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }


}
