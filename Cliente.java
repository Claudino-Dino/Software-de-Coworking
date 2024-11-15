package Pacote123;

public class Cliente extends Visitante {
    private String numero;
    protected PlanosAssinatura.TipoPlano planoAtual;

    // Construtor
    Cliente(String nome, String numero, String cpf, PlanosAssinatura.TipoPlano plano){
        super(nome, cpf);
        this.numero=numero;
        this.planoAtual=plano;
    }

    public void definirPlano(PlanosAssinatura.TipoPlano plano){
        this.planoAtual=plano;
    }

    // Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome=novoNome;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String novoNumero) {
        this.numero=novoNumero;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public void setCpf(String novoCpf) {
        this.cpf=novoCpf;
    }

    public PlanosAssinatura.TipoPlano getTipoPlano(){return this.planoAtual;}

    @Override
    public void exibirInfo(){
        System.out.println(
                "Nome: " + this.nome + "\n" +
                "Número: " + this.numero + "\n" +
                "CPF: " + this.cpf + "\n" +
                "Plano: " + planoAtual + "\n" +
                "--(CLIENTE)--");
    }

}
