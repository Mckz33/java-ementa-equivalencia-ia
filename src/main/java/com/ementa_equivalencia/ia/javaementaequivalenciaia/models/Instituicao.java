package com.ementa_equivalencia.ia.javaementaequivalenciaia.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Instituicao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instituicaoId;

    private String instituicaoNome;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "cursoId")
    private List<Curso> curso;

}
