package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.gateway.EnviaEmailSaqueGateway;
import br.com.app.transferenciabancaria.persistence.entity.Usuario;
import br.com.app.transferenciabancaria.persistence.repository.UsuarioRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EnviaEmailSaqueGatewayImpl implements EnviaEmailSaqueGateway {

    private UsuarioRepository usuarioRepository;

    private JavaMailSender javaMailSender;

    public EnviaEmailSaqueGatewayImpl(UsuarioRepository usuarioRepository, JavaMailSender javaMailSender) {
        this.usuarioRepository = usuarioRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void enviarEmailSaque(String destinatario) throws MessagingException {
        Usuario emailAchado = usuarioRepository.findByEmail(destinatario);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        destinatario = emailAchado.getEmail();
        String assunto = "Transação Saque";
        String corpo = "Saque Realizado com sucesso";

        helper.setTo(destinatario);
        helper.setSubject(assunto);
        helper.setText(corpo, true);

        javaMailSender.send(mimeMessage);

    }
}
