package br.com.app.transferenciabancaria.persistence.repository;

import br.com.app.transferenciabancaria.persistence.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
