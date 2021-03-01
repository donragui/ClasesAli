package practicamarzo;

import java.util.Scanner;

public class TresValores {

	/* MÉTODO PARA SABER EL MAYOR, MEDIANO Y PEQUEÑO DE TRES NÚMEROS */
	public static void cualEsMayor(int num1, int num2, int num3) {

		// num1 mayor
		if (num1 > num2 && num1 > num3) {
			System.out.println("El número 1 es el mayor");
			// num2 mediano y num3 pequeño
			if (num2 > num3) {
				System.out.println("El número 2 es el mediano");
				System.out.println("El número 3 es el pequeño");
				// num3 mediano y num2 pequeño
			} else if (num3 > num2) {
				System.out.println("El número 3 es el mediano");
				System.out.println("El número 2 es el pequeño");
				// num2 y num3 iguales
			} else if (num2 == num3) {
				System.out.println("Los números 2 y 3 son iguales");
			}
			// num 2 mayor
		} else if (num2 > num1 && num2 > num3) {
			System.out.println("El número 2 es el mayor");
			// num1 mediano y num3 pequeño
			if (num1 > num3) {
				System.out.println("El número 1 es el mediano");
				System.out.println("El número 3 es el pequeño");
				// num3 mediano y num1 pequeño
			} else if (num3 > num1) {
				System.out.println("El número 3 es el mediano");
				System.out.println("El número 1 es el pequeño");
				// num1 y num3 iguales
			} else if (num1 == num3) {
				System.out.println("Los números 1 y 3 son iguales");
			}
			// num3 mayor
		} else if (num3 > num1 && num3 > num2) {
			System.out.println("El número 3 es el mayor");
			// num1 mediano y num2 pequeño
			if (num1 > num2) {
				System.out.println("El número 1 es el mediano");
				System.out.println("El número 2 es el pequeño");
				// num2 mediano y num1 pequeño
			} else if (num2 > num1) {
				System.out.println("El número 2 es el mediano");
				System.out.println("El número 1 es el pequeño");
				// num1 y num2 iguales
			} else if (num1 == num2) {
				System.out.println("Los números 1 y 2 son iguales");
			}
			// los tres iguales
		} else {
			System.out.println("Los 3 números son iguales");
		}
	}

	/*
	 * MÉTODO PARA PEDIR NÚMERO POR PANTALLA, PARÁMETRO NÚMERO, INDICA EL NÚMERO QUE
	 * ESTÁ PIDIENDO
	 */
	public static int pedirNumero(int numero) {
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
				System.out.print("Introduce el número " + numero + ": ");
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

	public static void main(String[] args) {
		// pedimos por pantalla los 3 números con el método pedirNumero
		int numero1 = pedirNumero(1);
		int numero2 = pedirNumero(2);
		int numero3 = pedirNumero(3);

		// calculamos cuál es mayor, mediano y menor a partir del método cualEsMayor
		cualEsMayor(numero1, numero2, numero3);

	}
}
