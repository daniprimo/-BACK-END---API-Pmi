package com.pmi.aplicacao.auttenticacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste-api")
public class TesteController {
    @GetMapping
    public ResponseEntity<String> getTeste() {
        return ResponseEntity.ok("Teste");
    }
}
