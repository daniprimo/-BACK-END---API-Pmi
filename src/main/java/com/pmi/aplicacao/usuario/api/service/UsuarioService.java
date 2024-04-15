package com.pmi.aplicacao.usuario.api.service;

import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dto.record.IserirDadosDeCadastroRequest;
import com.pmi.aplicacao.usuario.dto.record.RetornoServicoBase;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {


    Usuario buscarUsuario (String login);

    RetornoServicoBase inserirIrnformacoeDoUsuario(String login, IserirDadosDeCadastroRequest request);
}
