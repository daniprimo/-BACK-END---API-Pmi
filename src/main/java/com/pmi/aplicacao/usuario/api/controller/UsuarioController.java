package com.pmi.aplicacao.usuario.api.controller;

import com.pmi.aplicacao.usuario.api.service.UsuarioService;
import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dto.record.IserirDadosDeCadastroRequest;
import com.pmi.aplicacao.usuario.dto.record.RetornoServicoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioServive;

    @GetMapping("/buscarUsuario/{login}")
    public ResponseEntity<Usuario> getUsuarios(@PathVariable String login) {
        return ResponseEntity.ok(usuarioServive.buscarUsuario(login));
    }

    @PatchMapping("/adicionarInformacoesDoUsuario/{login}")
    public ResponseEntity<RetornoServicoBase> adicionarInformacoesDoUsuario(@PathVariable String login, @RequestBody IserirDadosDeCadastroRequest request) {
        return ResponseEntity.ok(usuarioServive.inserirIrnformacoeDoUsuario(login, request));
    }

}
