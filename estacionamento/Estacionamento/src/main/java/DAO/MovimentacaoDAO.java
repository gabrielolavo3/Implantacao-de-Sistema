/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MovimentacaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class MovimentacaoDAO 
{
    Connection conexaoSql;
    PreparedStatement ps;
    
    public void IncluirMovimentacao(MovimentacaoDTO movimentacaoDTO)
    {
        String sql = "INSERT INTO Movimentacao (Entrada, Saida, Veiculo_Placa) VALUES (?, ?, ?)";
        conexaoSql = new Conexao().conectaBD();
        
        try 
        {
            ps = conexaoSql.prepareStatement(sql);
            ps.setInt(1, movimentacaoDTO.getEntrada());
            ps.setInt(2, movimentacaoDTO.getSaida());
            ps.setString(3, movimentacaoDTO.getFkVeiculo());
            
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Movimentação nº " + movimentacaoDTO.getIdMovimentacao() + " vinculado ao veículo com placa " + movimentacaoDTO.getFkVeiculo());
            
        } 
        catch (Exception e) 
        {
            
        }
    }
}
