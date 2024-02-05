package br.com.app.transferenciabancaria.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaRequest {

    @JsonIgnore
    private Long id;

    private Long fromId;

    private Long toId;

    private Double valor;
}
