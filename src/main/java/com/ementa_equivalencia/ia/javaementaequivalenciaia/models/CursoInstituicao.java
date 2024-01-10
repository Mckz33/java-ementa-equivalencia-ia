package com.ementa_equivalencia.ia.javaementaequivalenciaia.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CursoInstituicao implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @Column(name = "curso_instituicao_id")
    private Long cursoInstituicaoId;

    private String nome;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "curso_instituicao_curso", joinColumns = @JoinColumn(name = "cursoInstituicaoId"), inverseJoinColumns = @JoinColumn(name = "cursoId"))
    private CursoInstituicao cursoInstituicao;

    // @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    // @JoinTable(name = "curso_instituicao_curso", joinColumns = @JoinColumn(name =
    // "cursoInstituicao_id"), inverseJoinColumns = @JoinColumn(name =
    // "instituicao_id"))
    // private Instituicao instituicao;
}
