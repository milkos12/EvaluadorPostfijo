/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();

        // TODO: Realiza la evaluación de la expresión en formato postfijo
        for (String element: expresion) {
            System.out.println(pila);
            try {
                // agregar el número a la pila
                pila.push(Integer.parseInt(element));

            } catch (NumberFormatException e) {
                int total = 0;

                int sizePila = pila.size();
                int numUno =  pila.get(sizePila - 1);
                pila.remove(sizePila -1);
                sizePila = pila.size();
                int numDos = pila.get(sizePila - 1);
                pila.remove(sizePila - 1);

                switch (element) {
                    case "+":
                        //sumamos los números de la pila
                        total =  numDos + numUno;
                        pila.push(total);
                        total = 0;

                        break;
                    case "-":
                        //restamos  los números de la pila
                        total = numDos - numUno ;
                        pila.push(total);
                        total = 0;

                        break;
                    case "*":
                        //multiplicamos  los números de la pila
                        total = numDos * numUno;
                        pila.push(total);
                        total = 0;
                        break;
                    case "/":
                        //divimos los números de la pila
                        total = numDos / numUno;
                        pila.push(total);
                        total = 0;
                        break;
                }

            }
        }

        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
