# Práctica: Métodos Iterativos (Jacobi y Gauss-Seidel)

## Información General
* **Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)
* **Carrera:** Ingeniería en Sistemas Computacionales
* **Materia:** Métodos Numéricos (SCC-1017)
* **Docente:** M.I. Víctor Hugo Vásquez Herrera
* **Alumno:** Vann Lucca Mata Hernández
* **Fecha:** Octubre 2026

---

## Descripción del Proyecto
Este proyecto implementa en Java la solución de sistemas de ecuaciones lineales mediante los métodos iterativos de **Jacobi** y **Gauss-Seidel**. El diseño sigue una **arquitectura modular de tres componentes** para garantizar una clara separación de responsabilidades:

1. **`SistemaEcuaciones.java` (Módulo 1):** Almacena la matriz de coeficientes $A$, el vector de términos independientes $b$, la aproximación inicial $X^{(0)} = [0, 0, 0]^T$ y la tolerancia de error ($\epsilon = 0.0001$).
2. **`MetodosIterativos.java` (Módulo 2):** Contiene la lógica matemática para la resolución iterativa.
    * *Jacobi:* Emplea un vector auxiliar para almacenar los valores de la iteración actual.
    * *Gauss-Seidel:* Aplica la actualización inmediata de variables dentro de la misma iteración.
3. **`Lanzador_Iterativos.java` (Módulo 3):** Clase principal (`Main`) encargada de la ejecución secuencial de ambos métodos y la presentación formateada del proceso de convergencia.

---

## Requisitos de Entorno y Compilación
* **JDK:** Java Development Kit 21 o superior.
* **IDE:** IntelliJ IDEA (o cualquier entorno compatible con proyectos Java estándar).

### Instrucciones de Ejecución
1. Clonar o descargar este repositorio.
2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Ejecutar la clase principal `Lanzador_Iterativos.java`.

---

## Resultados y Comparación de Convergencia
Para el sistema evaluado bajo una tolerancia $\epsilon = 0.0001$:
* **Método de Jacobi:** Requiriendo **16 iteraciones** para alcanzar la convergencia.
* **Método de Gauss-Seidel:** Requiriendo **6 iteraciones** para alcanzar la convergencia.

**Conclusión:** Gauss-Seidel demuestra una mayor velocidad de convergencia al utilizar los valores recién calculados de forma inmediata en las sustituciones del mismo ciclo.