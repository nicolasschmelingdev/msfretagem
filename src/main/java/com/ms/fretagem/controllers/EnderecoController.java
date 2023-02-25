package com.ms.fretagem.controllers;

import com.ms.fretagem.entitys.Endereco;
import com.ms.fretagem.requests.EnderecoRequest;
import com.ms.fretagem.responses.EnderecoResponse;
import com.ms.fretagem.services.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1")
@Validated
public class EnderecoController {

    @Autowired
    private FreteService freteService;

    @PostMapping("/cep/")
    public ResponseEntity<EnderecoResponse> getCep(@RequestBody EnderecoRequest enderecoRequest) {
        Endereco endereco = freteService.buscarEnderecoPorCep(enderecoRequest);
        endereco.setFrete(freteService.valorFrete(endereco));

        return ResponseEntity.ok(new EnderecoResponse(endereco));
    }

}