package com.ementa_equivalencia.ia.javaementaequivalenciaia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;
import java.util.List;

public interface CursoInstituicaoRepository extends JpaRepository<CursoInstituicao, Long> {
    
    @Query("SELECT ci FROM CursoInstituicao ci WHERE ci.instituicao.instituicaoId = :instituicaoId")
    List<CursoInstituicao> findByInstituicaoId(@Param("instituicaoId") Long instituicaoId);
}
