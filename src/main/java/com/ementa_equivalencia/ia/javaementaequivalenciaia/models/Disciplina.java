package com.ementa_equivalencia.ia.javaementaequivalenciaia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long disciplinaId;

    private String disciplinaNome;

    @ManyToOne
    @JoinColumn(name = "curso_instituicao_id")
    private CursoInstituicao cursoInstituicao;
}