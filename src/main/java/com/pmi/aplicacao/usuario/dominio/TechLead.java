package com.pmi.aplicacao.usuario.dominio;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity(name = "tb_techLead")
public class TechLead extends Usuario {
    public TechLead(String login, String encryptedPassword, UsuarioRole role) {
        super(login, encryptedPassword, role);
    }
}
