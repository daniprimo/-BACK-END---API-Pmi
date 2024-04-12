package com.pmi.aplicacao.usuario.dominio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    @Embedded
    private DadosPessoais dadosPessoais;

    @Embedded
    private Endereco endereco;


    public Usuario(String login, String encryptedPassword, UsuarioRole role) {
            this.setLogin(login);
            this.setPassword(encryptedPassword);
            this.setRole(role);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("Passou pelo authorites");
        if (this.getRole() == UsuarioRole.DESENVOLVEDOR)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if (this.getRole() == UsuarioRole.TECH_LEAD)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if (this.getRole() == UsuarioRole.GESTAO)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if (this.getRole() == UsuarioRole.ARQUITETO)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
