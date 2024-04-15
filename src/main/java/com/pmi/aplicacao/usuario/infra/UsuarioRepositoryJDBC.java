package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.DadosPessoais;
import com.pmi.aplicacao.usuario.dominio.Endereco;
import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dominio.UsuarioRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Usuario buscarUsuario(String login) {
        StringBuilder query = new StringBuilder();
        Usuario usuario = new Usuario();
        query.append("SELECT * FROM usuario WHERE login = ?");

        SqlRowSet rs = jdbcTemplate.queryForRowSet(query.toString(), login);

        while (rs.next()) {
            Endereco endereco = new Endereco();
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setCep(rs.getString("cep"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            DadosPessoais dadosPessoais = new DadosPessoais();
            dadosPessoais.setCpf(rs.getString("cpf"));
            dadosPessoais.setNome(rs.getString("nome"));
            dadosPessoais.setTelefone(rs.getString("telefone"));
            usuario.setId(rs.getString("id"));
            usuario.setLogin(rs.getString("login"));
            usuario.setRole(UsuarioRole.valueOf(rs.getString("role")));
        }
        return usuario;
    }

}
