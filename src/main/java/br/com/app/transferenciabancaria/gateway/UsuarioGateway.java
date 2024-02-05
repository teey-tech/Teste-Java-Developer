package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.persistence.entity.Usuario;

public interface UsuarioGateway {
    Usuario registrar(Usuario usuario);
}
