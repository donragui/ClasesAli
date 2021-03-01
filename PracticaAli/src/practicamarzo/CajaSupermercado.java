package practicamarzo;

import java.util.Scanner;

public class CajaSupermercado {

	/*
	 * M�TODO PARA PEDIR N�MERO POR PANTALLA PARA ESTE EJERCICIO, VAMOS A USAR UN
	 * N�MERO DOUBLE YA QUE UN PRECIO PUEDE SER DE 23,33; 23,00, ... PUEDE TENER
	 * COMAS
	 */
	public static double pedirNumeroDouble() {
		// variable para comprobar que estamos introduciendo un n�mero
		boolean isNum = false;
		// n�mero a devolver
		double numeroDevuelto = 0;

		// mientras que isNum == false (no es n�mero lo que introduces por pantalla)
		do {
			// intentamos pedir un n�mero por pantalla
			try {
				// inicializamos el Scanner
				Scanner sc = new Scanner(System.in);
				// pedimos por pantalla un n�mero
				System.out.print("Introduce el precio del producto para calcular el subtotal, IVA y total de compra: ");
				// para introducir el n�mero
				numeroDevuelto = sc.nextDouble();
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

	/* M�TODO PARA CALCULAR EL IVA DEL PRECIO */
	public static double calcularIVA(double precioSinIVA, double IVA) {
		// devolvemos el precio sin IVA * el IVA en % (por eso se divide entre 100)
		// esto nos da el IVA en euros
		return precioSinIVA * (IVA / 100);
	}

	/* M�TODO PARA CALCULAR EL TOTAL DEL PRODUCTO */
	public static double calcularTotal(double precioSinIVA, double IVA) {
		// devolvemos el precio sin IVA + el IVA en euros calculado con el m�todo
		// calcularIVA
		return precioSinIVA + calcularIVA(precioSinIVA, IVA);
	}

	public static void main(String[] args) {
		// pedir precio sin IVA, o tambi�n llamado el subtotal
		double precioSinIVA = pedirNumeroDouble();

		// asumimos que el IVA es del 21%, podr�amos pedirlo por pantalla como el
		// precio sin IVA, pero no es necesario, por eso lo establecemos en 21
		double porcentajeIVA = 21;

		// calcular el IVA en euros
		double eurosIVA = calcularIVA(precioSinIVA, porcentajeIVA);

		// calcular precio con IVA
		double precioConIVA = calcularTotal(precioSinIVA, porcentajeIVA);

		System.out.println("El subtotal sin IVA es de " + precioSinIVA + "�");
		System.out.println("El IVA es de " + eurosIVA + "� (" + porcentajeIVA + "%)");
		System.out.println("El total es de " + precioConIVA + "�");

	}

}
