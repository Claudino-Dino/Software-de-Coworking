package Pacote123;

public class SalaTrabalho {
    private int numero;
    private int capacidade;
    private int ocupacaoAtual;
    private boolean disponivel;
    private boolean reservadoVIP;
    private static final double PRECO_PADRAO = 100.0;

    // Construtor
    public SalaTrabalho(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.disponivel = true;
        this.ocupacaoAtual = 0;
    }

    // Exibe informações da sala
    public void exibirInfo() {
        System.out.println("Número da Sala: " + numero);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Ocupação Atual: " + ocupacaoAtual);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("Reservado para VIP: " + (reservadoVIP ? "Sim" : "Não"));
    }

    // Calcula o preço da reserva com base no tipo de usuário
    public double calcularPreco(boolean vip) {
        if (vip) {
            return PRECO_PADRAO * 0.8; // Aplica desconto de 20% para VIPs
        }
        return PRECO_PADRAO;
    }

    // Tenta reservar a sala e calcula o preço
    public void reservar(ControleCapacidade controleCapacidade, int pessoas, boolean vip) {
        if (!disponivel) {
            System.out.println("Reserva não permitida para Sala " + numero + ": Sala já está reservada.\n");
        } else if (pessoas > capacidade) {
            System.out.println("Reserva não permitida para Sala " + numero + ": Capacidade insuficiente.\n");
        } else if (controleCapacidade.adicionarOcupante(pessoas)) {
            ocupacaoAtual = pessoas;
            disponivel = false;
            reservadoVIP = vip;
            double preco = calcularPreco(vip);
            System.out.println("Sala " + numero + " reservada com sucesso" + (vip ? " para VIP" : "") + ".");
            System.out.println("Preço da reserva: R$" + preco + "\n");
        } else {
            System.out.println("Reserva não permitida para Sala " + numero + ": Limite de ocupação total do espaço atingido.\n");
        }
    }

    // Libera a sala
    public void liberarSala(ControleCapacidade controleCapacidade) {
        if (!disponivel) {
            controleCapacidade.removerOcupante(ocupacaoAtual);
            ocupacaoAtual = 0;
            disponivel = true;
            reservadoVIP = false;
            System.out.println("Sala " + numero + " liberada com sucesso.\n");
        } else {
            System.out.println("Erro: Sala " + numero + " já está disponível.");
        }
    }

    // Adiciona ocupantes à sala
    public void adicionarOcupantes(int pessoas, ControleCapacidade controleCapacidade) {
        // Só permite adicionar se não for uma sala VIP ou se a sala não estiver cheia
        if (!reservadoVIP && ocupacaoAtual + pessoas <= capacidade && controleCapacidade.adicionarOcupante(pessoas)) {
            ocupacaoAtual += pessoas;
            System.out.println(pessoas + " pessoas adicionadas à Sala " + numero + ". Ocupação atual: " + ocupacaoAtual + "\n");
        } else if (reservadoVIP) {
            System.out.println("Não é possível adicionar ocupantes à Sala " + numero + " pois está reservada para VIP.\n");
        } else {
            System.out.println("Não foi possível adicionar " + pessoas + " pessoas à Sala " + numero + ". Capacidade insuficiente ou ocupação máxima atingida.\n");
        }
    }

    // Remove ocupantes da sala
    public void removerOcupantes(int pessoas, ControleCapacidade controleCapacidade) {
        if (ocupacaoAtual - pessoas >= 0) {
            ocupacaoAtual -= pessoas;
            controleCapacidade.removerOcupante(pessoas);
            System.out.println(pessoas + " pessoas removidas da Sala " + numero + ". Ocupação atual: " + ocupacaoAtual + "\n");
        } else {
            System.out.println("Não é possível remover " + pessoas + " pessoas da Sala " + numero + ". A ocupação atual é menor que o número de pessoas a serem removidas.\n");
        }
    }



}


