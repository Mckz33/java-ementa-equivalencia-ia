package com.ementa_equivalencia.ia.javaementaequivalenciaia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Curso;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Instituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.exceptions.ResourceNotFoundException;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories.CursoInstituicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoInstituicaoService {

    @Autowired
    CursoInstituicaoRepository cursoInstituicaoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private InstituicaoService instituicaoService;

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

    public List<CursoInstituicao> findCursoInstituicaos(long instituicaoId) {
        return cursoInstituicaoRepository.findByInstituicaoId(instituicaoId);
    }

    @Transactional
    public void delete(CursoInstituicao cursoInstituicao) {
        cursoInstituicaoRepository.delete(cursoInstituicao);
    }

    public void associarCursoAInstituicao(Long cursoId, Long instituicaoId) {
        // Verifica se o curso e a instituição existem
        Optional<Curso> cursoOptional = cursoService.findById(cursoId);
        Optional<Instituicao> instituicaoOptional = instituicaoService.findById(instituicaoId);

        if (cursoOptional != null && instituicaoOptional != null) {
            // Cria uma nova associação entre curso e instituição
            CursoInstituicao cursoInstituicao = new CursoInstituicao();
            cursoInstituicao.setCurso(cursoOptional.get());
            cursoInstituicao.setInstituicao(instituicaoOptional.get());

            // Salva a associação no repositório
            cursoInstituicaoRepository.save(cursoInstituicao);
        } else {
            // Lógica para lidar com cursos ou instituições inexistentes
            // Pode lançar exceções, logar mensagens, etc.
        }
    }

}
