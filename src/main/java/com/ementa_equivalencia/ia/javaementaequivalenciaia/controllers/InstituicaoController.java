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

import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests.InstituicaoRequest;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses.InstituicaoResponse;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Instituicao;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.services.InstituicaoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/instituicao")
public class InstituicaoController {

        @Autowired
        InstituicaoService instituicaoService;

        @GetMapping
        public ResponseEntity<List<InstituicaoResponse>> findAll() {
                List<Instituicao> instituicao = instituicaoService.findAll();
                List<InstituicaoResponse> InstituicaoResponses = instituicao
                                .stream()
                                .map(a -> new ModelMapper().map(a, InstituicaoResponse.class))
                                .collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(InstituicaoResponses);
        }

        @GetMapping("/{id}")
        public ResponseEntity<InstituicaoResponse> findById(@PathVariable Long id) {
                Optional<Instituicao> cursoOptional = instituicaoService.findById(id);
                InstituicaoResponse InstituicaoResponse = new ModelMapper()
                                .map(cursoOptional.orElseThrow(), InstituicaoResponse.class);
                return ResponseEntity.status(HttpStatus.OK).body(InstituicaoResponse);
        }

        @PostMapping
        public ResponseEntity<InstituicaoResponse> save(
                        @RequestBody InstituicaoRequest instituicaoRequest) {
                Instituicao instituicao = new ModelMapper().map(instituicaoRequest, Instituicao.class);
                instituicao = instituicaoService.save(instituicao);
                InstituicaoResponse instituicaoResponse = new ModelMapper()
                                .map(instituicao, InstituicaoResponse.class);
                return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoResponse);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable Long id) {
                Optional<Instituicao> instituicaoOptional = instituicaoService.findById(id);
                Instituicao curso = new ModelMapper()
                                .map(instituicaoOptional.orElseThrow(), Instituicao.class);
                instituicaoService.delete(curso);
                return ResponseEntity
                                .status(HttpStatus.OK)
                                .body("Instituicao deletado com sucesso.");
        }

        @PutMapping("/{id}")
        public ResponseEntity<InstituicaoResponse> update(
                        @PathVariable Long id,
                        @RequestBody InstituicaoRequest instituicaoRequest) {
                Optional<Instituicao> instituicaoOptional = instituicaoService.findById(id);
                Instituicao curso = new ModelMapper().map(instituicaoRequest, Instituicao.class);
                curso.setInstituicaoId(instituicaoOptional.orElseThrow().getInstituicaoId());
                instituicaoService.save(curso);
                InstituicaoResponse instituicaoResponse = new ModelMapper()
                                .map(curso, InstituicaoResponse.class);
                return ResponseEntity.status(HttpStatus.OK).body(instituicaoResponse);
        }
}