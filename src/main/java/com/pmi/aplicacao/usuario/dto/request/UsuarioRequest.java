package com.pmi.aplicacao.usuario.dto.request;

import com.pmi.aplicacao.usuario.dominio.Acesso;
import com.pmi.aplicacao.usuario.dominio.DadosPessoais;
import com.pmi.aplicacao.usuario.dominio.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    private DadosPessoais dadosPessoais;
    private Acesso acesso;
    private Endereco endereco;

}
