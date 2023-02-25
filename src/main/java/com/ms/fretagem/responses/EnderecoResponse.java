package com.ms.fretagem.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ms.fretagem.entitys.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {

    private String cep;

    private String rua;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private Double frete;


    public EnderecoResponse(Endereco endereco){
        this.cep = endereco.getCep();
        this.rua = endereco.getRua();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.frete = endereco.getFrete();
    }

}
