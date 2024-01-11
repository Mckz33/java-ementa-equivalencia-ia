package com.ementa_equivalencia.ia.javaementaequivalenciaia.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests.CursoInstituicaoRequest;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses.CursoInstituicaoResponse;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.CursoInstituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.services.CursoInstituicaoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/curso-instituicao")
public class CursoInstituicaoController {

        @Autowired
        CursoInstituicaoService cursoInstituicaoService;

        @GetMapping
        public ResponseEntity<List<CursoInstituicaoResponse>> findAll() {
                List<CursoInstituicao> cursoInstituicaos = cursoInstituicaoService.findAll();
                List<CursoInstituicaoResponse> InstituicaoResponses = cursoInstituicaos
                                .stream()
                                .map(a -> new ModelMapper().map(a, CursoInstituicaoResponse.class))
                                .collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(InstituicaoResponses);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CursoInstituicaoResponse> findById(@PathVariable Long id) {
                Optional<CursoInstituicao> cursoOptional = cursoInstituicaoService.findById(id);
                CursoInstituicaoResponse CursoInstituicaoResponse = new ModelMapper()
                                .map(cursoOptional.orElseThrow(), CursoInstituicaoResponse.class);
                return ResponseEntity.status(HttpStatus.OK).body(CursoInstituicaoResponse);
        }

        @PostMapping
        public ResponseEntity<CursoInstituicaoResponse> save(
                        @RequestBody CursoInstituicaoRequest cursoInstituicaoRequest) {
                CursoInstituicao cursoInstituicaos = new ModelMapper().map(cursoInstituicaoRequest,
                                CursoInstituicao.class);
                cursoInstituicaos = cursoInstituicaoService.save(cursoInstituicaos);
                CursoInstituicaoResponse instituicaoResponse = new ModelMapper()
                                .map(cursoInstituicaos, CursoInstituicaoResponse.class);
                return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoResponse);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable Long id) {
                Optional<CursoInstituicao> instituicaoOptional = cursoInstituicaoService.findById(id);
                CursoInstituicao cursoInstituicao = new ModelMapper()
                                .map(instituicaoOptional.orElseThrow(), CursoInstituicao.class);
                cursoInstituicaoService.delete(cursoInstituicao);
                return ResponseEntity
                                .status(HttpStatus.OK)
                                .body("CursoInstituicao deletado com sucesso.");
        }

        @PutMapping("/{id}")
        public ResponseEntity<CursoInstituicaoResponse> update(
                        @PathVariable Long id,
                        @RequestBody CursoInstituicaoRequest cursoInstituicaoRequest) {
                Optional<CursoInstituicao> instituicaoOptional = cursoInstituicaoService.findById(id);
                CursoInstituicao cursoInstituicao = new ModelMapper().map(cursoInstituicaoRequest,
                                CursoInstituicao.class);
                cursoInstituicao.setCursoInstituicaoId(instituicaoOptional.orElseThrow().getCursoInstituicaoId());
                cursoInstituicaoService.save(cursoInstituicao);
                CursoInstituicaoResponse instituicaoResponse = new ModelMapper()
                                .map(cursoInstituicao, CursoInstituicaoResponse.class);
                return ResponseEntity.status(HttpStatus.OK).body(instituicaoResponse);
        }
}
