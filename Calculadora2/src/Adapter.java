public class Adapter extends Calculadora_202321250008 implements Alvo {

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
        return somar(numeros);
    }
    public double sub(double valorInicial, double ... numeros){
        if(numeros == null) return valorInicial;
        for(double valor: numeros){
            return subtrair(valorInicial, valor);
        }
        return valorInicial;
    }
    public double mult(double ... numeros){
        if(numeros == null) return 1;
        return multiplicar(numeros);
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
            return dividir(valorInicial, valor);
        }
        return 0;
    }
}
