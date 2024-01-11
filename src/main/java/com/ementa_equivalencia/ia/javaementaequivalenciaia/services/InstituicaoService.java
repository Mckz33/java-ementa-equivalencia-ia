package com.ementa_equivalencia.ia.javaementaequivalenciaia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Instituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.exceptions.ResourceNotFoundException;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.InstituicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    public List<Instituicao> findAll() {
        return instituicaoRepository.findAll();
    }

    public Optional<Instituicao> findById(Long id) {
        Optional<Instituicao> optionalInstituicao = instituicaoRepository.findById(id);
        if (optionalInstituicao.isEmpty()) {
            throw new ResourceNotFoundException("Instituição não encontrado");
        }
        return optionalInstituicao;
    }

    @Transactional
    public Instituicao save(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    @Transactional
    public void delete(Instituicao instituicao) {
        instituicaoRepository.delete(instituicao);
    }
}
