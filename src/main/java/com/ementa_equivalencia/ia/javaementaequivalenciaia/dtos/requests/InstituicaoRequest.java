package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests;

import java.util.List;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Curso;

import lombok.Data;

@Data
public class InstituicaoRequest {

    private Long instituicaoId;

    private String instituicaoNome;

    private List<Curso> curso;
}