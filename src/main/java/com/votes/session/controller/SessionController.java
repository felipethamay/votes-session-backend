package com.votes.session.controller;

import com.votes.session.entity.SessionEntity;
import com.votes.session.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/session")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(description = "Operações da API de sessão", value = "API de sessão", tags = {"API de sessão"})
public class SessionController {

    private final SessionService sessionService;

    @ApiOperation(value = "Pesquisar todos as sessões")
    @GetMapping
    public ResponseEntity<Page<SessionEntity>> list(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "title", defaultValue = "") String title) {
        return ResponseEntity.ok(sessionService.listSessions(page, linesPerPage, orderBy, direction, title));
    }

    @ApiOperation(value = "Pesquisar sessão pelo id")
    @GetMapping("/{id}")
    public ResponseEntity sessionFindById(@PathVariable Integer id) {
        SessionEntity sessionEntity = sessionService.sessionFindById(id);
        return ResponseEntity.ok(sessionEntity);
    }

    @ApiOperation(value = "Cadastrar sessão")
    @PostMapping
    public ResponseEntity<SessionEntity> associateCreate(@RequestBody SessionEntity sessionCreate) {
        SessionEntity sessionEntity = sessionService.createSession(sessionCreate);
        return new ResponseEntity<SessionEntity>(sessionEntity, HttpStatus.OK);
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
