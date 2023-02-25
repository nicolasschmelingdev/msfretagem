package com.ms.fretagem.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {

    @JsonProperty("cep")
    @NotBlank(message = "O campo CEP é obrigatório")
    private String cep;

}
