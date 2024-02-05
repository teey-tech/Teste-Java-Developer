package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;
import br.com.app.transferenciabancaria.exception.message.DataViolationException;
import br.com.app.transferenciabancaria.gateway.CnpjVerificaGateway;
import br.com.app.transferenciabancaria.persistence.entity.Usuario;
import br.com.app.transferenciabancaria.persistence.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CnpjVerificaGatewayImpl implements CnpjVerificaGateway {

    private UsuarioRepository usuarioRepository;

    public CnpjVerificaGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Boolean verifica(UsuarioTipoEnum tipo, String cnpj) {
        Usuario cnpjSalvo = usuarioRepository.findByCnpj(cnpj);

        if(cnpj != null && tipo.equals(UsuarioTipoEnum.CLIENTE)){
            throw  new DataViolationException("Apenas lojistas podem cadastrar com CNPJ");
        }

        if(cnpjSalvo != null && cnpjSalvo.getCnpj() != null && cnpjSalvo.getCnpj().equals(cnpj)){
            throw new DataViolationException("Cnpj ja cadastrado no sistema");
        }
        return true;
    }
}
