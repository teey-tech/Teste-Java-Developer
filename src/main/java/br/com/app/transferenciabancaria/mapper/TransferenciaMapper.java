package br.com.app.transferenciabancaria.mapper;

import br.com.app.transferenciabancaria.config.MapperConfig;
import br.com.app.transferenciabancaria.model.request.TransferenciaRequest;
import br.com.app.transferenciabancaria.model.response.TransferenciaResponse;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaMapper {

    private MapperConfig mapperConfig;

    public TransferenciaMapper(MapperConfig mapperConfig) {
        this.mapperConfig = mapperConfig;
    }

    public Transferencia toTransferencia(TransferenciaRequest transferenciaRequest) {
        return mapperConfig.modelMapper().map(transferenciaRequest, Transferencia.class);
    }

    public TransferenciaResponse toTransferenciaResponce(Transferencia transferencia){
        return mapperConfig.modelMapper().map(transferencia, TransferenciaResponse.class);
    }
}
