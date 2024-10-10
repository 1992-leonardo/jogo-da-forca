package service;

import level.DificuldadeJogo;

import java.util.Random;

public class JogoService {
    private String[] palavras = {"BANANA", "UVA", "ABAXAXI", "LARANJA"};
    private String palavraSecreta;
    private char[] palavraAdivinhada;
    private int tentativas;

    public JogoService(DificuldadeJogo dificuldadeJogo){
        this.palavraSecreta = escolherPalavraAleatoria();
        this.palavraAdivinhada = new char[palavraSecreta.length()];
        this.tentativas = dificuldadeJogo.getTentativas();

        for(int i = 0; i < palavraAdivinhada.length; i++){
            palavraAdivinhada[i] = '_';
        }
    }

    private String escolherPalavraAleatoria(){
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public boolean verificarLetra(char letra){
        boolean acertouPalavra = false;
        for (int i = 0; i < palavraSecreta.length(); i++){
            if (palavraSecreta.charAt(i) == letra){
                palavraAdivinhada[i] = letra;
                acertouPalavra = true;
            }
        }
        return acertouPalavra;
    }

    public boolean terminou(){
        return tentativas == 0 || palavraSecreta.equals(new String(palavraAdivinhada));
    }

    public void diminuirTentativas(){
        tentativas--;
    }

    public String getPalavraAdivinhada(){
        return new String(palavraAdivinhada);
    }

    public int getTentativasRestantes(){
        return tentativas;
    }

}
