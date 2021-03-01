package practicamarzo;

import java.util.Scanner;

public class TresValores {

	/* M�TODO PARA SABER EL MAYOR, MEDIANO Y PEQUE�O DE TRES N�MEROS */
	public static void cualEsMayor(int num1, int num2, int num3) {

		// num1 mayor
		if (num1 > num2 && num1 > num3) {
			System.out.println("El n�mero 1 es el mayor");
			// num2 mediano y num3 peque�o
			if (num2 > num3) {
				System.out.println("El n�mero 2 es el mediano");
				System.out.println("El n�mero 3 es el peque�o");
				// num3 mediano y num2 peque�o
			} else if (num3 > num2) {
				System.out.println("El n�mero 3 es el mediano");
				System.out.println("El n�mero 2 es el peque�o");
				// num2 y num3 iguales
			} else if (num2 == num3) {
				System.out.println("Los n�meros 2 y 3 son iguales");
			}
			// num 2 mayor
		} else if (num2 > num1 && num2 > num3) {
			System.out.println("El n�mero 2 es el mayor");
			// num1 mediano y num3 peque�o
			if (num1 > num3) {
				System.out.println("El n�mero 1 es el mediano");
				System.out.println("El n�mero 3 es el peque�o");
				// num3 mediano y num1 peque�o
			} else if (num3 > num1) {
				System.out.println("El n�mero 3 es el mediano");
				System.out.println("El n�mero 1 es el peque�o");
				// num1 y num3 iguales
			} else if (num1 == num3) {
				System.out.println("Los n�meros 1 y 3 son iguales");
			}
			// num3 mayor
		} else if (num3 > num1 && num3 > num2) {
			System.out.println("El n�mero 3 es el mayor");
			// num1 mediano y num2 peque�o
			if (num1 > num2) {
				System.out.println("El n�mero 1 es el mediano");
				System.out.println("El n�mero 2 es el peque�o");
				// num2 mediano y num1 peque�o
			} else if (num2 > num1) {
				System.out.println("El n�mero 2 es el mediano");
				System.out.println("El n�mero 1 es el peque�o");
				// num1 y num2 iguales
			} else if (num1 == num2) {
				System.out.println("Los n�meros 1 y 2 son iguales");
			}
			// los tres iguales
		} else {
			System.out.println("Los 3 n�meros son iguales");
		}
	}

	/*
	 * M�TODO PARA PEDIR N�MERO POR PANTALLA, PAR�METRO N�MERO, INDICA EL N�MERO QUE
	 * EST� PIDIENDO
	 */
	public static int pedirNumero(int numero) {
		// variable para comprobar que estamos introduciendo un n�mero
		boolean isNum = false;
		// n�mero a devolver
		int numeroDevuelto = 0;

		// mientras que isNum == false (no es n�mero lo que introduces por pantalla)
		do {
			// intentamos pedir un n�mero por pantalla
			try {
				// inicializamos el Scanner
				Scanner sc = new Scanner(System.in);
				// pedimos por pantalla un n�mero
				System.out.print("Introduce el n�mero " + numero + ": ");
				// para introducir el n�mero
				numeroDevuelto = sc.nextInt();
				// si el n�mero es v�lido, no ha habido excepci�n y llegamos aqu�
				// isNum ahora es true y el bucle do-while se corta
				isNum = true;

				// si no se introduce un n�mero, se alcanza esta excepci�n
			} catch (Exception e) {
				System.out.println("No has introducido un n�mero, estamos en la excepci�n");
			}

		} while (isNum == false);

		// devolvemos el n�mero introducido
		return numeroDevuelto;
	}

	public static void main(String[] args) {
		// pedimos por pantalla los 3 n�meros con el m�todo pedirNumero
		int numero1 = pedirNumero(1);
		int numero2 = pedirNumero(2);
		int numero3 = pedirNumero(3);

		// calculamos cu�l es mayor, mediano y menor a partir del m�todo cualEsMayor
		cualEsMayor(numero1, numero2, numero3);

	}
}
