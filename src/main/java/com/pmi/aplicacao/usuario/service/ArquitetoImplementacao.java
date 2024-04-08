package com.pmi.aplicacao.usuario.service;

import com.pmi.aplicacao.usuario.api.service.ArquitetoService;
import com.pmi.aplicacao.usuario.dominio.Arquiteto;
import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dto.request.UsuarioRequest;
import com.pmi.aplicacao.usuario.dto.response.UsuarioResponse;
import com.pmi.aplicacao.usuario.infra.ArquitetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArquitetoImplementacao implements ArquitetoService {

    @Autowired
    private ArquitetoRepository arquitetoRepository;

    @Override
    public UsuarioResponse salvarArquiteto(UsuarioRequest usuarioRequest) {
        Usuario usuario = Arquiteto.builder()
                .dadosPessoais(usuarioRequest.getDadosPessoais())
                .login(usuarioRequest.getAcesso().getLogin())
                .password(usuarioRequest.getAcesso().getPassword())
                .role(usuarioRequest.getAcesso().getRole())
                .endereco(usuarioRequest.getEndereco())
                .build();
        Arquiteto arquitetoSalvo = arquitetoRepository.save((Arquiteto) usuario);

        return UsuarioResponse.builder()
                .dadosPessoais(arquitetoSalvo.getDadosPessoais())
                .build();
    }
}
