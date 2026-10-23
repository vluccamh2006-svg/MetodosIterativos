public class MetodosIterativos {

    public static void resolverJacobi() {
        double[] x = {0.0, 0.0, 0.0}; // X^(0) inicial
        double[] xNuevo = new double[3];
        int iteracion = 0;
        boolean converge = false;

        System.out.println("--- METODO DE JACOBI ---");
        while (iteracion < SistemaEcuaciones.MAX_ITERACIONES) {
            iteracion++;

            // Fórmulas despejadas para asegurar convergencia o según el orden:
            // x1 = (7 - x2 - x3) / 5
            // x2 = (6 - x1 - x3) / 4 (reordenando fila 3 para mejor pivote) o según matriz original
            // Nota: Despejando de la matriz original:
            xNuevo[0] = (SistemaEcuaciones.b[0] - SistemaEcuaciones.A[0][1]*x[1] - SistemaEcuaciones.A[0][2]*x[2]) / SistemaEcuaciones.A[0][0];
            xNuevo[1] = (SistemaEcuaciones.b[1] - SistemaEcuaciones.A[1][0]*x[0] - SistemaEcuaciones.A[1][2]*x[2]) / SistemaEcuaciones.A[1][1];
            xNuevo[2] = (SistemaEcuaciones.b[2] - SistemaEcuaciones.A[2][0]*x[0] - SistemaEcuaciones.A[2][1]*x[1]) / SistemaEcuaciones.A[2][2];

            // Evaluar tolerancia (norma del error o diferencia máxima)
            double error = Math.max(Math.abs(xNuevo[0] - x[0]),
                    Math.max(Math.abs(xNuevo[1] - x[1]), Math.abs(xNuevo[2] - x[2])));

            System.out.printf("Iteración %d: x1=%.4f, x2=%.4f, x3=%.4f (Error: %.6f)\n",
                    iteracion, xNuevo[0], xNuevo[1], xNuevo[2], error);

            if (error < SistemaEcuaciones.TOLERANCIA) {
                converge = true;
                break;
            }

            // Actualizar vector para siguiente iteración
            System.arraycopy(xNuevo, 0, x, 0, x.length);
        }
        if (converge) {
            System.out.println("Jacobi convergió en " + iteracion + " iteraciones.\n");
        } else {
            System.out.println("Jacobi no convergió en el límite de iteraciones.\n");
        }
    }

    public static void resolverGaussSeidel() {
        double[] x = {0.0, 0.0, 0.0}; // X^(0) inicial
        int iteracion = 0;
        boolean converge = false;

        System.out.println("--- METODO DE GAUSS-SEIDEL ---");
        while (iteracion < SistemaEcuaciones.MAX_ITERACIONES) {
            iteracion++;
            double[] xAnterior = x.clone();

            // Actualización inmediata de variables
            x[0] = (SistemaEcuaciones.b[0] - SistemaEcuaciones.A[0][1]*x[1] - SistemaEcuaciones.A[0][2]*x[2]) / SistemaEcuaciones.A[0][0];
            x[1] = (SistemaEcuaciones.b[1] - SistemaEcuaciones.A[1][0]*x[0] - SistemaEcuaciones.A[1][2]*x[2]) / SistemaEcuaciones.A[1][1];
            x[2] = (SistemaEcuaciones.b[2] - SistemaEcuaciones.A[2][0]*x[0] - SistemaEcuaciones.A[2][1]*x[1]) / SistemaEcuaciones.A[2][2];

            // Evaluar error respecto a la iteración anterior
            double error = Math.max(Math.abs(x[0] - xAnterior[0]),
                    Math.max(Math.abs(x[1] - xAnterior[1]), Math.abs(x[2] - xAnterior[2])));

            System.out.printf("Iteración %d: x1=%.4f, x2=%.4f, x3=%.4f (Error: %.6f)\n",
                    iteracion, x[0], x[1], x[2], error);

            if (error < SistemaEcuaciones.TOLERANCIA) {
                converge = true;
                break;
            }
        }
        if (converge) {
            System.out.println("Gauss-Seidel convergió en " + iteracion + " iteraciones.\n");
        } else {
            System.out.println("Gauss-Seidel no convergió en el límite de iteraciones.\n");
        }
    }
}