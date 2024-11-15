package Pacote123;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleCadastros {
    ArrayList<Visitante> pessoas = new ArrayList<>();
    TriagemEntradas triagem = new TriagemEntradas();
    Scanner scanner = new Scanner(System.in);

//    ================================================== NOVO CÓDIGO

//  CADASTRAR CLIENTE



    public void cadastroCliente(String nome, String numero, String cpf){
        System.out.println(
                "1 - PLANO DIÁRIO;\n" +
                        "2 - PLANO SEMANAL;\n" +
                        "3 - PLANO MENSAL;\n" +
                        "4 - PLANO VIP;");
        String tipoPlano = scanner.nextLine();
        if (tipoPlano == null || !tipoPlano.matches("\\d+")){
            System.out.println("Valor inválido!");
            return;
        }
        PlanosAssinatura.TipoPlano plano = escolherPlano(tipoPlano);

        cpf=triagem.tratarCpfOuNumero(cpf);
        numero=triagem.tratarCpfOuNumero(numero);

        if (triagem.nomeValido(nome) && triagem.numeroValido(numero) && triagem.cpfValido(cpf)) {
            Cliente novoCliente = new Cliente(nome, numero, cpf, plano);
            pessoas.add(novoCliente);
            System.out.println(nome + " é um novo cliente!");
            return;
        }
        return;
    }

    public Cliente login(String nome, String numero, String cpf){
        for (Visitante pessoa : pessoas){
            if (pessoa instanceof Cliente){
                if (pessoa.nome.equals(nome) && ((Cliente) pessoa).getNumero().equals(numero) &&pessoa.cpf.equals(cpf)){
                    System.out.println("Seja bem-vindo(a) " + pessoa.nome);
                    return (Cliente) pessoa;
                }
            }
        }
        System.out.println("Cliente não encontrado!");;
        return null;
    }

    public void opcoesPlano(){
        System.out.println(
                "1 - PLANO DIÁRIO;\n" +
                "2 - PLANO SEMANAL;\n" +
                "3 - PLANO MENSAL;\n" +
                "4 - PLANO VIP;");
    }

//    ================================================== NOVO CÓDIGO

    //  PARA VISITANTES
    public void entrarComoVisitante(String nome, String cpf){

        cpf=triagem.tratarCpfOuNumero(cpf);

        if (triagem.nomeValido(nome) && triagem.cpfValido(cpf)) {
            Visitante novoVisitante = new Visitante(nome, cpf);
            pessoas.add(novoVisitante);
            System.out.println(nome + " está listado como visitante!");
            return;
        }
    }

    //  PROCUPAR PESSOA
    public void procurarPessoa(String nome, String cpf){

        cpf=triagem.tratarCpfOuNumero(cpf);

        if (triagem.nomeValido(nome) && triagem.cpfValido(cpf)){
            for (Visitante pessoa : pessoas){
                if (!pessoa.nome.equals(nome)) {
                    continue;
                }
                else {
                    if (pessoa.cpf.equals(cpf)){
                        System.out.println(
                                nome + " portador(a) do CPF: " + cpf + "\n" +
                                        "FOI encontrado na lista de entrada." + "\n" +
                                        "///////////////////////////////////////////");
                        return;
                    }
                    continue;
                }
            }
            System.out.println(
                    nome + " portador(a) do CPF: " + cpf + "\n" +
                            "NÃO foi encontrado na lista de entrada." + "\n" +
                            "///////////////////////////////////////////");
            return;
        }
        System.out.println("Digite um CPF válido!");
    }

    //  VERIFICAR ENTRADA
    public void verificarEntrada(String nome, String cpf){
        procurarPessoa(nome, cpf);
    }

    //  MUDAR PLANO PELO NOME DO CLIENTE CADASTRADO
//    O instanceof permite escolher a Classe desejada, no caso "Cliente"
//    Fazendo isso é possível separar Cliente de Visitante mesmo estando na ArrayList do tipo Visitante
    public void mudarPlano(String nome, String cpf){
        System.out.println(
                "1 - PLANO DIÁRIO;\n" +
                        "2 - PLANO SEMANAL;\n" +
                        "3 - PLANO MENSAL;\n" +
                        "4 - PLANO VIP;");
        String tipoPlano = scanner.nextLine();
        if (tipoPlano == null || !tipoPlano.matches("\\d+")){
            System.out.println("Valor inválido!");
        }
        PlanosAssinatura.TipoPlano plano = escolherPlano(tipoPlano);

        cpf=triagem.tratarCpfOuNumero(cpf);

        if (triagem.nomeValido(nome) && triagem.cpfValido(cpf)) {
            for (Visitante pessoa : pessoas){
                if (pessoa instanceof Cliente){
                    if (pessoa.nome.equals(nome) && pessoa.cpf.equals(cpf)){
                        ((Cliente) pessoa).definirPlano(plano);
                    }
                }
            }
        }
        return;
    }

    //  HISTÓRICO COMPLETO
    public void exibirHistorico(){
        for (Visitante pessoa : pessoas){
            pessoa.exibirInfo();
            System.out.println("///////////////////");
        }
    }

    public PlanosAssinatura.TipoPlano escolherPlano(String opcao){
        int numero = Integer.parseInt(opcao);
        switch (numero){
            case 1:
                return PlanosAssinatura.TipoPlano.DIARIO;
            case 2:
                return PlanosAssinatura.TipoPlano.SEMANAL;
            case 3:
                return PlanosAssinatura.TipoPlano.MENSAL;
            case 4:
                return PlanosAssinatura.TipoPlano.VIP;
            default:
                System.out.println("Valor inválido");
                return null;
        }
    }

    public boolean ehVip(PlanosAssinatura.TipoPlano plano){
        if (!plano.equals(PlanosAssinatura.TipoPlano.VIP)){
            return false;
        }
        return true;
    }
}
