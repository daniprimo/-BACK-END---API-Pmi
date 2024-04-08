package com.pmi.aplicacao.usuario.dominio;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acesso{

    private String login;
    private String password;
    private UsuarioRole role;


}
