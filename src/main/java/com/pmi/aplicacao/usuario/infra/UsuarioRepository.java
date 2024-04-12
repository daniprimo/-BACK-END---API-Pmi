package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    UserDetails findByLogin(String login);

    @Query(value = "SELECT * FROM usuario WHERE login = ?", nativeQuery = true)
    Usuario findByLoginSql(String login);
}
