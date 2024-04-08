package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.Gestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestaoRepository extends JpaRepository<Gestao, String> {
}
