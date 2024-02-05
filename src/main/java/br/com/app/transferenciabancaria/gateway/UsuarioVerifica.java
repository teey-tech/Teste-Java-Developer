package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.persistence.entity.Transferencia;

public interface UsuarioVerifica {
    Boolean verifica(Transferencia transferencia);
}
