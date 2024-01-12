package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;

import lombok.Data;

@Data
public class DisciplinaResponse {

    private Long disciplinaId;

    private String disciplinaNome;

    private CursoInstituicao cursoInstituicao;
}
