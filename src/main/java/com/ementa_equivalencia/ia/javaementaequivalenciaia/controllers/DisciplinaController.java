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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests.DisciplinaDadosRequest;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses.DisciplinaResponse;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.Disciplina;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.services.DisciplinaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/disciplina")
public class DisciplinaController {

        @Autowired
        DisciplinaService disciplinaService;

        @GetMapping
        public ResponseEntity<List<DisciplinaResponse>> findAll() {
                List<Disciplina> disciplinas = disciplinaService.findAll();
                List<DisciplinaResponse> disciplinaResponses = disciplinas
                                .stream()
                                .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
                                .collect(Collectors.toList());
                return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
        }

        @GetMapping("/{id}")
        public ResponseEntity<DisciplinaResponse> findById(@PathVariable Long id) {
                Optional<Disciplina> cursoOptional = disciplinaService.findById(id);
                DisciplinaResponse DisciplinaResponse = new ModelMapper()
                                .map(cursoOptional.orElseThrow(), DisciplinaResponse.class);
                return ResponseEntity.status(HttpStatus.OK).body(DisciplinaResponse);
        }

        @PostMapping
        public ResponseEntity<DisciplinaResponse> save(
                        @RequestBody DisciplinaDadosRequest disciplinaDadosRequest) {
                Disciplina cursoInstituicaos = new ModelMapper().map(disciplinaDadosRequest,
                                Disciplina.class);
                cursoInstituicaos = disciplinaService.save(cursoInstituicaos);
                DisciplinaResponse instituicaoResponse = new ModelMapper()
                                .map(cursoInstituicaos, DisciplinaResponse.class);
                return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoResponse);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable Long id) {
                Optional<Disciplina> disciplinaDadosOptional = disciplinaService.findById(id);
                Disciplina disciplinas = new ModelMapper()
                                .map(disciplinaDadosOptional.orElseThrow(), Disciplina.class);
                disciplinaService.delete(disciplinas);
                return ResponseEntity
                                .status(HttpStatus.OK)
                                .body("Dados deletado com sucesso.");
        }

        @PutMapping("/{id}")
        public ResponseEntity<DisciplinaResponse> update(
                        @PathVariable Long id,
                        @RequestBody DisciplinaDadosRequest disciplinaDadosRequest) {
                Optional<Disciplina> disciplinaDadosOptional = disciplinaService.findById(id);
                Disciplina disciplinas = new ModelMapper().map(disciplinaDadosRequest,
                                Disciplina.class);
                disciplinas.setDisciplinaId(disciplinaDadosOptional.orElseThrow().getDisciplinaId());
                disciplinaService.save(disciplinas);
                DisciplinaResponse instituicaoResponse = new ModelMapper()
                                .map(disciplinas, DisciplinaResponse.class);
                return ResponseEntity.status(HttpStatus.OK).body(instituicaoResponse);
        }

        // @PostMapping("/associar")
        // public ResponseEntity<String> associar(
        //                 @RequestParam Long disciplinaId,
        //                 @RequestParam Long cursoInstituicaoId) {

        //         try {
        //                 disciplinaService.associar(disciplinaId, cursoInstituicaoId);
        //                 return ResponseEntity.ok("Associação realizada com sucesso.");
        //         } catch (Exception e) {
        //                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        //                                 .body("Erro ao realizar a associação: " + e.getMessage());
        //         }
        // }
}