package level;

public enum DificuldadeJogo {
    FACIL(10), MEDIO(7), DIFICIL(5);

    private int tentativas;

    DificuldadeJogo(int tentativas){
        this.tentativas = tentativas;
    }

    public int getTentativas(){
        return tentativas;
    }
}
