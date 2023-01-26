package com.votes.session.controller;

import com.votes.session.entity.SessionEntity;
import com.votes.session.model.Session;
import com.votes.session.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/session")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(description = "Operações da API de sessão", value = "API de sessão", tags = {"API de sessão"})
public class SessionController {

    private final SessionService sessionService;

    @ApiOperation(value = "Pesquisar todos as sessões")
    @GetMapping
    public List<SessionEntity> list() {
        return sessionService.findAll();
    }

    @ApiOperation(value = "Pesquisar sessão pelo id")
    @GetMapping("/{id}")
    public ResponseEntity sessionFindById(@PathVariable Integer id) {
        SessionEntity sessionEntity = sessionService.sessionFindById(id);
        return ResponseEntity.ok(sessionEntity);
    }

    @ApiOperation(value = "Cadastrar sessão")
    @PostMapping
    public SessionEntity associateCreate(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @ApiOperation(value = "Editar sessão")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public SessionEntity updateAssociateById(@RequestBody SessionEntity sessionEntity, @PathVariable Integer id) {
        return sessionService.updateSessionById(sessionEntity, id);
    }

    @ApiOperation(value = "Excluir sessão pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssociateById(@PathVariable Integer id) {
        sessionService.deleteSessionById(id);
    }
}
