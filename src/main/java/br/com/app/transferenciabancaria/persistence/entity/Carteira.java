package br.com.app.transferenciabancaria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "carteira")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saldo")
    private Double saldo;

    @OneToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public Carteira(Double saldo, Usuario usuario) {
        this.saldo = saldo;
        this.usuario = usuario;
    }
}
