package com.pmi.aplicacao.usuario.dominio;

public enum UsuarioRole {

    DESENVOLVEDOR("desenvolvedor"),
    TECH_LEAD("TechLead"),
    GESTAO("gestao"),

    ARQUITETO("arquiteto");



    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
