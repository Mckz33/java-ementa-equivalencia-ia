package com.ementa_equivalencia.ia.javaementaequivalenciaia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Curso;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.exceptions.ResourceNotFoundException;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isEmpty()) {
            throw new ResourceNotFoundException("Curso não encontrado");
        }
        return optionalCurso;
    }

    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }

}