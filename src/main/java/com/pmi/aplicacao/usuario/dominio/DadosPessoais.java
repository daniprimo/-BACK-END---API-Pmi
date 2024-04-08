package com.pmi.aplicacao.usuario.dominio;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoais {

    private String nome;
    private String cpf;
    private String telefone;

}
