package com.ementa_equivalencia.ia.javaementaequivalenciaia.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class DisciplinaDados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long DisciplinaDadosId;

    private String ementa;

    private String conteudo;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Disciplina disciplina;

}
