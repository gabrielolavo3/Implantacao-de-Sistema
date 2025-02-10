/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MAIN;

import java.util.Scanner;
import DAO.*;
import DTO.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) 
    {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        TicketDAO ticketDAO = new TicketDAO();
        VagaDAO vagaDAO = new VagaDAO();
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        
        ArrayList<VeiculoDTO> veiculoDTO = new ArrayList<>();
        ArrayList<TicketDTO> ticketDTO = new ArrayList<>();
        ArrayList<VagaDTO> vagaDTO = new ArrayList<>();
        ArrayList<MovimentacaoDTO> movimentacaoDTO = new ArrayList<>();
        ArrayList<PagamentoDTO> pagamentoDTO = new ArrayList<>();
        ArrayList<RelatorioDTO> relatorioDTO = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        
        while (true) 
        {            
            System.out.println("\nAções Disponíveis");
            System.out.println("1 - Leão");
            System.out.println("2 - Elefante");
            System.out.println("3 - Papagaio");
            System.out.println("4 - Sair e exibir dados");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt(); 
            sc.nextLine();
        }
    }
    
}
