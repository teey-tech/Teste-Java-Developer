package br.com.app.transferenciabancaria.gateway;

import jakarta.mail.MessagingException;

public interface EnviaEmailSaqueGateway {
    void enviarEmailSaque(String destinatario) throws MessagingException;
}
