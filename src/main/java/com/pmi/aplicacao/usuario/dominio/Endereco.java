package com.pmi.aplicacao.usuario.dominio;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;

}
