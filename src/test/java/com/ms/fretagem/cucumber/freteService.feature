#language:pt
Funcionalidade: : Frete Service

  Cenário: Valor do frete para endereço da região sudeste
    Dado a UF é "SP"
    Quando eu calculo o frete
    Então o valor do frete é "7.85"

  Cenário: Valor do frete para endereço da região centro-oeste
    Dado a UF é "GO"
    Quando eu calculo o frete
    Então o valor do frete é "12.50"

  Cenário: Valor do frete para endereço da região nordeste
    Dado a UF é "PE"
    Quando eu calculo o frete
    Então o valor do frete é "15.98"

  Cenário: Valor do frete para endereço da região sul
    Dado a UF é "PR"
    Quando eu calculo o frete
    Então o valor do frete é "17.30"

  Cenário: Valor do frete para endereço da região norte
    Dado a UF é "PA"
    Quando eu calculo o frete
    Então o valor do frete é "20.83"

  Cenário: Buscar endereço por CEP válido
    Dado um CEP válido "60714140"
    Quando eu busco o endereço
    Então o endereço deve ser retornado

  Cenário: Buscar endereço por CEP inválido
    Dado um CEP não encontrado "1234578"
    Quando eu busco o endereço
    Então deve ser lançada uma exceção

  Cenário: Buscar endereço por CEP não encontrado
    Dado um CEP não encontrado "12345678"
    Quando eu busco o endereço
    Então deve ser lançada uma exceção

