Sitema de transferencia Bancaria

utilizade para acessar o banco em memoria h2 utilize este link: 

http://localhost:8080/h2-console

username: sa
password: 

Cadastro de usuario tipo cliente
Execute no Postman para rodar metodo POST
http://localhost:8080/api/v1/usuario
utilize um email verdadeiro para receber o email quando efetuar um saque ou deposito

```

    {
        "nome":"Teste",
        "email": "teste@hotmail.com",
        "cpf": "58866114014",
        "tipo":"CLIENTE"
    }
```


Cadastrar usuario do tipo EMPRESA
Execute no Postman para rodar metodo POST
http://localhost:8080/api/v1/usuario
```
    {
        "nome":"BANCO",
        "email": "teste@hotmail.com",
        "cnpj": "81735186000129",
        "tipo":"EMPRESA"
    }
```

Aqui fica o processo de Saque
é necessario passar o id do cliente
e o id da empresa para efetuar o saque
Teste no postman metodo POST
http://localhost:8080/api/v1/transferencia/saque
```
{
    "fromId": 1,
    "toId": 2,
    "valor": 250.00
}

```

Aqui fica o processo de deposito

Teste no postman metodo POST
http://localhost:8080/api/v1/transferencia/deposito
```
{
    "fromId": 1,
    "toId": 2,
    "valor": 110.00
}
```

é efetuado um mock para simular se está tudo correto com a transação e no final dela um email sera enviado confirmando o sucesso

Lista todas as Carteiras cadastradas
http://localhost:8080/api/v1/carteira/listarTodos
