package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Titulo;

public class FiltroRecomendacao {


    public void filtra(Classifica classifica){
        if (classifica.getClassificacao() >= 4){
            System.out.println("Está entre os favoritos do momento");
        } else if(classifica.getClassificacao() >= 2){
            System.out.println("Muito bem avaliado no momento!");
        } else{
            System.out.println("Esse é mais ou menos");
        }
    }
}
