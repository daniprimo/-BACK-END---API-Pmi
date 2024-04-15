package com.pmi.aplicacao.usuario.dto.record;

import lombok.Builder;

@Builder
public record RetornoServicoBase(String dscRetorno, boolean sucesso, String mensagem) {
}
