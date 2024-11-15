package Pacote123;

public class ControleCapacidade {
    private int capacidadeTotal;
    private int ocupacaoTotal;

    // Construtor
    public ControleCapacidade(int capacidadeTotal) {
        this.capacidadeTotal = 200;
        this.ocupacaoTotal = 0;
    }

    // Verifica se é possível adicionar ocupantes
    public boolean adicionarOcupante(int pessoas) {
        if (ocupacaoTotal + pessoas <= capacidadeTotal) {
            ocupacaoTotal += pessoas;
            return true;
        }
        return false;
    }

    // Remove ocupantes da ocupação total
    public void removerOcupante(int pessoas) {
        ocupacaoTotal -= pessoas;
        if (ocupacaoTotal < 0) ocupacaoTotal = 0; // Evita valores negativos
    }

    // Getters
    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public int getOcupacaoTotal() {
        return ocupacaoTotal;
    }
}
