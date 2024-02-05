package br.com.app.transferenciabancaria.gateway;

import br.com.app.transferenciabancaria.model.request.TransferenciaRequest;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import jakarta.mail.MessagingException;

public interface TransferenciaDepositoGateway {


    Transferencia deposito(TransferenciaRequest transferenciaRequest) throws MessagingException;
}
