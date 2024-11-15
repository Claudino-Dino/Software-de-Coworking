package Pacote123;

public class PlanosAssinatura {
    private double valorPlanoAtual;

    // Tipos de Planos
    public enum TipoPlano{
        DIARIO, SEMANAL, MENSAL, VIP
    }

//  PlanosAssinatura.TipoPlano.DIARIO;
//  PlanosAssinatura.TipoPlano.MENSAL;
//  PlanosAssinatura.TipoPlano.SEMANAL;
//  PlanosAssinatura.TipoPlano.VIP;


//  CONSULTAR O PREÇO DO PLANO PELO TIPO DO PLANO
    public double consultarPrecoPlano(TipoPlano plano){
        if (plano.equals(TipoPlano.DIARIO)){
            return this.valorPlanoAtual=10;
        }
        else if (plano.equals(TipoPlano.SEMANAL)) {
            return this.valorPlanoAtual=20;
        }
        else if (plano.equals(TipoPlano.MENSAL)) {
            return this.valorPlanoAtual=30;
        }
        else if (plano.equals(TipoPlano.VIP)){
            return this.valorPlanoAtual=40;
        }
        return 0;
    }
//
    public static void definirPlano(Cliente cliente, TipoPlano plano) {
        cliente.planoAtual=plano;
    }

}