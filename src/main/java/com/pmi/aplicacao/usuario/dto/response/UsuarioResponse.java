package com.pmi.aplicacao.usuario.dto.response;

import com.pmi.aplicacao.usuario.dominio.DadosPessoais;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private DadosPessoais dadosPessoais;

}
