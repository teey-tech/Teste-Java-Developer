package br.com.app.transferenciabancaria.model.response;


import br.com.app.transferenciabancaria.persistence.entity.Carteira;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaResponse {

    private Long id;
    private String mensagem = "Transferencia Efetuada com sucesso";
    private Double valor;
}
