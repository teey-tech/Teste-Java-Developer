package br.com.app.transferenciabancaria.gateway;

import jakarta.mail.MessagingException;

public interface EnviaEmailDepositoGateway {
    void enviarEmailDeposito(String destinatario) throws MessagingException;
}
