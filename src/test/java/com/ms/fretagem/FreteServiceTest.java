package com.ms.fretagem;

import com.ms.fretagem.entitys.Endereco;
import com.ms.fretagem.requests.EnderecoRequest;
import com.ms.fretagem.services.FreteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@DisplayName("Testes para FreteService")
class FreteServiceTest {

    private FreteService freteService;

    @BeforeEach
    void setUp() {
        freteService = new FreteService();
    }

    @Test
    @DisplayName("Deve retornar o valor correto do frete para o estado de SP")
    void deveRetornarValorFreteSudeste() {
        Endereco endereco = new Endereco();
        endereco.setEstado("SP");

        Double valorFrete = freteService.valorFrete(endereco);

        Assertions.assertEquals(7.85, valorFrete);
    }

    @Test
    @DisplayName("Deve lançar uma exceção para um CEP inválido")
    void deveLancarExcecaoParaCepInvalido() {
        EnderecoRequest enderecoRequest = new EnderecoRequest();
        enderecoRequest.setCep("1234578");

        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> freteService.buscarEnderecoPorCep(enderecoRequest));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    @DisplayName("Deve retornar o endereço correto para um CEP válido")
    void deveRetornarEnderecoCorretoParaCepValido() {
        EnderecoRequest enderecoRequest = new EnderecoRequest();
        enderecoRequest.setCep("01001000");

        Endereco endereco = freteService.buscarEnderecoPorCep(enderecoRequest);

        Assertions.assertEquals("São Paulo", endereco.getCidade());
        Assertions.assertEquals("SP", endereco.getEstado());
        Assertions.assertEquals("01001-000", endereco.getCep());
    }



}

