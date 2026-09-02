/*
    Biblioteca de operações básicas (soma, subtração, divisão e multiplicação)
    Suporta múltiplos argumentos

    @author: Kayke Henrique (202421250032)
 */

public class Calculadora_202421250032{

    public static class DivisaoPorZeroException extends ArithmeticException {
        /*
            Cria a exceção com uma mensagem descritiva do erro.
        */
        public DivisaoPorZeroException(String mensagem){
            super(mensagem);
        }
    }

    public double soma(double ... numeros){
        if(numeros == null) return 0;
        double total = 0;
        for(double valor: numeros){
            total += valor;
        }
        return total;
    }

    public double sub(double valorInicial, double ... numeros){
        if(numeros == null) return valorInicial;
        for(double valor: numeros){
            valorInicial -= valor;
        }

        return valorInicial;
    }

    public double mult(double ... numeros){
        if(numeros == null) return 1; // retorna 1 pois é o número neutro da multiplicação
        double total = 1;
        for(double valor: numeros){
            if(valor == 0) return 0;
            total *= valor;
        }
        return total;
    }

    public double divisao(double valorInicial, double ... numeros){
        if(valorInicial == 0){
            for(double valor: numeros){
                if(valor == 0){
                    throw new DivisaoPorZeroException("Divisão zero por zero é indeterminado.");
                }
            }
            return 0;
        } 
        if(numeros == null) return valorInicial;

        for(double valor: numeros){
            if(valor == 0){
                throw new DivisaoPorZeroException("Não é possível dividir por 0 (zero).");
            }
            valorInicial /= valor;
        }
        return valorInicial;
    }

}