package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;

import lombok.Data;

@Data
public class DisciplinaDadosRequest {

    private Long DisciplinaDadosId;

    private String ementa;

    private String conteudo;

    private Disciplina disciplina;
}
