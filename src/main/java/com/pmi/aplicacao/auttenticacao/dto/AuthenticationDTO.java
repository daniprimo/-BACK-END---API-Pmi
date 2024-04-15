package com.pmi.aplicacao.auttenticacao.dto;

import lombok.Builder;
@Builder
public record AuthenticationDTO (String login, String password) {

}

