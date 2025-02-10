/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.VeiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class VeiculoDAO 
{
    Connection abrirConexao;
    PreparedStatement envioDadosSql;
    ArrayList <VeiculoDTO> veiculos = new ArrayList<>();
    ResultSet resultado;
    
    public void cadastrarVeiculo(VeiculoDTO veiculoDTO)
    {
        String sql = "INSERT INTO Veiculo(Placa, Cor, Modelo, Porte) VALUES (?, ?, ?, ?)";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setString(1, veiculoDTO.getPlaca());
            envioDadosSql.setString(2, veiculoDTO.getCor());
            envioDadosSql.setString(3, veiculoDTO.getModelo());
            envioDadosSql.setString(4, veiculoDTO.getPorte());
            envioDadosSql.execute();
            envioDadosSql.close();
            
            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso");
        } 
        catch (Exception e) 
        {
            
        }
    }       
    
    public void alterarVeiculoCadastrado(VeiculoDTO veiculoDTO)
    {
        String sql = "UPDATE Veiculo SET Placa = ?, Cor = ?, Modelo = ?, Porte = ? WHERE Placa = ?";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setString(1, veiculoDTO.getPlaca());
            envioDadosSql.setString(2, veiculoDTO.getCor());
            envioDadosSql.setString(3, veiculoDTO.getModelo());
            envioDadosSql.setString(4, veiculoDTO.getPorte());
            envioDadosSql.setString(5, veiculoDTO.getPlaca());            
            envioDadosSql.executeUpdate();
            envioDadosSql.close();
            
            JOptionPane.showMessageDialog(null, "Veículo alterado!");            
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    public void excluirVeiculoCadastrado(VeiculoDTO veiculoDTO)
    {
        String sql = "DELETE FROM Veiculo WHERE Placa = ?";
        abrirConexao = new Conexao().conectaBD();
        
        try 
        {
            envioDadosSql = abrirConexao.prepareStatement(sql);
            envioDadosSql.setString(1, veiculoDTO.getPlaca());
            envioDadosSql.executeUpdate();
            envioDadosSql.close();
            
            JOptionPane.showMessageDialog(null, "Veículo excluído do sistema");
        } 
        catch (Exception e) 
        {
            
        }
    }
}
