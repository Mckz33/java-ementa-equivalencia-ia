package com.ementa_equivalencia.ia.javaementaequivalenciaia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.exceptions.ResourceNotFoundException;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.CursoInstituicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoInstituicaoService {

    @Autowired
    CursoInstituicaoRepository cursoInstituicaoRepository;

    public List<CursoInstituicao> findAll() {
        return cursoInstituicaoRepository.findAll();
    }

    public Optional<CursoInstituicao> findById(Long id) {
        Optional<CursoInstituicao> optionalInstituicao = cursoInstituicaoRepository.findById(id);
        if (optionalInstituicao.isEmpty()) {
            throw new ResourceNotFoundException("Nada foi encontrado");
        }
        return optionalInstituicao;
    }

    @Transactional
    public CursoInstituicao save(CursoInstituicao cursoInstituicao) {
        return cursoInstituicaoRepository.save(cursoInstituicao);
    }

    @Transactional
    public void delete(CursoInstituicao cursoInstituicao) {
        cursoInstituicaoRepository.delete(cursoInstituicao);
    }
}
