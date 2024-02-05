package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.client.ApiValidateService;
import br.com.app.transferenciabancaria.gateway.ValidaTransferenciaGateway;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import org.springframework.stereotype.Service;

@Service
public class ValidaTransferenciaGatewayImpl implements ValidaTransferenciaGateway {

    private ApiValidateService apiValidateService;

    public ValidaTransferenciaGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validar(Transferencia transferencia) {
        var response = apiValidateService.validate();
        if (response == null) {
            return false;
        }
        return response.success();
    }
}
