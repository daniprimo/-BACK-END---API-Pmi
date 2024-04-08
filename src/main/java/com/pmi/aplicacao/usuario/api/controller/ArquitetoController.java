package com.pmi.aplicacao.usuario.api.controller;

import com.pmi.aplicacao.usuario.api.service.ArquitetoService;
import com.pmi.aplicacao.usuario.dto.response.UsuarioResponse;
import com.pmi.aplicacao.usuario.dto.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class ArquitetoController {

    @Autowired
    private ArquitetoService arquitetoService;

    @PostMapping("/criarArquiteto")
    public ResponseEntity<UsuarioResponse> criarArquiteto(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(arquitetoService.salvarArquiteto(usuarioRequest));
    }

}
