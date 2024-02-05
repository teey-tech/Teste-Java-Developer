package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.model.request.TransferenciaRequest;
import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;
import br.com.app.transferenciabancaria.exception.message.DataViolationException;
import br.com.app.transferenciabancaria.gateway.TransferenciaSaqueGateway;
import br.com.app.transferenciabancaria.persistence.entity.Carteira;
import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import br.com.app.transferenciabancaria.persistence.repository.CarteiraRepository;
import br.com.app.transferenciabancaria.persistence.repository.TransferenciaRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferenciaSaqueGatewayImpl implements TransferenciaSaqueGateway {

    private TransferenciaRepository transferenciaRepository;

    private CarteiraRepository carteiraRepository;

    private TaxaGatewayImpl taxaGateway;

    private  ValidaTransferenciaGatewayImpl validaTransferenciaGatewayImpl;

    private EnviaEmailSaqueGatewayImpl enviaEmailSaqueGateway;

    public TransferenciaSaqueGatewayImpl(TransferenciaRepository transferenciaRepository, CarteiraRepository carteiraRepository, TaxaGatewayImpl taxaGateway, ValidaTransferenciaGatewayImpl validaTransferenciaGatewayImpl, EnviaEmailSaqueGatewayImpl enviaEmailSaqueGateway) {
        this.transferenciaRepository = transferenciaRepository;
        this.carteiraRepository = carteiraRepository;
        this.taxaGateway = taxaGateway;
        this.validaTransferenciaGatewayImpl = validaTransferenciaGatewayImpl;
        this.enviaEmailSaqueGateway = enviaEmailSaqueGateway;
    }


    @Override
    @Transactional
    public Transferencia saque(TransferenciaRequest transferenciaRequest) throws MessagingException {
        Optional<Carteira> cliente = carteiraRepository.findById(transferenciaRequest.getFromId());
        Optional<Carteira> empresa = carteiraRepository.findById(transferenciaRequest.getToId());

        Transferencia transferencia = new Transferencia();
        BeanUtils.copyProperties(transferenciaRequest, transferencia);

        if(cliente.get().getUsuario().getTipo().equals(UsuarioTipoEnum.EMPRESA)){
            throw  new DataViolationException("Empresas não podem fazer saque");
        }
        if (empresa.get().getSaldo() < transferenciaRequest.getValor()){
            throw  new DataViolationException("Empresa nao possue saldo suficiente para sacar.");
        }

        Double taxa = taxaGateway.taxa(transferenciaRequest);

        Double comTaxaCliente = transferenciaRequest.getValor() - taxa;
        Double comTaxaEmpresa = transferenciaRequest.getValor() + taxa;

        cliente.get().setSaldo(cliente.get().getSaldo() + comTaxaCliente);
        empresa.get().setSaldo(empresa.get().getSaldo() -  comTaxaEmpresa);

        validaTransferenciaGatewayImpl.validar(transferencia);

        carteiraRepository.save(cliente.get());
        carteiraRepository.save(empresa.get());
        enviaEmailSaqueGateway.enviarEmailSaque(cliente.get().getUsuario().getEmail());
        return transferenciaRepository.save(transferencia);
    }
}
