package com.ms.fretagem.entitys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @NotEmpty(message = "O campo CEP não pode ser vazio")
    @Size(min = 8, max = 8, message = "O campo CEP deve ter exatamente 8 caracteres")
    @Pattern(regexp = "\\d{8}", message = "O campo CEP deve conter apenas dígitos")
    @JsonProperty("cep")
    private String cep;

    @NotEmpty(message = "O campo Logradouro não pode ser vazio")
    @JsonProperty("logradouro")
    private String rua;

    @NotEmpty(message = "O campo Bairro não pode ser vazio")
    @JsonProperty("bairro")
    private String bairro;

    @NotEmpty(message = "O campo Cidade não pode ser vazio")
    @JsonProperty("localidade")
    private String cidade;

    @NotEmpty(message = "O campo Estado não pode ser vazio")
    @JsonProperty("uf")
    private String estado;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("gia")
    private String gia;

    @JsonProperty("ibge")
    private String ibge;

    @JsonProperty("ddd")
    private String ddd;

    @JsonProperty("siafi")
    private String siafi;

    private Double frete;

}
