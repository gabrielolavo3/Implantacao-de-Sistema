package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutosModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico 
{
    @Autowired // Inseri informação automaticamente
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    // Serviço para cadastrar
    // public ResponseEntity<?> cadastrar(ProdutosModelo pm)
    // {
    //     if (pm.getNome().equals(""))
    //     {
    //         rm.setMensagem("O nome do produto é obrigatório");
    //         return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
    //     }
    //     else if (pm.getMarca().equals("")){
    //         rm.setMensagem("O nome da marca é obrigatório");
    //         return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
    //     }
    //     else // Cadastrar as informações caso não sejam nulas
    //     {
    //         return new ResponseEntity<ProdutosModelo>(pr.save (pm), HttpStatus.CREATED);
    //     }
    // }

    public ResponseEntity<?> CadastrarAlterar(ProdutosModelo pm, String acao)
    {
        if (pm.getNome().equals(""))
        {
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else if (pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else if (acao.equals("cadastrar")) // Cadastrar as informações caso não sejam nulas
        {
            return new ResponseEntity<ProdutosModelo>(pr.save (pm), HttpStatus.CREATED);
        }
        else 
        {
            return new ResponseEntity<ProdutosModelo>(pr.save (pm), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> cadastrar(ProdutosModelo pm)
    {
        if (pm.getNome().equals(""))
        {
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else if (pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }
        else // Cadastrar as informações caso não sejam nulas
        {
            return new ResponseEntity<ProdutosModelo>(pr.save (pm), HttpStatus.CREATED);
        }
    }



    // Serviço para acessa o banco e retorna a lista de informações
    public Iterable<ProdutosModelo> listar()
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
