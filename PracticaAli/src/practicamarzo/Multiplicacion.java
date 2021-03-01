package practicamarzo;

import java.util.Scanner;

public class Multiplicacion {

	/*
	 * M�TODO PARA PEDIR N�MERO POR PANTALLA
	 */
	public static int pedirNumero() {
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
				System.out.print("Introduce el n�mero para saber su tabla de multiplicar: ");
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

	/*
	 * M�TODO QUE IMPRIME LA TABLA DE MULTIPLICAR DEL N�MERO QUE SE LE PASA POR
	 * PAR�METRO
	 */
	public static void Tabla(int numero) {
		System.out.println("\nLa tabla de multiplicar del " + numero + " es: ");
		for (int i = 0; i <= 10; i++) {
			System.out.println(numero + "x" + i + " = " + numero * i);
		}
	}

	public static void main(String[] args) {
		// pedimos un n�mero por pantalla
		int numero = pedirNumero();
		// lo multiplicamos
		Tabla(numero);
	}

}
