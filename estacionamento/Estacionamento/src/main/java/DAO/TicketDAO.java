/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TicketDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TicketDAO 
{
    Connection abrirConexao;
    PreparedStatement envioDadosSql;
    ArrayList <TicketDTO> ticket = new ArrayList<>();
    ResultSet resultado;
    
    public void criarTicket(TicketDTO ticketDTO)
    {
        String sql = "INSERT INTO Ticket(codigoIdentificacao, Veiculo_Placa) VALUES (?, ?)";
        abrirConexao = new Conexao().conectaBD();
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setString(1, ticketDTO.getCodigoIdentificacao());
            envioDadosSql.setString(2, ticketDTO.getFKVeiculo());
            envioDadosSql.execute();
            envioDadosSql.close();
            
            JOptionPane.showMessageDialog(null, "O Ticket " + ticketDTO.getIdTicket() + " foi criado com sucesso");
        } 
        catch (Exception e) 
        {
            
        }
        
    }
    
    public ArrayList<TicketDTO> GerarTicket()
    {
        String sql = "SELECT * FROM Ticket WHERE Veiculo_idPlaca = ?";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            
            TicketDTO ticketDTO = new TicketDTO();
            
            envioDadosSql.setString(1, ticketDTO.getFKVeiculo());
            resultado = envioDadosSql.executeQuery();
            
            while(resultado.next())
            {                
                ticketDTO.setIdTicket(resultado.getInt("idTicket"));
                ticketDTO.setCodigoIdentificacao(resultado.getString("codigoIdentificacao"));
                ticketDTO.setFKVeiculo(resultado.getString("Veiculo_Placa"));
                ticket.add(ticketDTO);
            }
        } 
        catch (Exception e) 
        {
            
        }
        
        return ticket;
    }
}
