package Pacote123;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Teste teste =  new Teste();
        ControleCadastros controleCadastros2 = new ControleCadastros();
        TriagemEntradas triagemEntradas = new TriagemEntradas();

        int opcaoInt = 1, opcao2 = 0;

        while (opcaoInt != 3) {

//            ESCOLHA DE OPÇÃO DO SWITCH CASE
            System.out.println("DIGITE UMA OPÇÃO:\n" + "1 - LOGIN\n" + "2 - CADASTRO\n" + "3 - SAIR");
            String opcao = scan.nextLine();
            opcao = triagemEntradas.tratarCpfOuNumero(opcao);
            opcaoInt = Integer.parseInt(opcao);

            switch (opcaoInt) {
                case 1:
//                PEDIR NOME, NUMERO, CPF
                    System.out.println("Digite o nome:");
                    String nome=scan.nextLine();

                    System.out.println("Digite o numero:");
                    String numero=scan.nextLine();

                    System.out.println("Digite o cpf:");
                    String cpf=scan.nextLine();

//                Tratar NUMERO, CPF;
                    cpf = triagemEntradas.tratarCpfOuNumero(cpf);
                    numero = triagemEntradas.tratarCpfOuNumero(numero);

//                LOGIN;
                    Cliente cliente = controleCadastros2.login(nome, numero, cpf);

//                    FAZER MENU DE OPÇÕES DOS CASES:
//                    DIGITE UMA OPÇÃO:
//                    1 - FUNCIONALIDADES SALA
//                    2 - OPÇÕES DO USUÁRIO
//

//                    System.out.println("DIGITE UMA OPÇÃO:\n" + "1 - LOGIN\n" + "2 - CADASTRO\n" + "3 - SAIR");
//                    opcao2 = scan.nextInt();
//                    opcao2 = triagemEntradas.tratarCpfOuNumero(opcao);
//                    opcaoInt = Integer.parseInt(opcao);

                    switch (1) {
                        case 1:
//                        FUNCIONALIDADES_SALA();
                            teste.funcionalidadeGeralSala();

//                        PAGAMENTO(CLIENTE)

                        case 2:
//                        OPÇÕES_DO_USUÁRIO(CLIENTE)

                        default:
                            System.out.println("Digite uma opção válida");
                            break;
                    }
                case 2:
//                CADASTRAR(); RETURN OPÇÃO = 1
//                PEDIR NOME, NUMERO, CPF
                    System.out.println("Digite o nome:");
                    nome=null; nome=scan.nextLine();

                    System.out.println("Digite o numero:");
                    numero=null; numero=scan.nextLine();
//
                    System.out.println("Digite o cpf:");
                    cpf=null; cpf=scan.nextLine();

                    controleCadastros2.cadastroCliente(nome, numero, cpf);

                case 3:
//                SAIR
                    System.out.println("FINALIZANDO");
                    break;
            }

        }

    }

    public void opcoes(){
        System.out.println(
                "DIGITE UMA OPÇÃO:\n" +
                "1 - LOGIN\n" +
                "2 - CADASTRO\n" +
                "3 - SAIR");
    }

}
