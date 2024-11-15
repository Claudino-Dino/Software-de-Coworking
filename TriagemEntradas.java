package Pacote123;

public class TriagemEntradas {

    public String tratarCpfOuNumero(String num){
        try {
            num.replace("-", "");
            num.replace(".", "");
            return num;
        } catch (Exception e){
            return num;
        }
    }

    public boolean nomeValido(String nome){
        nome = nome.replace(" ", "");
        boolean resposta = (nome.chars().allMatch(Character::isLetter));
        if (resposta){
            return true;
        }
        System.out.println("Nome inválido!");
        return false;
    }

    public boolean numeroValido(String numero){
        numero = tratarCpfOuNumero(numero);
        boolean resposta = (numero.length()==8 && numero.matches("\\d+"));
        if (resposta){
            return true;
        }
        System.out.println("Número inválido!");
        return false;
    }

    public boolean cpfValido(String cpf){
        boolean resposta = (cpf.length()==11 && cpf.matches("\\d+"));
        if (resposta) {
            return true;
        }
        System.out.println("CPF inválido!");
        return resposta;
    }


}