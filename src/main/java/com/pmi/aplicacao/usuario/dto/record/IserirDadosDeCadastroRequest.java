package com.pmi.aplicacao.usuario.dto.record;

import com.pmi.aplicacao.usuario.dominio.DadosPessoais;
import com.pmi.aplicacao.usuario.dominio.Endereco;
import lombok.Builder;

@Builder
public record IserirDadosDeCadastroRequest(DadosPessoais dadosPessoais, Endereco endereco) {
}
