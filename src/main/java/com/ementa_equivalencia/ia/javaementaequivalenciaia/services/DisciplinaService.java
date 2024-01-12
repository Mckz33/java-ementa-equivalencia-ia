package com.ementa_equivalencia.ia.javaementaequivalenciaia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.exceptions.ResourceNotFoundException;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.CursoInstituicaoRepository;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoInstituicaoRepository cursoInstituicaoRepository;

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findById(Long id) {
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);
        if (disciplinaOptional.isEmpty()) {
            throw new ResourceNotFoundException("Dados não encontrado");
        }
        return disciplinaOptional;
    }

    @Transactional
    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Transactional
    public void delete(Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    public void associar(Long disciplinaId, Long cursoInstituicaoId) {
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(disciplinaId);
        Optional<CursoInstituicao> cursoInstituicaoOptional = cursoInstituicaoRepository.findById(cursoInstituicaoId);

        if (disciplinaOptional.isPresent() && cursoInstituicaoOptional.isPresent()) {
            Disciplina disciplina = disciplinaOptional.get();
            disciplina.setCursoInstituicao(cursoInstituicaoOptional.get());
            disciplinaRepository.save(disciplina);
        } else {
            // Lógica para lidar com disciplinas ou cursosInstituicoes inexistentes
            // Pode lançar exceções, logar mensagens, etc.
        }
    }
}
