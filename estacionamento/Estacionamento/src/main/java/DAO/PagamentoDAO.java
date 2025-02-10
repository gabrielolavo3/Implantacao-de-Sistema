/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PagamentoDTO;
import DTO.VeiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PagamentoDAO 
{
    Connection abrirConexao;
    PreparedStatement envioDadosSql;
    ArrayList <PagamentoDTO> pagamento = new ArrayList<>();
    ResultSet resultado;
    
    public float valorFixo = 10.0f;
    public float adicionalVeiculoGrandePorte = 0.4f;
    
    public float valorGrandePorte(VeiculoDTO veiculo)
    {
        if(veiculo.GrandePorte())
        {
            return valorFixo = valorFixo + (valorFixo * adicionalVeiculoGrandePorte);
        }
        else 
        {
            return valorFixo;
        }
    }
    
    public void inserirPagamento(PagamentoDTO pagamentoDTO, VeiculoDTO veiculoDTO)
    {
        String sql = "INSERT INTO Pagamento(Valor, Horario, tipoPagamento, Veiculo_Placa, Vaga_idVaga) VALUES (?, ?, ?, ?, ?)";
        abrirConexao = new Conexao().conectaBD();
        
        float valor = valorGrandePorte(veiculoDTO);
        pagamentoDTO.setValor(valor);
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setFloat(1, pagamentoDTO.getValor()); // Nao pedi valor ao usuário
            envioDadosSql.setInt(2, pagamentoDTO.getHora());
            envioDadosSql.setString(3, pagamentoDTO.getTipoPagamento());            
            envioDadosSql.setString(4, pagamentoDTO.getFKveiculo());              
            envioDadosSql.setInt(5, pagamentoDTO.getFKvaga());
            envioDadosSql.execute();
            envioDadosSql.close();
            
            JOptionPane.showMessageDialog(null, "Pagamento adicionado com sucesso");
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    public ArrayList<PagamentoDTO> ImprimirPagamento()
    {
        String sql = "SELECT * FROM Pagamento";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            resultado = envioDadosSql.executeQuery();
            
            while(resultado.next())
            {                
               PagamentoDTO pagamentoDTO = new PagamentoDTO();
               
               pagamentoDTO.setIdPagamento(resultado.getInt("idPagamento"));
               pagamentoDTO.setValor(resultado.getFloat("Valor"));
               pagamentoDTO.setHora(resultado.getInt("Horario"));               
               pagamentoDTO.setTipoPagamento(resultado.getString("tipoPagamento"));               
               pagamentoDTO.setFKveiculo(resultado.getString("Veiculo_Placa"));
               pagamentoDTO.setFKvaga(resultado.getInt("Vaga_idVaga"));

               pagamento.add(pagamentoDTO);
            }
        } 
        catch (Exception e) 
        {
            
        }
        
        return pagamento;
    }
}
