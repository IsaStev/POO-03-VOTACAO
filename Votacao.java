package com.mycompany.sistemadevotacao;

    public class Votacao {

        //atributos
        int numeroSecao;
        int numeroCandidato;
     
        //construtor padrão
        public Votacao(){
            this(0,0);
        }
    
        //Contrutor com parametro
        public Votacao(int numeroSecao, int numeroCanditado){
            this.numeroSecao = numeroSecao;
            this.numeroCandidato = numeroCandidato;
        }       
    }