/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class MovimentacaoDTO 
{
    private int idMovimentacao;
    private int entrada;
    private int saida;
    private String fkVeiculo;

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public String getFkVeiculo() {
        return fkVeiculo;
    }

    public void setFkVeiculo(String fkVeiculo) {
        this.fkVeiculo = fkVeiculo;
    }
}
