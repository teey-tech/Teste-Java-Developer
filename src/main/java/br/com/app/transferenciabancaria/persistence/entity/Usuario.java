package br.com.app.transferenciabancaria.persistence.entity;

import br.com.app.transferenciabancaria.enums.UsuarioTipoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "cpf")
    @CPF
    private String cpf;

    @Column(name = "cnpj")
    @CNPJ
    private String cnpj;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private UsuarioTipoEnum tipo;

}
