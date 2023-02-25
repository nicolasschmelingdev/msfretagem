package com.ms.fretagem.cucumber;

import com.ms.fretagem.entitys.Endereco;
import com.ms.fretagem.requests.EnderecoRequest;
import com.ms.fretagem.services.FreteService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.*;

public class FreteServiceSteps {

    @Dado("a UF é {string}")
    public void a_uf_é(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("eu calculo o frete")
    public void eu_calculo_o_frete() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Então("o valor do frete é {string}")
    public void o_valor_do_frete_é(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("um CEP válido {string}")
    public void um_cep_válido(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("eu busco o endereço")
    public void eu_busco_o_endereço() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Então("o endereço deve ser retornado")
    public void o_endereço_deve_ser_retornado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("um CEP não encontrado {string}")
    public void um_cep_não_encontrado(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Então("deve ser lançada uma exceção")
    public void deve_ser_lançada_uma_exceção() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
