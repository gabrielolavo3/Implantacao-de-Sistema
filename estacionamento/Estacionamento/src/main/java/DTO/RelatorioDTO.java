/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class RelatorioDTO 
{
    private int idRelatorio;
    private int horario;
    private String fkVeiculo;
    private int fkTicket;
    private int fkPagamento;    
    private int fkVaga;

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getFkVeiculo() {
        return fkVeiculo;
    }

    public void setFkVeiculo(String fkVeiculo) {
        this.fkVeiculo = fkVeiculo;
    }

    public int getFkTicket() {
        return fkTicket;
    }

    public void setFkTicket(int fkTicket) {
        this.fkTicket = fkTicket;
    }

    public int getFkPagamento() {
        return fkPagamento;
    }

    public void setFkPagamento(int fkPagamento) {
        this.fkPagamento = fkPagamento;
    }

    public int getFkVaga() {
        return fkVaga;
    }

    public void setFkVaga(int fkVaga) {
        this.fkVaga = fkVaga;
    }
}
