package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.DadosPessoais;
import com.pmi.aplicacao.usuario.dominio.Endereco;
import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dominio.UsuarioRole;
import com.pmi.aplicacao.usuario.dto.record.RetornoServicoBase;
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

    public RetornoServicoBase inserirInformacoesDoUsuario(String login, DadosPessoais dadosPessoais, Endereco endereco) {

        try {
            StringBuffer query = new StringBuffer();
            query.append("UPDATE usuario " +
                    " SET cpf=?, " +
                    "nome=?, " +
                    "telefone=?, " +
                    "cep=?, " +
                    "bairro=?, " +
                    "logradouro=?, " +
                    "cidade=?, " +
                    "numero=?, " +
                    "primeiro_acesso=? " +
                    "where login = ?");

            System.out.println(query.toString());
            jdbcTemplate.update(query.toString(),
                                dadosPessoais.getCpf(),
                                dadosPessoais.getNome(),
                                dadosPessoais.getTelefone(),
                                endereco.getCep(),
                                endereco.getBairro(),
                                endereco.getLogradouro(),
                                endereco.getCidade(),
                                endereco.getNumero(),
                                false,
                                login);
            return new RetornoServicoBase(
                    "ATUALIZAR",
                    true,
                    "Usuario atualizado com sucesso.");
        }catch (Exception e) {
            return new RetornoServicoBase(
                    "ATUALIZAR",
                    false,
                    "Usuario não foi atualizado.");

        }

    }
}
