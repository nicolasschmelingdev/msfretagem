package com.ms.fretagem.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.fretagem.entitys.Endereco;
import com.ms.fretagem.requests.EnderecoRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Service
public class FreteService {

    private static final double FRETE_SUDESTE = 7.85;
    private static final double FRETE_CENTRO_OESTE = 12.50;
    private static final double FRETE_NORDESTE = 15.98;
    private static final double FRETE_SUL = 17.30;
    private static final double FRETE_NORTE = 20.83;

    public Double valorFrete(Endereco endereco) {
        double valor = 0;

        switch (endereco.getEstado()) {
            case "SP":
            case "RJ":
            case "MG":
            case "ES":
                valor = FRETE_SUDESTE;
                break;
            case "MT":
            case "MS":
            case "GO":
            case "DF":
                valor = FRETE_CENTRO_OESTE;
                break;
            case "MA":
            case "PI":
            case "CE":
            case "RN":
            case "PB":
            case "PE":
            case "AL":
            case "SE":
            case "BA":
                valor = FRETE_NORDESTE;
                break;
            case "PR":
            case "SC":
            case "RS":
                valor = FRETE_SUL;
                break;
            case "AM":
            case "RR":
            case "AP":
            case "PA":
            case "TO":
            case "RO":
            case "AC":
                valor = FRETE_NORTE;
                break;
            default:
                break;
        }

        return valor;
    }

    public Endereco buscarEnderecoPorCep(EnderecoRequest enderecoRequest) {
        String cep = enderecoRequest.getCep();

        if (cep == null || cep.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP não informado");
        }

        cep = cep.replaceAll("\\D", "");

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        String responseString = getResponseString(url);

        if (responseString.contains("{\n" + "  \"erro\": true\n" + "}")) {
            throw new ResponseStatusException(HttpStatus.ACCEPTED, "Endereço não encontrado para o CEP informado.");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseString, Endereco.class);
        } catch (JsonProcessingException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de CEP não válido.");
        }
    }

    public String getResponseString(String url) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de CEP não válido.");
            } else {
                throw e;
            }
        }
    }

}
