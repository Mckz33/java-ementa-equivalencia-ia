package com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses;

import java.util.List;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Curso;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Instituicao;

import lombok.Data;


@Data
public class CursoInstituicaoResponse {

    private Long cursoInstituicaoId;

    private Curso curso;

    private Instituicao instituicao;

    private List<Disciplina> disciplinas;

}
