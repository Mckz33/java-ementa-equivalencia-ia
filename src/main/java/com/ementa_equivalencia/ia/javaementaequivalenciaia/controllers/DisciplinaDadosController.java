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

import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.requests.DisciplinaDadosRequest;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.dtos.responses.DisciplinaDadosResponse;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.models.DisciplinaDados;
import com.ementa_equivalencia.ia.javaementaequivalenciaia.services.DisciplinaDadosService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/disciplina-dados")
public class DisciplinaDadosController {

    @Autowired
    DisciplinaDadosService disciplinaDadosService;

    @GetMapping
    public ResponseEntity<List<DisciplinaDadosResponse>> findAll() {
        List<DisciplinaDados> disciplinaDados = disciplinaDadosService.findAll();
        List<DisciplinaDadosResponse> InstituicaoResponses = disciplinaDados
                .stream()
                .map(a -> new ModelMapper().map(a, DisciplinaDadosResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(InstituicaoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDadosResponse> findById(@PathVariable Long id) {
        Optional<DisciplinaDados> cursoOptional = disciplinaDadosService.findById(id);
        DisciplinaDadosResponse DisciplinaDadosResponse = new ModelMapper()
                .map(cursoOptional.orElseThrow(), DisciplinaDadosResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(DisciplinaDadosResponse);
    }

    @PostMapping
    public ResponseEntity<DisciplinaDadosResponse> save(
            @RequestBody DisciplinaDadosRequest disciplinaDadosRequest) {
        DisciplinaDados cursoInstituicaos = new ModelMapper().map(disciplinaDadosRequest,
                DisciplinaDados.class);
        cursoInstituicaos = disciplinaDadosService.save(cursoInstituicaos);
        DisciplinaDadosResponse instituicaoResponse = new ModelMapper()
                .map(cursoInstituicaos, DisciplinaDadosResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<DisciplinaDados> disciplinaDadosOptional = disciplinaDadosService.findById(id);
        DisciplinaDados disciplinaDados = new ModelMapper()
                .map(disciplinaDadosOptional.orElseThrow(), DisciplinaDados.class);
        disciplinaDadosService.delete(disciplinaDados);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Dados deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDadosResponse> update(
            @PathVariable Long id,
            @RequestBody DisciplinaDadosRequest disciplinaDadosRequest) {
        Optional<DisciplinaDados> disciplinaDadosOptional = disciplinaDadosService.findById(id);
        DisciplinaDados disciplinaDados = new ModelMapper().map(disciplinaDadosRequest,
                DisciplinaDados.class);
        disciplinaDados.setDisciplinaDadosId(disciplinaDadosOptional.orElseThrow().getDisciplinaDadosId());
        disciplinaDadosService.save(disciplinaDados);
        DisciplinaDadosResponse instituicaoResponse = new ModelMapper()
                .map(disciplinaDados, DisciplinaDadosResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(instituicaoResponse);
    }
}
