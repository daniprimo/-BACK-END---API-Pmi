package com.pmi.aplicacao.teste;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class controller {

    @GetMapping
    public ResponseEntity<String> getTeste() {
        return ResponseEntity.ok("teste");
    }

}
