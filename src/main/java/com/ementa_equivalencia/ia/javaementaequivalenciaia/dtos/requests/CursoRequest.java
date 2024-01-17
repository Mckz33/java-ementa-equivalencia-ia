package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests;

import java.util.List;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;

import lombok.Data;

@Data
public class CursoRequest {

    private Long cursoId;
    private String cursoNome;
    private List<Disciplina> disciplina;
}