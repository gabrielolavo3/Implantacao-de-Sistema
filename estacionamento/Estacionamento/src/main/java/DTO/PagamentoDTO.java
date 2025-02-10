/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class PagamentoDTO 
{
    private int idPagamento;
    private float valor;
    private String tipoPagamento;
    private int hora;
    private String FKveiculo;
    private int FKvaga;

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getFKveiculo() {
        return FKveiculo;
    }

    public void setFKveiculo(String FKveiculo) {
        this.FKveiculo = FKveiculo;
    }

    public int getFKvaga() {
        return FKvaga;
    }

    public void setFKvaga(int FKvaga) {
        this.FKvaga = FKvaga;
    }
}
