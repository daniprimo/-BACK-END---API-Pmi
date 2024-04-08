package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechLeadRepository extends JpaRepository<TechLead, String> {
}
