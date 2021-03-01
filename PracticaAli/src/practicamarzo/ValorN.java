package practicamarzo;

import java.util.Scanner;

public class ValorN {
	
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
				System.out.print("Introduce el número para saber si es par, impar, primo o no primo: ");
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
	
	/* MÉTODO PARA SABER SI UN NÜMERO ES PAR O NO*/
	
	// la operación para calcular el resto de un numero,
	// se llama módulo de un número, y se expresa con %
	// si un número % número2 == 0 significa que el número es DIVISIBLE entre número2
	// por lo que no hay resto (por eso vale 0)
	
	// el módulo de un número entre 2 sólo puede ser 0 o 1
	// o dicho de otra forma, si el resto de un número entre 2 es 0, ese número es PAR
	// si el resto de un número entre 2 es 1, ese número es IMPAR (sobra 1 número, por eso vale 1)

	// si es par --> devuelve verdadero
	// si es impar --> devuelve falso
	public static boolean esPar(int numero) {
		// si el módulo del número entre 2 es 0, es par (num % 2 == 0)
		if(numero % 2 == 0) {
			// devolvemos verdadero, es par
			return true;
		} 
		
		// si el módulo del número entre 2 no es 0, llegamos aquí.
		// si hubiese sido par, el método habría acabado en el "return true" de antes,
		// como no ha acabado en el "return true" de antes, significa que el módulo
		// del número entre 2 ha sido 1 (num % 2 == 1), por lo tanto el número es IMPAR
		// y devolvemos falso
		return false;
	}
	
	public static boolean esPrimo(int numero) {
        // Si es 1 (o menor, negativo) no es primo
        if (numero <= 1) 
            return false; 
  
        // Vamos a calcular el módulo de TODOS los números que hay
        // hasta el número que queremos saber si es primo o no,
        // si algún módulo == 0, significa que ese número actual es divisible
        // entre el número que queremos saber si es primo o no
        // y por lo tanto NO es un número primo,
        // ya que un número primo sólo es divisible por sí mismo
        // y por el 1, por eso empezamos en 2
        
        for (int i = 2; i < numero; i++) 
        	
        	// si este número fuese divisible por algún numero
        	// entre 2 y el número, el número NO es un número primo
            if (numero % i == 0) 
            	// como el módulo es 0, el número es divisible entre "i", y no es primo
            	// devolvemos falso
                return false; 
        
        // si hemos llegado hasta aquí, significa que no se ha entrado en el if
        // anterior y no se ha acabado la ejecución en el "return false"
        // por lo que devolvemos que sí, es primo (true)
        return true; 
	}
	
	public static void main(String[] args) {
		// pedimos el número
		int numero = pedirNumero();
		
		// comprobamos si es par o no
		//si es par entonces == true
		if(esPar(numero) == true) {
			 //syso print (no println) para que no haya salto de línea
			// y podamos continuar diciendo si es primo o no después
			 System.out.print("El número " + numero + " es par y");
		//si no == true asumimos que es impar
		} else {
			 //syso print (no println) para que no haya salto de línea
			// y podamos continuar diciendo si es primo o no despué
			 System.out.print("El número " + numero + " es impar y");
		}
		
		//comprobamos si es primo o no
		//si es primo entonces == true
		if(esPrimo(numero) == true) {
			System.out.print(" es primo.");
		//si no == true asumimos que no es primo
		} else {
			System.out.print(" no es primo.");
		}
	}
}
