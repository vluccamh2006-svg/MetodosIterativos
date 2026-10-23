public class SistemaEcuaciones {
    // Sistema reordenado para asegurar dominancia diagonal y convergencia:
    // Fila 1: 5x +  y +  z = 7
    // Fila 2:  x + 4y +  z = 6  (intercambiada con la 3 para tener el 4 en diagonal)
    // Fila 3:  x + 2y + 5z = 8  (intercambiada con la 2 para tener el 5 en diagonal)

    public static final double[][] A = {
            {5.0, 1.0, 1.0},
            {1.0, 4.0, 1.0},
            {1.0, 2.0, 5.0}
    };

    public static final double[] b = {7.0, 6.0, 8.0};

    public static final double TOLERANCIA = 0.0001;
    public static final int MAX_ITERACIONES = 100;
}