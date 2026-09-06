public class Cliente_202421250032 {
    public static void main(String[] args) throws Exception {
        Alvo calc = new Adapter();

        // Testando NULL
        calc.sub(0, null);

        System.out.println("=== Operações Simples ===");

        double soma = calc.soma(1, 8, 90.8, 8.7);
        System.out.printf("Soma: %.3f\n", soma);

        
        double subtracao = calc.sub(80, 8, 9.5, 7);
        System.out.printf("Subtração: %.3f\n", subtracao);

       
        double mul = calc.mult(7, 8, 0.5, 90);
        System.out.printf("Multiplicação: %.3f\n", mul);

        
        double div = calc.divisao(10, 2);
        System.out.printf("Divisão: %.3f\n", div);
        // Divisão com numerador igual a zero
        System.out.println("Numerador 0: "+ calc.divisao(0, 1, 5, 7, 9));
        
        System.out.println("=== Operações encadeadas ===");

        // O resultado da divisão alimenta a multplicação, que por sua vez
        // alimenta a subtração, cujo resultado alimenta a soma.
        double encadeado = calc.soma(2, 8, 
            calc.sub(
                calc.mult(2, 5, 
                    calc.divisao(8,4, 9)),
            5));
            
        System.out.printf("Resultado encadeado: %.3f\n", encadeado);

        System.out.println("=== Divisão por zero ===");
        
        // Divisão por zero simples
        try {
            double resultado = calc.divisao(10, 0);
            System.out.printf("Divisão: %.3f\n", resultado);
        } catch (Adapter.DivisaoPorZeroException e){
            System.out.println("Erro: " + e.getMessage());
        }

        // Divisão por zero dentro de uma expressão encadeada
        try {
            double res = calc.mult(8, 9, 
                calc.divisao(10, 0));

            System.out.printf("Divisão: %.3f\n", res);
        } catch (Adapter.DivisaoPorZeroException e){
            System.out.println("Erro (encadeada): " + e.getMessage());
        }

        // Divisão zero por zero simples
        try {
            double resultado = calc.divisao(0, 0);
            System.out.printf("Divisão: %.3f\n", resultado);
        } catch (Adapter.DivisaoPorZeroException e){
            System.out.println("Erro: " + e.getMessage());
        }


        System.out.println("=== Programa continua ===");


        // System.out.println("Codigo vai parar sem tratamento: ");
        // System.out.println(calc.divisao(0, 0));
        
    }
}
