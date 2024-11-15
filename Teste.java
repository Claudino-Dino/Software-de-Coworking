package Pacote123;

import java.util.Scanner;

public class Teste {
    Scanner scanner = new Scanner(System.in);

    SalaTrabalho[] salas = new SalaTrabalho[5];

    public void funcionalidadeGeralSala() {

    // Criando o sistema de controle de capacidade total para o coworking
    System.out.print("Digite a capacidade total do coworking: ");
    int capacidadeTotal = scanner.nextInt();
    ControleCapacidade controleCapacidade = new ControleCapacidade(capacidadeTotal);

    // Criando salas de trabalho com diferentes capacidades
    SalaTrabalho[] salas = new SalaTrabalho[5];
    int capacidadeTotalSalas = 0;  // Variável para controlar a capacidade total das salas

    // Loop para inserir as capacidades das salas
    for (int i = 0; i < salas.length; i++) {
        int capacidadeSala;
        // Verificando se a capacidade total das salas não ultrapassa a capacidade do coworking
        do {
            System.out.print("Digite a capacidade para a Sala " + (i + 1) + ": ");
            capacidadeSala = scanner.nextInt();

            // Verifica se a soma das capacidades atuais das salas e a nova capacidade não ultrapassam a capacidade total
            if (capacidadeTotalSalas + capacidadeSala > capacidadeTotal) {
                System.out.println("A capacidade total das salas não pode ultrapassar a capacidade do coworking. Tente novamente.");
            }
        } while (capacidadeTotalSalas + capacidadeSala > capacidadeTotal);  // Continua pedindo até a condição ser atendida

        salas[i] = new SalaTrabalho(i + 1, capacidadeSala);
        capacidadeTotalSalas += capacidadeSala;  // Atualiza a capacidade total das salas
    }

     controleCapacidade = new ControleCapacidade(100);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Exibir informações das salas");
            System.out.println("2 - Reservar uma sala");
            System.out.println("3 - Liberar uma sala");
            System.out.println("4 - Adicionar ocupantes a uma sala");
            System.out.println("5 - Remover ocupantes de uma sala");
            System.out.println("6 - Exibir ocupação total do coworking");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Exibir informações das salas
                    for (SalaTrabalho sala : salas) {
                    sala.exibirInfo();
                    System.out.println();
                }
                    break;

                case 2:
                    // Reservar uma sala
                    System.out.print("Digite o número da sala que deseja reservar (1-5): ");
                    int numeroSalaReserva = scanner.nextInt();
                    System.out.print("Digite o número de pessoas para a reserva: ");
                    int pessoasReserva = scanner.nextInt();
                    System.out.print("A reserva é para VIP? (true/false): ");
                    boolean vipReserva = scanner.nextBoolean();

                    if (numeroSalaReserva >= 1 && numeroSalaReserva <= 5) {
                        salas[numeroSalaReserva - 1].reservar(controleCapacidade, pessoasReserva, vipReserva);
                    } else {
                        System.out.println("Número de sala inválido.");
                    }
                    break;

                case 3:
                    // Liberar uma sala
                    System.out.print("Digite o número da sala que deseja liberar (1-5): ");
                    int numeroSalaLiberar = scanner.nextInt();

                    if (numeroSalaLiberar >= 1 && numeroSalaLiberar <= 5) {
                        salas[numeroSalaLiberar - 1].liberarSala(controleCapacidade);
                    } else {
                        System.out.println("Número de sala inválido.");
                    }
                    break;

                case 4:
                    // Adicionar ocupantes a uma sala
                    System.out.print("Digite o número da sala para adicionar ocupantes (1-5): ");
                    int numeroSalaAdicionar = scanner.nextInt();
                    System.out.print("Digite o número de pessoas a adicionar: ");
                    int pessoasAdicionar = scanner.nextInt();

                    if (numeroSalaAdicionar >= 1 && numeroSalaAdicionar <= 5) {
                        salas[numeroSalaAdicionar - 1].adicionarOcupantes(pessoasAdicionar, controleCapacidade);
                    } else {
                        System.out.println("Número de sala inválido.");
                    }
                    break;

                case 5:
                    // Remover ocupantes de uma sala
                    System.out.print("Digite o número da sala para remover ocupantes (1-5): ");
                    int numeroSalaRemover = scanner.nextInt();
                    System.out.print("Digite o número de pessoas a remover: ");
                    int pessoasRemover = scanner.nextInt();

                    if (numeroSalaRemover >= 1 && numeroSalaRemover <= 5) {
                        salas[numeroSalaRemover - 1].removerOcupantes(pessoasRemover, controleCapacidade);
                    } else {
                        System.out.println("Número de sala inválido.");
                    }
                    break;

                case 6:
                    // Exibir ocupação total do coworking
                    System.out.println("\nOcupação total do espaço: " +
                        controleCapacidade.getOcupacaoTotal() + "/" + controleCapacidade.getCapacidadeTotal());
                    break;

                case 0:
                    // Sair
                    continuar = false;
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

}
