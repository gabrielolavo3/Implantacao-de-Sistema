/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.VagaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VagaDAO 
{
    Connection abrirConexao;
    PreparedStatement envioDadosSql;
    ArrayList <VagaDTO> arrayVaga = new ArrayList<>();
    ResultSet resultado;
    
    public void SituacaoVaga(VagaDTO vagaDTO)
    {
        String sql = "INSERT INTO Vaga (situacaoVaga, Veiculo_Placa) VALUES (?, ?)";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setString(1, vagaDTO.getSitucao());
            envioDadosSql.setString(2, vagaDTO.getFKveiculo());
            envioDadosSql.execute();
            envioDadosSql.close();
            
            String mensagem = "Vaga de nº " + vagaDTO.getIdVaga() + " adicionada ao sistema";
                    
            JOptionPane.showMessageDialog(null, mensagem);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro no metodo SituacaoVaga(): " + e);
        }
    }
    
    public void alterarStatusDaVaga(VagaDTO vagaDTO)
    {
        String sql = "UPDATE Vaga SET situacaoVaga = ?, Veiculo_Placa = ? WHERE idVaga = ?";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setString(1, vagaDTO.getSitucao());
            envioDadosSql.setString(2, vagaDTO.getFKveiculo());
            envioDadosSql.setInt(3, vagaDTO.getIdVaga());
            envioDadosSql.executeUpdate();
            envioDadosSql.close();
            
            String mensagem = "Alteração na vaga de nº " + vagaDTO.getIdVaga() + " realizada com sucesso";
            
            JOptionPane.showMessageDialog(null, mensagem);
        } 
        catch (Exception erro) 
        {
            JOptionPane.showMessageDialog(null, erro + " : Classe de VagaEstacionamentoDAO");
        }
    }
}
