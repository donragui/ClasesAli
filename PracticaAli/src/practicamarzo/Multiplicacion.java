package practicamarzo;

import java.util.Scanner;

public class Multiplicacion {

	/*
	 * MÉTODO PARA PEDIR NÚMERO POR PANTALLA
	 */
	public static int pedirNumero() {
		// variable para comprobar que estamos introduciendo un número
		boolean isNum = false;
		// número a devolver
		int numeroDevuelto = 0;

		// mientras que isNum == false (no es número lo que introduces por pantalla)
		do {
			// intentamos pedir un número por pantalla
			try {
				// inicializamos el Scanner
				Scanner sc = new Scanner(System.in);
				// pedimos por pantalla un número
				System.out.print("Introduce el número para saber su tabla de multiplicar: ");
				// para introducir el número
				numeroDevuelto = sc.nextInt();
				// si el número es válido, no ha habido excepción y llegamos aquí
				// isNum ahora es true y el bucle do-while se corta
				isNum = true;

				// si no se introduce un número, se alcanza esta excepción
			} catch (Exception e) {
				System.out.println("No has introducido un número, estamos en la excepción");
			}

		} while (isNum == false);

		// devolvemos el número introducido
		return numeroDevuelto;
	}

	/*
	 * MÉTODO QUE IMPRIME LA TABLA DE MULTIPLICAR DEL NÚMERO QUE SE LE PASA POR
	 * PARÁMETRO
	 */
	public static void Tabla(int numero) {
		System.out.println("\nLa tabla de multiplicar del " + numero + " es: ");
		for (int i = 0; i <= 10; i++) {
			System.out.println(numero + "x" + i + " = " + numero * i);
		}
	}

	public static void main(String[] args) {
		// pedimos un número por pantalla
		int numero = pedirNumero();
		// lo multiplicamos
		Tabla(numero);
	}

}
