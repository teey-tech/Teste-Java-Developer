package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;

public interface CnpjVerificaGateway {
    Boolean verifica(UsuarioTipoEnum tipo, String cnpj);
}
