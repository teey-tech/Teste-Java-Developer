package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.model.request.TransferenciaRequest;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;

import java.math.BigDecimal;

public interface TaxaGateway {
    Double taxa(TransferenciaRequest transferenciaRequest);
}
