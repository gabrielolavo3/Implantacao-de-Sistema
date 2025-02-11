package br.com.exemplo.api.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.api.modelo.Pessoa;

@RestController

public class Controle {

    @GetMapping("")
    public String mensagem()
    {
        return "Hello, World";
    }

    @GetMapping("/boasVindas")
    public String boasVindas()
    {
        return "Seja bem-vindo";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome)
    {
        return "Seja bem-vindo, " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p)
    {
        return p;
    }
}
