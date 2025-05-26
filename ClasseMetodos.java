package com.mycompany.sistemadevotacao;

import java.io.*;	
import javax.swing.*;
import java.util.Random;

public class ClasseMetodos {
    
    //função
    public Votacao[]CarregaVotacao(Votacao[]votos){
        Random rand = new Random();
        
        for(int i=0; i<votos.length;i++){
            votos[i] = new Votacao();
            votos[i].numeroSecao = rand.nextInt(11);
            votos[i].numeroCandidato = rand.nextInt(301);
        }
        return votos;
    }
    
    //função
    public Votacao[]ClassificarSecao(Votacao[] votos){
        Votacao temp;
        
        for(int i=0; i<votos.length-1; i++){
            for(int j=i+1; j<votos.length; j++){
                if(votos[i].numeroSecao > votos[j].numeroSecao){
                    temp = votos[i];
                    votos[i] = votos[j];
                    votos[j] = temp;
                }
            }
        }
        return votos;
    }
    
    //função
    public Votacao[] GravarVotacao(Votacao[]votos){
            
        String fileName = "ArquivoVotacao.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){    
            
            for (int i=0; i<votos.length; i++){
                votos[i].numeroSecao = Integer.parseInt(JOptionPane.showInputDialog("Entre o número da seção: "));
                writer.write("Seção: " + votos[i].numeroSecao);
                
                writer.newLine();
                
                votos[i].numeroCandidato = Integer.parseInt(JOptionPane.showInputDialog("Entre com número do candidato: "));
                writer.write("Candidato: " + votos[i].numeroCandidato);
                
                writer.newLine();
            }
            
            writer.close();
            
            for (int i=0; i<votos.length; i++){
                System.out.println("-----------");
                System.out.println("Seção: " + votos[i].numeroSecao);
                System.out.println("Candidato: " + votos[i].numeroCandidato);

            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo " + e.getMessage()); 
        }
        return votos;
    }

    
    //procedimento
    public void EleitorPorSecao(Votacao[]votos) {
        int[] totalPorSecao = new int[100]; // Seções vão de 0 a 99

        for (int i = 0; i < votos.length; i++) {
            int secao = votos[i].numeroSecao;
            if (secao >= 0 && secao < totalPorSecao.length) {
                totalPorSecao[secao] = totalPorSecao[secao] + 1;
            }
        }
        
        System.out.println("Quantidade de eleitores por seção:");
        for (int i = 0; i < totalPorSecao.length; i++) {
            if (totalPorSecao[i] > 0) {
                System.out.println("Seção " + i + ": " + totalPorSecao[i] + " eleitores");
            }
        }
    }
    
    //procedimento
    public void SecaoMaiorMenor(Votacao[]votos){
        int[] totalPorSecao = new int[100]; // Seções de 0 a 99

        for (int i = 0; i < votos.length; i++) {
            int secao = votos[i].numeroSecao;
            if (secao >= 0 && secao < totalPorSecao.length) {
                totalPorSecao[secao]++;
            }
        }

        int maior = 0;
        int menor = Integer.MAX_VALUE;
        int secaoMaior = -1;
        int secaoMenor = -1;

        for (int i = 0; i < totalPorSecao.length; i++) {
            if (totalPorSecao[i] > 0) {
                if (totalPorSecao[i] > maior) {
                    maior = totalPorSecao[i];
                    secaoMaior = i;
                }
                if (totalPorSecao[i] < menor) {
                    menor = totalPorSecao[i];
                    secaoMenor = i;
                }
            }
        }
        System.out.println("Seção com mais eleitores: " + secaoMaior + " com " + maior + " votos.");
        System.out.println("Seção com menos eleitores: " + secaoMenor + " com " + menor + " votos.");
    }
    
    //procedimento
    public void VotosPorCandidato(Votacao[] votos) {
        int[] totalPorCandidato = new int[1000]; // Supondo até 999 candidatos

        for (int i = 0; i < votos.length; i++) {
            int candidato = votos[i].numeroCandidato;
            if (candidato >= 0 && candidato < totalPorCandidato.length) {
                totalPorCandidato[candidato]++;
            }
        }

        System.out.println("Quantidade de votos por candidato:");
        for (int i = 0; i < totalPorCandidato.length; i++) {
            if (totalPorCandidato[i] > 0) {
                System.out.println("Candidato " + i + ": " + totalPorCandidato[i] + " votos");
            }
        }
    }
    
    //procedimento
    public void DezPrimeiros(Votacao[]votos){
        int[] candidatos = new int[1000]; // Supondo que os números dos candidatos vão de 0 a 999

        // Conta os votos de cada candidato
        for (int i = 0; i < votos.length; i++) {
            int num = votos[i].numeroCandidato;
            if (num >= 0 && num < candidatos.length) {
                candidatos[num]++;
            }
        }

        // Vetores para armazenar os top 10
        int[] topCandidatos = new int[10]; // guarda os números dos candidatos
        int[] topVotos = new int[10];      // guarda os votos correspondentes

        // Percorre todos os candidatos para montar o top 10
        for (int i = 0; i < candidatos.length; i++) {
            int votosDoCandidato = candidatos[i];

            // Verifica se esse candidato entra no top 10
            for (int j = 0; j < 10; j++) {
                if (votosDoCandidato > topVotos[j]) {
                    // Desloca os menores para baixo
                    for (int k = 9; k > j; k--) {
                    topVotos[k] = topVotos[k - 1];
                    topCandidatos[k] = topCandidatos[k - 1];
                    }
                    // Insere o novo candidato no lugar certo
                    topVotos[j] = votosDoCandidato;
                    topCandidatos[j] = i;
                    break;
                }
            }
        }   

        // Exibe os top 10
        System.out.println("Top 10 candidatos mais votados:");
        for (int i = 0; i < 10; i++) {
            if (topVotos[i] > 0) {
                System.out.println((i + 1) + "º - Candidato " + topCandidatos[i] + ": " + topVotos[i] + " votos");
            }
        } 
    }
  
}

