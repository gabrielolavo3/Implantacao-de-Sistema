package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutosModelo;
import br.com.api.produtos.servico.ProdutoServico;
import br.com.api.produtos.modelo.RespostaModelo;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle 
{
    @Autowired // Inserção automatica

    private ProdutoServico ps;

    // Metodo para cadastrar
    // ResquestBody serve para inserir informções
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutosModelo pm)
    {
        return ps.CadastrarAlterar(pm, "cadastrar");
    }

    // Metodo para fazer alteração    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutosModelo pm)
    {
        return ps.CadastrarAlterar(pm, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> Remover(@PathVariable Long codigo) {
        return ps.Remover(codigo);
    }

    // Cria uma rota que acessa o modelo e lista as informações
    @GetMapping("/listar")
    public Iterable <ProdutosModelo> Listar()
    {
        return ps.listar();
    }

    @GetMapping("")
    public String Rota()
    {
        return "api_funcionario";
    }
}
