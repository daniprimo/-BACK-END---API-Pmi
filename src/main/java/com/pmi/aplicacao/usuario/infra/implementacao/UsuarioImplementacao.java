package com.pmi.aplicacao.usuario.infra.implementacao;

import com.pmi.aplicacao.usuario.api.service.UsuarioService;
import com.pmi.aplicacao.usuario.dominio.DadosPessoais;
import com.pmi.aplicacao.usuario.dominio.Endereco;
import com.pmi.aplicacao.usuario.dominio.Usuario;
import com.pmi.aplicacao.usuario.dto.record.IserirDadosDeCadastroRequest;
import com.pmi.aplicacao.usuario.dto.record.RetornoServicoBase;
import com.pmi.aplicacao.usuario.infra.UsuarioRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplementacao implements UsuarioService {

    @Autowired
    private UsuarioRepositoryJDBC usuarioRepositoryJDBC;

    @Override
    public Usuario buscarUsuario(String login) {
        return usuarioRepositoryJDBC.buscarUsuario(login);
    }

    @Override
    public RetornoServicoBase inserirIrnformacoeDoUsuario(String login, IserirDadosDeCadastroRequest request) {
        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setNome(request.dadosPessoais().getNome());
        dadosPessoais.setCpf(request.dadosPessoais().getCpf());
        dadosPessoais.setTelefone(request.dadosPessoais().getTelefone());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.endereco().getLogradouro());
        endereco.setCep(request.endereco().getCep());
        endereco.setNumero(request.endereco().getNumero());
        endereco.setBairro(request.endereco().getBairro());
        endereco.setCidade(request.endereco().getCidade());



        return usuarioRepositoryJDBC.inserirInformacoesDoUsuario(login, dadosPessoais, endereco);
    }
}
