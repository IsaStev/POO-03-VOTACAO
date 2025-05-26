package com.mycompany.sistemadevotacao;

import java.io.*;	
import javax.swing.*;	

public class ClassePrincipal {
    
    public static void main(String [] args){
        
        //Objetos de Votação
        Votacao[] votos = new Votacao[200];
        
        //Classe dos metodos
        ClasseMetodos m = new ClasseMetodos();
        
        //Inicializar objetos
        for (int i=0; i<200; i++){
            votos[i] = new Votacao();
        }

        int opc = 0;
        
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("SISTEMA DE VOTAÇÃO \n" +
                    "1- Carregar Seção/Número Eleitor \n" +
                    "2- Classificar por Seção \n" + 
                    "3- Gravar Registros \n" +
                    "4- Mostrar Indicadores \n" +
                    "9- Finalizar \n"));
            
            switch (opc) {
                case 1:
                    m.CarregaVotacao(votos); //chama função
                    break;
                case 2:
                    m.ClassificarSecao(votos); //chama função
                    break;
                case 3:
                    m.GravarVotacao(votos); // chama função
                    break;
                case 4:
                    mostrarIndicadores(votos, m);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Invalida");
            }// fim swich
        }//fim while
    }//fim main
    
    private static void mostrarIndicadores(Votacao[] votos, ClasseMetodos m){
   
        int opc = 0;
        
            while(opc != 9){
                opc = Integer.parseInt(JOptionPane.showInputDialog("MOSTRAR INDICADORES\n" +
                    "Estatísticas de Votação em 2021\n" +
                    "1 – Quantidade de eleitores por seção\n" +
                    "2 – Seção com maior e menor número de eleitores\n" +
                    "3 – Quantidade de votos por candidato\n" +
                    "4 – 10 primeiros colocados (nº candidato e qtd votos)\n" +
                    "9 – Finalizar consulta"));
                
                switch (opc) {
                    case 1:
                        m.EleitorPorSecao(votos); //chama procedimento
                        break;
                    case 2: 
                        m.SecaoMaiorMenor(votos); //chama procedimento
                        break;
                    case 3:
                        m.VotosPorCandidato(votos); // chama procedimento
                        break;
                    case 4:
                        m.DezPrimeiros(votos); // chama procedimento
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "Indicadores finalizado");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Invalida");
                }// fim swich
            }//fim while
    }
}