package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.gateway.TaxaGateway;
import br.com.app.transferenciabancaria.model.request.TransferenciaRequest;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxaGatewayImpl implements TaxaGateway {


    @Override
    public Double taxa(TransferenciaRequest transferenciaRequest) {

        return 0.02 * transferenciaRequest.getValor();
    }
}
