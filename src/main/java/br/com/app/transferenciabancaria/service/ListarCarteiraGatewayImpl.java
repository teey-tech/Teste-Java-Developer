package br.com.app.transferenciabancaria.service;

import br.com.app.transferenciabancaria.gateway.ListarCarteiraGateway;
import br.com.app.transferenciabancaria.persistence.entity.Carteira;
import br.com.app.transferenciabancaria.persistence.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCarteiraGatewayImpl implements ListarCarteiraGateway {

    private CarteiraRepository carteiraRepository;

    public ListarCarteiraGatewayImpl(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }


    @Override
    public List<Carteira> listarTodos() {
        return carteiraRepository.findAll();
    }
}
