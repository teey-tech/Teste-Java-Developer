package br.com.app.transferenciabancaria.persistence.repository;

import br.com.app.transferenciabancaria.persistence.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
