package br.com.api.veiculos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.veiculos.modelo.RespostaModelo;
import br.com.api.veiculos.modelo.VeiculoModelo;
import br.com.api.veiculos.servico.VeiculoServico;

@RestController
@CrossOrigin(origins = "*")
public class VeiculoControle 
{
    @Autowired 
    private VeiculoServico ps;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody VeiculoModelo pm)
    {
        return ps.CadastrarAlterar(pm, "cadastrar");
    }
       
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody VeiculoModelo pm)
    {
        return ps.CadastrarAlterar(pm, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> Remover(@PathVariable Long codigo) {
        return ps.Remover(codigo);
    }
    
    @GetMapping("/listar")
    public Iterable <VeiculoModelo> Listar()
    {
        return ps.listar();
    }

    @GetMapping("/")
    public String Rota()
    {
        return "api_funcionario";
    }    
}
