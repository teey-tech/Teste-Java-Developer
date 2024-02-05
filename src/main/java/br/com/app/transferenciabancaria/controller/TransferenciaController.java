package br.com.app.transferenciabancaria.controller;

import br.com.app.transferenciabancaria.gateway.TransferenciaDepositoGateway;
import br.com.app.transferenciabancaria.mapper.TransferenciaMapper;
import br.com.app.transferenciabancaria.model.request.TransferenciaRequest;
import br.com.app.transferenciabancaria.model.response.TransferenciaResponse;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import br.com.app.transferenciabancaria.service.TransferenciaSaqueGatewayImpl;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transferencia")
public class TransferenciaController {

    private TransferenciaSaqueGatewayImpl transferenciaSaqueGatewayImpl;

    private TransferenciaDepositoGateway transferenciaDepositoGateway;

    private TransferenciaMapper transferenciaMapper;

    public TransferenciaController(TransferenciaSaqueGatewayImpl transferenciaSaqueGatewayImpl, TransferenciaDepositoGateway transferenciaDepositoGateway, TransferenciaMapper transferenciaMapper) {
        this.transferenciaSaqueGatewayImpl = transferenciaSaqueGatewayImpl;
        this.transferenciaDepositoGateway = transferenciaDepositoGateway;
        this.transferenciaMapper = transferenciaMapper;
    }

    @PostMapping("/saque")
    public ResponseEntity<TransferenciaResponse> saque(@Valid @RequestBody TransferenciaRequest transferenciaRequest) throws MessagingException {
        Transferencia saque = transferenciaSaqueGatewayImpl.saque(transferenciaRequest);
        TransferenciaResponse transferenciaResponse = transferenciaMapper.toTransferenciaResponce(saque);
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaResponse);
    }

    @PostMapping("/deposito")
    public ResponseEntity<TransferenciaResponse> deposito(@Valid @RequestBody TransferenciaRequest transferenciaRequest) throws MessagingException {
        Transferencia deposito = transferenciaDepositoGateway.deposito(transferenciaRequest);
        TransferenciaResponse transferenciaResponse = transferenciaMapper.toTransferenciaResponce(deposito);
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaResponse);
    }
}
