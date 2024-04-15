package com.pmi.aplicacao.auttenticacao.dto;

import lombok.Builder;

@Builder
public record LoginResponseDTO(String token, String refreshToken) {
}
