package com.pmi.aplicacao.usuario.dominio;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name = "tb_desenvolvedor")
public class Desenvolvedor extends Usuario{

    public Desenvolvedor(String login, String encryptedPassword, UsuarioRole role) {
        super(login, encryptedPassword, role);
    }
}
