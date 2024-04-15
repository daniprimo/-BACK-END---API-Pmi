package com.pmi.aplicacao.usuario.infra.implementacao;

import com.pmi.aplicacao.usuario.api.service.UsuarioService;
import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dto.record.IserirDadosDeCadastroRequest;
import com.pmi.aplicacao.usuario.dto.record.RetornoServicoBase;
import com.pmi.aplicacao.usuario.infra.UsuarioRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplementacao implements UsuarioService {

    @Autowired
    private UsuarioRepositoryJDBC usuarioRepositoryJDBC;

    @Override
    public Usuario buscarUsuario(String login) {
        return usuarioRepositoryJDBC.buscarUsuario(login);
    }

    @Override
    public RetornoServicoBase inserirIrnformacoeDoUsuario(String login, IserirDadosDeCadastroRequest request) {
        return null;
    }
}
