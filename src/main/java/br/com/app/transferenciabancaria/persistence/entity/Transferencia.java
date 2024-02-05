package br.com.app.transferenciabancaria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "transferncia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "from_id")
    private Carteira from;

    @OneToOne
    @JoinColumn(name = "to_id")
    private Carteira to;

    @Column(name = "valor")
    private Double valor;

}
