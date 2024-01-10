package com.ementa_equivalencia.ia.javaementaequivalenciaia.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Curso implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @Column(name = "curso_id")
    private Long cursoId;

    private String cursoNome;
}
