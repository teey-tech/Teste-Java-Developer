package br.com.app.transferenciabancaria.persistence.repository;

import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;
import br.com.app.transferenciabancaria.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);

    Usuario findByCnpj(String cnpj);

    Usuario findByEmail(String email);


}
