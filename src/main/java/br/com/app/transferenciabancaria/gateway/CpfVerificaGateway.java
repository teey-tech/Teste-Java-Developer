package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;

public interface CpfVerificaGateway {
    Boolean verifica(String cpf, UsuarioTipoEnum tipo);
}
