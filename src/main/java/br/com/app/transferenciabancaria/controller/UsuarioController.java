package br.com.app.transferenciabancaria.controller;


import br.com.app.transferenciabancaria.persistence.entity.Usuario;
import br.com.app.transferenciabancaria.service.UsuarioGatewayImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    private UsuarioGatewayImpl usuarioGatewayImpl;

    public UsuarioController(UsuarioGatewayImpl usuarioGatewayImpl) {
        this.usuarioGatewayImpl = usuarioGatewayImpl;
    }

    @PostMapping()
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid Usuario usuario){
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioGatewayImpl.registrar(usuario));
    }
}
