package com.pmi.aplicacao.usuario.api.service;

import com.pmi.aplicacao.usuario.dto.request.UsuarioRequest;
import com.pmi.aplicacao.usuario.dto.response.UsuarioResponse;
import org.springframework.stereotype.Service;

@Service
public interface ArquitetoService {
    UsuarioResponse salvarArquiteto(UsuarioRequest usuarioRequest);
}
