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
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cursoId;

    private String cursoNome;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "disciplinaId")
    private List<Disciplina> disciplina;
}
