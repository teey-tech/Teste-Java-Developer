package br.com.app.transferenciabancaria.controller;

import br.com.app.transferenciabancaria.persistence.entity.Carteira;
import br.com.app.transferenciabancaria.service.ListarCarteiraGatewayImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/carteira")
public class CarteiraController {


    private ListarCarteiraGatewayImpl listarCarteiraImpl;

    public CarteiraController(ListarCarteiraGatewayImpl listarCarteiraImpl) {
        this.listarCarteiraImpl = listarCarteiraImpl;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Carteira>> listarTodos(){
        return ResponseEntity.ok(listarCarteiraImpl.listarTodos());
    }
}
