/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.senac.jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Tabuleiro tabuleiro = new Tabuleiro("1 - cada jogador deve escolher um simbolo; 2 - um jogador inicia a partida");
        
        Jogador jogador1 = new Jogador(1, "Miguel", 'X');
        Jogador jogador2 = new Jogador(2, "spider", 'O');
          
        tabuleiro.mostrarTabuleiro();
        
        do {
            tabuleiro.mostrarTabuleiro();
            
            if (tabuleiro.getJogadorDaVez() == 1) {
                System.out.println("Jogador 1, escolha onde jogar: ");
                String local = entrada.nextLine().toLowerCase();
                
                // Repete até o jogador escolher um espaço livre
                while (!tabuleiro.posicaoEstaVazia(local)) {
                    System.out.println("Posição já ocupada! Escolha outro lugar:");
                    local = entrada.nextLine().toLowerCase();
                }
                
                tabuleiro.marcarJogada(jogador1.getSimbolo(), local);
                tabuleiro.verificarGanhador(jogador1.getSimbolo(), jogador1.getNome());
                tabuleiro.setJogadorDaVez(2);
                
            } else {
                System.out.println("Jogador 2, escolha onde jogar: ");
                String local = entrada.nextLine().toLowerCase();
                
                // Repete até o jogador escolher um espaço livre
                while (!tabuleiro.posicaoEstaVazia(local)) {
                    System.out.println("Posição já ocupada! Escolha outro lugar:");
                    local = entrada.nextLine().toLowerCase();
                }
                
                tabuleiro.marcarJogada(jogador2.getSimbolo(), local);
                tabuleiro.verificarGanhador(jogador2.getSimbolo(), jogador2.getNome());
                tabuleiro.setJogadorDaVez(1);
            }
              
        } while (tabuleiro.isHouveganhadorUltimarodada() == false);
    }
}
    

