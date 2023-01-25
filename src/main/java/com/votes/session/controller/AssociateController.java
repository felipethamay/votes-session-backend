package com.votes.session.controller;

import com.votes.session.entity.AssociateEntity;
import com.votes.session.service.AssociateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/associate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(description = "Operações da API de associados", value = "API de associados", tags = {"API de associados"})
public class AssociateController {

    private final AssociateService associateService;

    @ApiOperation(value = "Pesquisar todos os Associados")
    @GetMapping
    public ResponseEntity<List<AssociateEntity>> associateFindAll() {
        List<AssociateEntity> associateEntity = associateService.findAll();
        return ResponseEntity.ok(associateEntity);

    }

    @ApiOperation(value = "Pesquisar associado pelo id")
    @GetMapping("/{id}")
    public ResponseEntity associateFindById(@PathVariable Integer id) {
        AssociateEntity associateEntity = associateService.findById(id);
        return ResponseEntity.ok(associateEntity);
    }

    @ApiOperation(value = "Cadastrar os Associados")
    @PostMapping
    public ResponseEntity<AssociateEntity> associateCreate(@RequestBody AssociateEntity associateCreate) {
        AssociateEntity associateEntity = associateService.createAssociate(associateCreate);
        return new ResponseEntity<AssociateEntity>(associateEntity, HttpStatus.OK);
    }

    @ApiOperation(value = "Editar associado")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AssociateEntity updateAssociateById(@RequestBody AssociateEntity associateEntity, @PathVariable Integer id) {
        return associateService.updateAssociateById(associateEntity, id);
    }

    @ApiOperation(value = "Excluir associado pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssociateById(@PathVariable Integer id) {
        associateService.deleteAssociateById(id);
    }

}
