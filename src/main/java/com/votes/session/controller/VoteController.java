package com.votes.session.controller;

import com.votes.session.entity.VoteEntity;
import com.votes.session.model.Vote;
import com.votes.session.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(description = "Operações da API de votos", value = "API de votos", tags = {"API de votos"})
public class VoteController {

    private final VoteService voteService;

    @ApiOperation(value = "Inserir voto")
    @PostMapping("/session/{sessionId}/associate/{associateId}/vote")
    public VoteEntity voteCreate(@RequestBody Vote voteCreate, @PathVariable Integer sessionId, @PathVariable Integer associateId) {
        return voteService.create(voteCreate, sessionId, associateId);
    }

}
