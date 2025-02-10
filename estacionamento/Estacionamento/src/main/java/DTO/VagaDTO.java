package DTO;

public class VagaDTO 
{
    private int idVaga;
    private String situcao;
    private String fkVeiculo;

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public String getSitucao() {
        return situcao;
    }

    public void setSitucao(String situcao) {
        this.situcao = situcao;
    }
    
    public String getFKveiculo(){
        return fkVeiculo;
    }
    
    public void setFKveiculo(String fkVeiculo){
        this.fkVeiculo = fkVeiculo;
    }
}
