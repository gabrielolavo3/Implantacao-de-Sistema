package br.com.api.veiculos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.veiculos.modelo.RespostaModelo;
import br.com.api.veiculos.modelo.VeiculoModelo;
import br.com.api.veiculos.repositorio.VeiculoRepositorio;

@Service
public class VeiculoServico 
{
    @Autowired 
    private VeiculoRepositorio pr;
    @Autowired
    private RespostaModelo rm;

    public ResponseEntity<?> CadastrarAlterar(VeiculoModelo pm, String acao)
    {
        if (pm.getMarca().equals(""))
        {
            rm.setMensagem("A marca do véiculo é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else if (pm.getModelo().equals("")){
            rm.setMensagem("O modelo do veículo é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else if (pm.getAno().equals("")){
            rm.setMensagem("O ano válido de fabriação do veículo é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else if (acao.equals("cadastrar")) // Cadastrar as informações caso não sejam nulas
        {
            return new ResponseEntity<VeiculoModelo>(pr.save (pm), HttpStatus.CREATED);
        }
        else 
        {
            return new ResponseEntity<VeiculoModelo>(pr.save (pm), HttpStatus.OK);
        }
    }
    
    public Iterable<VeiculoModelo> listar()
    {
        return pr.findAll();
    }

    public ResponseEntity<RespostaModelo> Remover(Long codigo) 
    {
        pr.deleteById(codigo);
        rm.setMensagem("O produto foi removido");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }    
}
