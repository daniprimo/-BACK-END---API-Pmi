package com.pmi.aplicacao.auttenticacao.dto;

import com.pmi.aplicacao.usuario.dominio.UsuarioRole;

public record RegisterDTO(String login, String password, UsuarioRole role) {
}
