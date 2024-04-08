package com.pmi.aplicacao.auttenticacao.controller;


import com.pmi.aplicacao.auttenticacao.config.TokenService;
import com.pmi.aplicacao.auttenticacao.dto.AuthenticationDTO;
import com.pmi.aplicacao.auttenticacao.dto.LoginResponseDTO;
import com.pmi.aplicacao.auttenticacao.dto.RegisterDTO;
import com.pmi.aplicacao.usuario.dominio.*;
import com.pmi.aplicacao.usuario.infra.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticar")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ArquitetoRepository arquitetoRepository;

    @Autowired
    private GestaoRepository gestaoRepository;

    @Autowired
    private TechLeadRepository techLeadRepository;

    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
       try {
           UsernamePasswordAuthenticationToken usernamePassword =
                   new UsernamePasswordAuthenticationToken(data.login(), data.password());
           var auth = this.authenticationManager.authenticate(usernamePassword);
           System.out.println(auth);
           var token = this.tokenService.geradorToken((Usuario) auth.getPrincipal());
           return ResponseEntity.ok(new LoginResponseDTO(token));
       }catch (UsernameNotFoundException e) {
           throw new RuntimeException("Erro na autenticação");
       }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.usuarioRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        
        Usuario usuario = new Usuario();
        if (data.role() == UsuarioRole.ARQUITETO) {
            Arquiteto newUser = new Arquiteto(data.login(), encryptedPassword, data.role());
            usuario = this.arquitetoRepository.save(newUser);
        }


        if (data.role() == UsuarioRole.GESTAO) {
            Gestao newUser = new Gestao(data.login(), encryptedPassword, data.role());
            usuario = this.gestaoRepository.save(newUser);
        }


        if (data.role() == UsuarioRole.TECH_LEAD) {
            TechLead newUser = new TechLead(data.login(), encryptedPassword, data.role());
            usuario = this.techLeadRepository.save(newUser);
        }


        if (data.role() == UsuarioRole.DESENVOLVEDOR) {
            Desenvolvedor newUser = new Desenvolvedor(data.login(), encryptedPassword, data.role());
            usuario = this.desenvolvedorRepository.save(newUser);
        }



        return ResponseEntity.ok(usuario);
    }

}
