package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.gateway.UsuarioGateway;
import br.com.app.transferenciabancaria.persistence.entity.Carteira;
import br.com.app.transferenciabancaria.persistence.entity.Usuario;
import br.com.app.transferenciabancaria.persistence.repository.CarteiraRepository;
import br.com.app.transferenciabancaria.persistence.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static br.com.app.transferenciabancaria.utils.Log.log;

@Service
public class UsuarioGatewayImpl implements UsuarioGateway {

    private UsuarioRepository usuarioRepository;
    private CpfVerificaGatewayImpl cpfVerificaGatewayImpl;

    private CnpjVerificaGatewayImpl cnpjVerificaGatewayImpl;

    private CarteiraRepository carteiraRepository;

    public UsuarioGatewayImpl(UsuarioRepository usuarioRepository, CpfVerificaGatewayImpl cpfVerificaGatewayImpl, CnpjVerificaGatewayImpl cnpjVerificaGatewayImpl, CarteiraRepository carteiraRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cpfVerificaGatewayImpl = cpfVerificaGatewayImpl;
        this.cnpjVerificaGatewayImpl = cnpjVerificaGatewayImpl;
        this.carteiraRepository = carteiraRepository;
    }


    @Override
    public Usuario registrar(Usuario usuario) {
        log.info("Inicio da criação do usuário::UsuarioGatewayImpl");
        cpfVerificaGatewayImpl.verifica(usuario.getCpf(), usuario.getTipo());
        cnpjVerificaGatewayImpl.verifica(usuario.getTipo(), usuario.getCnpj());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        carteiraRepository.save(new Carteira(1000.00, usuarioSalvo));
        log.info("Usuario salvo no bd::UsuarioGatewayImpl");
        return  usuarioSalvo;

    }
}
