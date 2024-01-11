package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;

import lombok.Data;

@Data
public class DisciplinaDadosResponse {

    private Long DisciplinaDadosId;

    private String ementa;

    private String conteudo;

    private Disciplina disciplina;
}
