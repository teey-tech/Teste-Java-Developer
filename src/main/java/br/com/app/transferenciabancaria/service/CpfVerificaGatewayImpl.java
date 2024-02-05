package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;
import br.com.app.transferenciabancaria.exception.message.DataViolationException;
import br.com.app.transferenciabancaria.gateway.CpfVerificaGateway;
import br.com.app.transferenciabancaria.persistence.entity.Usuario;
import br.com.app.transferenciabancaria.persistence.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CpfVerificaGatewayImpl implements CpfVerificaGateway {

    private UsuarioRepository usuarioRepository;

    public CpfVerificaGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Boolean verifica(String cpf, UsuarioTipoEnum tipo) {
        Usuario cpfEncontrado = usuarioRepository.findByCpf(cpf);

        if(cpf != null && tipo.equals(UsuarioTipoEnum.EMPRESA)){
            throw  new DataViolationException("Para cadastrar um cpf voce precisa ser um usuario e nao logista");
        }

        if(cpfEncontrado != null && cpfEncontrado.getCpf() != null && cpfEncontrado.getCpf().equals(cpf)){
            throw  new DataViolationException("CPF ja cadastrado no sistema");
        }

        return true;
    }
}
