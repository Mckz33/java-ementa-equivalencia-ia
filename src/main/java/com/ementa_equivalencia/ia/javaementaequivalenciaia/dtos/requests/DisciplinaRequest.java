package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;

import lombok.Data;

@Data
public class DisciplinaRequest {
    
    private Long disciplinaId;

    private String disciplinaNome;

    private CursoInstituicao cursoInstituicao;
}
