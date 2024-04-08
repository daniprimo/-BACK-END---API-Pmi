package com.pmi.aplicacao.usuario.dominio;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity(name = "tb_arquiteto")
public class Arquiteto extends Usuario{
    public Arquiteto(String login, String encryptedPassword, UsuarioRole role) {
        super(login, encryptedPassword, role);
    }
}
