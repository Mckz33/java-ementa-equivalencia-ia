package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;

import lombok.Data;

@Data
public class CursoResponse {

    private Long CursoId;

    private String cursoNome;

    private Disciplina disciplina;
}