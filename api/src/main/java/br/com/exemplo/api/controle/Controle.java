package br.com.exemplo.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.api.modelo.Pessoa;
import br.com.exemplo.api.repositorio.Repositorio;

@RestController
public class Controle 
{
    @GetMapping("")
    public String Mensagem() 
    {
        return "Hello, World";
    }

    @GetMapping("/boasVindas")
    public String BoasVindas() 
    {
        return "Seja bem-vindo";
    }

    @GetMapping("/boasVindas/{nome}")
    public String BoasVindas(@PathVariable String nome) 
    {
        return "Seja bem-vindo, " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) 
    {
        return p;
    }

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa Cadastrar(@RequestBody Pessoa obj) 
    {
        return acao.save(obj);
    }
}
