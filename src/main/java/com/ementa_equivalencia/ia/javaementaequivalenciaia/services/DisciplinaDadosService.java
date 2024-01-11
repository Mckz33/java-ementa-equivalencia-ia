package com.ementa_equivalencia.ia.javaementaequivalenciaia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.DisciplinaDados;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.exceptions.ResourceNotFoundException;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.DisciplinaDadosRepository;

import jakarta.transaction.Transactional;

@Service
public class DisciplinaDadosService {

    @Autowired
    DisciplinaDadosRepository disciplinaDadosRepository;

    public List<DisciplinaDados> findAll() {
        return disciplinaDadosRepository.findAll();
    }

    public Optional<DisciplinaDados> findById(Long id) {
        Optional<DisciplinaDados> disciplinaDadosOptional = disciplinaDadosRepository.findById(id);
        if (disciplinaDadosOptional.isEmpty()) {
            throw new ResourceNotFoundException("Dados não encontrado");
        }
        return disciplinaDadosOptional;
    }

    @Transactional
    public DisciplinaDados save(DisciplinaDados disciplinaDados) {
        return disciplinaDadosRepository.save(disciplinaDados);
    }

    @Transactional
    public void delete(DisciplinaDados disciplinaDados) {
        disciplinaDadosRepository.delete(disciplinaDados);
    }

}