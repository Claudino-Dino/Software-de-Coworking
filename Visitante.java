package Pacote123;

public class Visitante{
    protected String nome;
    protected String cpf;

//  Construtor
    Visitante(String nome, String cpf){
        this.nome=nome;
        this.cpf=cpf;
    }

//  Getters e Setters

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome=novoNome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String novoCpf) {
        this.cpf=novoCpf;
    }

    public void exibirInfo(){
        System.out.println(
                "Nome: " + this.nome + "\n" +
                "--(VISITANTE)--");
    }
}
