package com.pmi.aplicacao.auttenticacao.controller;

import com.pmi.aplicacao.auttenticacao.config.TokenService;
import com.pmi.aplicacao.auttenticacao.dto.AuthenticationDTO;
import com.pmi.aplicacao.auttenticacao.dto.LoginResponseDTO;
import com.pmi.aplicacao.auttenticacao.dto.RegisterDTO;
import com.pmi.aplicacao.auttenticacao.dto.RequestRefreshToken;
import com.pmi.aplicacao.usuario.dominio.*;
import com.pmi.aplicacao.usuario.infra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SealedObject;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationControllerTest {


    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UsuarioRepositoryJDBC usuarioRepositoryJDBC;

    @Mock
    private UsuarioRepository usuarioRepository;


    @Mock
    private ArquitetoRepository arquitetoRepository;

    @Mock
    private GestaoRepository gestaoRepository;

    @Mock
    private TechLeadRepository techLeadRepository;

    @Mock
    private DesenvolvedorRepository desenvolvedorRepository;
    
    @Mock
    private TokenService tokenService;

    @InjectMocks
    private  AuthenticationController authenticationController;

    @Mock
    private UsernamePasswordAuthenticationToken authenticationToken;

    @Mock
    private RequestRefreshToken refreshToken;

    @Mock
    private AuthenticationDTO data;

    @Mock
    private RegisterDTO arquiteto;
    @Mock
    private RegisterDTO techLead;
    @Mock
    private RegisterDTO gestao;
    @Mock
    private RegisterDTO desenvolvedor;
    @Mock
    private RegisterDTO registerNull;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        authenticationToken = new UsernamePasswordAuthenticationToken("admin", "admin");
        data = AuthenticationDTO.builder().login("admin").password("admin").build();
        refreshToken = new RequestRefreshToken("token--refresh");
        arquiteto = new RegisterDTO("admin", "admin", UsuarioRole.ARQUITETO );
        arquiteto = new RegisterDTO("admin", "admin", UsuarioRole.ARQUITETO );
        techLead = new RegisterDTO("admin", "admin", UsuarioRole.TECH_LEAD );
        gestao = new RegisterDTO("admin", "admin", UsuarioRole.GESTAO );
        desenvolvedor = new RegisterDTO("admin", "admin", UsuarioRole.DESENVOLVEDOR );
    }
    
    @Test
    @DisplayName("Testar se o login flui corretamente.")
    void login() {
        Mockito.when(authenticationManager.authenticate(authenticationToken)).thenReturn(authenticationToken);
        Mockito.when(tokenService.obterToken(data))
                .thenReturn(new LoginResponseDTO("token", "refresh-token"));

        ResponseEntity<LoginResponseDTO> login = authenticationController.login(data);

        assertNotNull(login);
        assertEquals("token", login.getBody().token());
        assertEquals("refresh-token", login.getBody().refreshToken());

    }

    @Test
    @DisplayName("Testar as exceptions de um login que não for autenticado.")
    void loginException() {
        Mockito.when(usuarioRepositoryJDBC.buscarUsuario(data.login())).thenThrow(RuntimeException.class);
        Mockito.when(tokenService.validateToken("token invalido")).thenThrow(RuntimeException.class);
        Mockito.when(tokenService.obterToken(data)).thenThrow(RuntimeException.class);

        try {
            ResponseEntity<LoginResponseDTO> login = authenticationController.login(data);
        } catch (Exception en) {
            assertEquals(RuntimeException.class, en.getClass());
        }
    }

    @Test
    @DisplayName("Testar o refresh token.")
    void refreshTokenLogin() throws Exception {
        Mockito.when(tokenService.obterRefresfToken(refreshToken.regreshToken()))
                .thenReturn(new LoginResponseDTO("token", "refresh-token"));

        ResponseEntity<LoginResponseDTO> login = authenticationController.login(refreshToken);

        assertNotNull(login);
        assertEquals("token", login.getBody().token());
        assertEquals("refresh-token", login.getBody().refreshToken());
    }

    @Test
    @DisplayName("Testar as exceptions do refresh token.")
    void refreshTokenLoginExceptions() throws Exception {
        Mockito.when(usuarioRepositoryJDBC.buscarUsuario(data.login())).thenReturn(Usuario.builder().id(null).build());
        Mockito.when(tokenService.obterRefresfToken(refreshToken.regreshToken())).thenThrow(RuntimeException.class);
        Mockito.when(tokenService.validateToken("token invalido")).thenThrow(RuntimeException.class);

        try {
            ResponseEntity<LoginResponseDTO> login = authenticationController.login(refreshToken);
        } catch (Exception en) {
            assertEquals(RuntimeException.class, en.getClass());
        }

    }

    @Test
    @DisplayName("Registrar o arquiteto.")
    void registerArquiteto() {
        String encryptedPassword = new BCryptPasswordEncoder().encode(arquiteto.password());
        Arquiteto add_arquiteto = new Arquiteto();
        add_arquiteto.setId("1");
        add_arquiteto.setLogin("admin");
        add_arquiteto.setPassword("admin");
        Mockito.when(usuarioRepository.findByLogin("gfdg")).thenReturn(null);
        Mockito.when(arquitetoRepository
                .save(new Arquiteto(arquiteto.login(), encryptedPassword, arquiteto.role())))
                .thenReturn(add_arquiteto);

        ResponseEntity<Usuario> register = authenticationController.register(arquiteto);

        assertNotNull(register);
        assertEquals(true, register.getStatusCode().is2xxSuccessful());

    }

    @Test
    @DisplayName("Registrar um para gestao.")
    void registerGestao() {
        String encryptedPassword = new BCryptPasswordEncoder().encode(gestao.password());
        Gestao add_gestao = new Gestao();
        add_gestao.setId("1");
        add_gestao.setLogin("admin");
        add_gestao.setPassword("admin");
        Mockito.when(usuarioRepository.findByLogin("gfdg")).thenReturn(null);
        Mockito.when(gestaoRepository
                        .save(new Gestao(gestao.login(), encryptedPassword, gestao.role())))
                .thenReturn(add_gestao);

        ResponseEntity<Usuario> register = authenticationController.register(gestao);

        assertNotNull(register);
        assertEquals(true, register.getStatusCode().is2xxSuccessful());

    }

    @Test
    @DisplayName("Registrar um tech lead.")
    void registerTechLead() {
        String encryptedPassword = new BCryptPasswordEncoder().encode(techLead.password());
        TechLead tech_lead = new TechLead();
        tech_lead.setId("1");
        tech_lead.setLogin("admin");
        tech_lead.setPassword("admin");
        Mockito.when(usuarioRepository.findByLogin("gfdg")).thenReturn(null);
        Mockito.when(techLeadRepository
                        .save(new TechLead(techLead.login(), encryptedPassword, techLead.role())))
                .thenReturn(tech_lead);

        ResponseEntity<Usuario> register = authenticationController.register(techLead);

        assertNotNull(register);
        assertEquals(true, register.getStatusCode().is2xxSuccessful());

    }

    @Test
    @DisplayName("Registrar um tech lead.")
    void registerDesenvolvedor() {
        String encryptedPassword = new BCryptPasswordEncoder().encode(desenvolvedor.password());
        Desenvolvedor add_desenvolvedor = new Desenvolvedor();
        add_desenvolvedor.setId("1");
        add_desenvolvedor.setLogin("admin");
        add_desenvolvedor.setPassword("admin");
        Mockito.when(usuarioRepository.findByLogin("gfdg")).thenReturn(null);
        Mockito.when(desenvolvedorRepository
                        .save(new Desenvolvedor(desenvolvedor.login(), encryptedPassword, desenvolvedor.role())))
                .thenReturn(add_desenvolvedor);

        ResponseEntity<Usuario> register = authenticationController.register(desenvolvedor);

        assertNotNull(register);
        assertEquals(true, register.getStatusCode().is2xxSuccessful());

    }
}