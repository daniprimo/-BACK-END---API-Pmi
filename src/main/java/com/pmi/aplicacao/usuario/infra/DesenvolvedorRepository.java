package com.pmi.aplicacao.usuario.infra;

import com.pmi.aplicacao.usuario.dominio.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, String> {

}
