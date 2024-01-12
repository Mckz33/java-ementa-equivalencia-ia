package com.ementa_equivalencia.ia.javaementaequivalenciaia.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long disciplinaId;

    private String disciplinaNome;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "curso_instituicao_id")
    private CursoInstituicao cursoInstituicao;

    @OneToOne(mappedBy = "disciplina")
    private DisciplinaDados disciplinaDados;
}