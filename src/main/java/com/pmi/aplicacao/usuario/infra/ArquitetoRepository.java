package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.Arquiteto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquitetoRepository extends JpaRepository<Arquiteto, String> {
}
