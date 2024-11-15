package Pacote123;

import java.util.Scanner;

public class AssistenteDePagamento {
    Scanner scanner = new Scanner(System.in);

    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String cvv;
    private double precoASerPago;

    public int opcaoPagamento;


    public String getNumeroCartao(){
        return numeroCartao;
    }

    public String getNomeTitular(){
        return nomeTitular;
    }

    public String getDataValidade(){
        return dataValidade;
    }

    public String getCvv(){
        return cvv;
    }

    public double getPrecoASerPago(){
        return precoASerPago;
    }

    public int getOpcaoPagamento(){
        return opcaoPagamento;
    }

    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }

    public void setNomeTitular(String nomeTitular){
        this.nomeTitular = nomeTitular;
    }

    public void setDataValidade(String dataValidade){
        this.dataValidade = dataValidade;
    }

    public void setCvv(String cvv){
        this.cvv = cvv;
    }

    public void setPrecoASerPago(double precoASerPago){
        this.precoASerPago = precoASerPago;
    }

    public void setOpcaoPagamento(int opcaoPagamento){
        this.opcaoPagamento = opcaoPagamento;
    }


    public void escolherPagamento(){
        System.out.println("Escolha o tipo de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Cartão de Débito");
        System.out.println("3 - Boleto");
        System.out.println("4 - Pix");
        setOpcaoPagamento(scanner.nextInt());
        scanner.nextLine();

        switch (getOpcaoPagamento()){
            case 1:
                realizarPagamentoCredito();
                resumoDaCompra();
                break;
            case 2:
                realizarPagamentoDebito();
                resumoDaCompra();
                break;
            case 3:
                realizarPagamentoBoleto();
                resumoDaCompra();
                break;
            case 4:
                realizarPagamentoPix();
                resumoDaCompra();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    public void realizarPagamentoCredito(){
        System.out.println(" ");
        System.out.println("Informações do cartão de crédito");
        System.out.println("Número do cartão: ");
        setNumeroCartao(scanner.nextLine());
        System.out.println("Nome do titular: ");
        setNomeTitular(scanner.nextLine());
        System.out.println("Data de validade: ");
        setDataValidade(scanner.nextLine());
        System.out.println("CVV: ");
        setCvv(scanner.nextLine());
        System.out.println("Preço a ser pago: R$"); //mudar isso depois com a classe do romerssom
        setPrecoASerPago(scanner.nextDouble());

        scanner.close();
    }

    public void resumoDaCompra(){
        if (getOpcaoPagamento() == 1 || getOpcaoPagamento() == 2){
            System.out.println(" ");
            System.out.println("Resumo da Compra: ");
            System.out.println("Número do cartão: " + numeroCartao);
            System.out.println("Nome do titular: " + nomeTitular);
            System.out.println("Data de validade: " + dataValidade);
            System.out.println("CVV: " + cvv);
            System.out.println("Preço a ser pago: R$" + precoASerPago);
        } else if (getOpcaoPagamento() == 3) {
            System.out.println(" ");
            System.out.println("Resumo da Compra: ");
            System.out.println("Preço a ser pago: R$" + precoASerPago);
        } else if (getOpcaoPagamento() == 4){
            System.out.println(" ");
            System.out.println("Resumo da Compra: ");
            System.out.println("Preço a ser pago: R$" + precoASerPago);
        }
    }

    public void realizarPagamentoDebito(){
        System.out.println(" ");
        System.out.println("Informações do cartão de Débito");
        System.out.println("Número do cartão: ");
        setNumeroCartao(scanner.nextLine());
        System.out.println("Nome do titular: ");
        setNomeTitular(scanner.nextLine());
        System.out.println("Data de validade: ");
        setDataValidade(scanner.nextLine());
        System.out.println("CVV: ");
        setCvv(scanner.nextLine());
        System.out.println("Preço a ser pago: R$"); //mudar isso depois com a classe do romerssom
        setPrecoASerPago(scanner.nextDouble());

        scanner.close();
    }

    public void realizarPagamentoBoleto(){
        System.out.println("Boleto Gerado!");
    }

    public void realizarPagamentoPix(){
        System.out.println("Código PIX gerado!");

    }

}