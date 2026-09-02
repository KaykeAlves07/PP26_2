public class Adapter extends Calculadora_202321250008 implements Alvo {

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
        for(double valor: numeros){
            return dividir(valorInicial, valor);
        }
        return 0;
    }
}
