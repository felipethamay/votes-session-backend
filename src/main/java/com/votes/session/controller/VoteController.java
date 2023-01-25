package com.votes.session.controller;

import com.votes.session.entity.VoteEntity;
import com.votes.session.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vote")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(description = "Operações da API de votos", value = "API de votos", tags = {"API de votos"})
public class VoteController {

    private final VoteService voteService;

    @ApiOperation(value = "Inserir voto")
    @PostMapping
    public ResponseEntity<VoteEntity> voteCreate(@RequestBody VoteEntity voteCreate) {
        VoteEntity voteEntity = voteService.create(voteCreate);
        return new ResponseEntity<VoteEntity>(voteEntity, HttpStatus.OK);
    }

    @ApiOperation(value = "Excluir voto pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVoteById(@PathVariable Integer id) {
        voteService.deleteVoteById(id);
    }

}
