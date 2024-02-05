package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.persistence.entity.Transferencia;

public interface ValidaTransferenciaGateway {

    Boolean validar(Transferencia transferencia);
}
