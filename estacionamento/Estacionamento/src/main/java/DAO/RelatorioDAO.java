/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.RelatorioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RelatorioDAO 
{
    Connection abrirConexao;
    PreparedStatement envioDadosSql;
    ArrayList <RelatorioDTO> relatorio = new ArrayList<>();
    ResultSet resultado;
    
    public void InformacaoRelatorio(RelatorioDTO relatorioDTO)
    {
        String sql = "INSERT INTO Relatorio(Horario, Veiculo_Placa, Pagamento_idPagamento, Ticket_idTicket, Vaga_idVaga) VALUES (?, ?, ?, ?, ?)";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setInt(1, relatorioDTO.getHorario());
            envioDadosSql.setString(2, relatorioDTO.getFkVeiculo());
            envioDadosSql.setInt(3, relatorioDTO.getFkPagamento());
            envioDadosSql.setInt(4, relatorioDTO.getFkTicket());
            envioDadosSql.setInt(5, relatorioDTO.getFkVaga());
            envioDadosSql.execute();
            envioDadosSql.close();
            
            
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    public ArrayList<RelatorioDTO> GerarRelatorio()
    {
        String sql = "SELECT * FROM Relatorio WHERE Horario = ?";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            RelatorioDTO relatorioDTO = new RelatorioDTO();
            
            envioDadosSql = abrirConexao.prepareStatement(sql);                        
            envioDadosSql.setInt(1, relatorioDTO.getHorario());
            envioDadosSql.execute();
            resultado = envioDadosSql.executeQuery();
            
            while(resultado.next())
            {                               
               relatorioDTO.setIdRelatorio(resultado.getInt("idRelatorio"));               
               relatorioDTO.setHorario(resultado.getInt("Horario"));
               relatorioDTO.setFkVeiculo(resultado.getString("Veiculo_Placa"));
               relatorioDTO.setFkPagamento(resultado.getInt("Pagamento_idPagamento"));
               relatorioDTO.setFkTicket(resultado.getInt("Ticket_idTicket"));
               relatorioDTO.setFkVaga(resultado.getInt("Vaga_idVaga"));
               
               relatorio.add(relatorioDTO);
            }
        } 
        catch (Exception e) 
        {
            
        }
        
        return relatorio;
    }
}
