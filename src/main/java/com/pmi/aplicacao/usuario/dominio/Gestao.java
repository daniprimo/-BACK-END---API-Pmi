package com.pmi.aplicacao.usuario.dominio;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity(name = "tb_gestao")
public class Gestao extends Usuario{
    public Gestao(String login, String encryptedPassword, UsuarioRole role) {
        super(login, encryptedPassword, role);
    }
}
