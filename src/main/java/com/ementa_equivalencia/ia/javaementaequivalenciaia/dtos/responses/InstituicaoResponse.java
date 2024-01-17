package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Curso;

import lombok.Data;

@Data
public class InstituicaoResponse {

    private Long instituicaoId;
    
    private String instituicaoNome;

    private Curso curso;
}
