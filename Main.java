//package Pacote123;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        ControleCadastros controleCadastros = new ControleCadastros();
//
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println(
//                "Digite uma opção\n" +
//                "1 - CADASTRO ou LOGIN;\n" +
//                "2 - SAIR\n");
//
//        int opcao = scan.nextInt();
//        int opcao2;
//
//        switch (opcao){
//            case 1:
//                System.out.println("\nDigite o nome: ");
//                String nome = scan.nextLine();
//                scan.nextLine();
//
//                System.out.println("\nDigite o numero: ");
//                String numero = scan.nextLine();
//
//                System.out.println("\nDigite o cpf: ");
//                String cpf = scan.nextLine();
//
//                System.out.println(
//                        "1 - PLANO DIÁRIO;\n" +
//                                "2 - PLANO SEMANAL;\n" +
//                                "3 - PLANO MENSAL;\n" +
//                                "4 - PLANO VIP;");
//                String tipoPlano = scan.nextLine();
//                if (tipoPlano == null || !tipoPlano.matches("\\d+")){
//                    System.out.println("Valor inválido!");
//                    return;
//                }
//                PlanosAssinatura.TipoPlano plano = controleCadastros.escolherPlano(tipoPlano);
//
//                Cliente cliente = new Cliente(nome, numero, cpf, plano);
//
//                // ======================================================= SWITCH 2 >
//
//                System.out.println("DIGITE A OPÇÃO\n" +
//                        "1 - RESERVAR SALA\n" +
//                        "2 - DISPONIBILIDADE DA SALA\n" +
//                        "3 - SAIR\n");
//
//                opcao2 = scan.nextInt();
//                switch (opcao2){
//                    case 1:
//                        System.out.println("Digite o número da sala:");
//
//                        int numero2 = scan.nextInt();
//
//                        SalaTrabalho salaTrabalho = new SalaTrabalho(cliente, numero2, 100);
//                        ControleCapacidade controleCapacidade = new ControleCapacidade();
//
//                        System.out.println("Digite a quantidade de pessoas: ");
//                        int qtdePessoas = scan.nextInt();
//
//                        boolean planoVip = controleCadastros.ehVip(plano);
//
//                        salaTrabalho.reservar(controleCapacidade, qtdePessoas, planoVip);
//                    case 2:
//
//                    case 3:
//                        break;
//                }
//            case 2:
//                System.out.println("Saindo...");
//                break;
//            default:
//                System.out.println("Valor inválido");
//
//        }
//    }
//}
//
//
