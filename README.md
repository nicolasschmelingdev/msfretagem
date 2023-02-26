# API Calculo de frete por consulta de CEP
Esta API é utilizada para consultar o endereço correspondente a um determinado CEP e realizar o cálculo do frete para este endereço. O valor do frete é fixo de acordo com as regiões do Brasil.

## Contrato da API
### Consulta de endereço
POST v1/cep

### REQUEST

{
    "cep": "01001000"
}
### RESPONSE HTTP 200

{
    "cep": "01001-000",
    "rua": "Praça da Sé",
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "estado": "SP",
    "frete": 7.85
}

## Regras para o cálculo do frete
* Sudeste: R$ 7,85
* Centro-Oeste: R$ 12,50
* Nordeste: R$ 15,98
* Sul: R$ 17,30
* Norte: R$ 20,83

### Observações
O CEP é obrigatório e pode ser passado com ou sem máscara na entrada;
Se o CEP não for encontrado uma mensagem informativa será retornada para o cliente.

## Requisitos para o desenvolvimento
* Java 11
* Spring Boot
* API REST Template
* Documentação Swagger
* Testes unitários JUnit5

## Via CEP
A consulta de endereço é realizada através da API Via CEP (https://viacep.com.br/).

## DOCUMENTAÇÃO
https://documenter.getpostman.com/view/21462893/2s93CPprhe
