package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.persistence.entity.Carteira;

import java.util.List;

public interface ListarCarteiraGateway {

    List<Carteira> listarTodos();
}
