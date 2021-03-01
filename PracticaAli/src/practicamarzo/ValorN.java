package practicamarzo;

import java.util.Scanner;

public class ValorN {
	
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
				System.out.print("Introduce el n�mero para saber si es par, impar, primo o no primo: ");
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
	
	/* M�TODO PARA SABER SI UN N�MERO ES PAR O NO*/
	
	// la operaci�n para calcular el resto de un numero,
	// se llama m�dulo de un n�mero, y se expresa con %
	// si un n�mero % n�mero2 == 0 significa que el n�mero es DIVISIBLE entre n�mero2
	// por lo que no hay resto (por eso vale 0)
	
	// el m�dulo de un n�mero entre 2 s�lo puede ser 0 o 1
	// o dicho de otra forma, si el resto de un n�mero entre 2 es 0, ese n�mero es PAR
	// si el resto de un n�mero entre 2 es 1, ese n�mero es IMPAR (sobra 1 n�mero, por eso vale 1)

	// si es par --> devuelve verdadero
	// si es impar --> devuelve falso
	public static boolean esPar(int numero) {
		// si el m�dulo del n�mero entre 2 es 0, es par (num % 2 == 0)
		if(numero % 2 == 0) {
			// devolvemos verdadero, es par
			return true;
		} 
		
		// si el m�dulo del n�mero entre 2 no es 0, llegamos aqu�.
		// si hubiese sido par, el m�todo habr�a acabado en el "return true" de antes,
		// como no ha acabado en el "return true" de antes, significa que el m�dulo
		// del n�mero entre 2 ha sido 1 (num % 2 == 1), por lo tanto el n�mero es IMPAR
		// y devolvemos falso
		return false;
	}
	
	public static boolean esPrimo(int numero) {
        // Si es 1 (o menor, negativo) no es primo
        if (numero <= 1) 
            return false; 
  
        // Vamos a calcular el m�dulo de TODOS los n�meros que hay
        // hasta el n�mero que queremos saber si es primo o no,
        // si alg�n m�dulo == 0, significa que ese n�mero actual es divisible
        // entre el n�mero que queremos saber si es primo o no
        // y por lo tanto NO es un n�mero primo,
        // ya que un n�mero primo s�lo es divisible por s� mismo
        // y por el 1, por eso empezamos en 2
        
        for (int i = 2; i < numero; i++) 
        	
        	// si este n�mero fuese divisible por alg�n numero
        	// entre 2 y el n�mero, el n�mero NO es un n�mero primo
            if (numero % i == 0) 
            	// como el m�dulo es 0, el n�mero es divisible entre "i", y no es primo
            	// devolvemos falso
                return false; 
        
        // si hemos llegado hasta aqu�, significa que no se ha entrado en el if
        // anterior y no se ha acabado la ejecuci�n en el "return false"
        // por lo que devolvemos que s�, es primo (true)
        return true; 
	}
	
	public static void main(String[] args) {
		// pedimos el n�mero
		int numero = pedirNumero();
		
		// comprobamos si es par o no
		//si es par entonces == true
		if(esPar(numero) == true) {
			 //syso print (no println) para que no haya salto de l�nea
			// y podamos continuar diciendo si es primo o no despu�s
			 System.out.print("El n�mero " + numero + " es par y");
		//si no == true asumimos que es impar
		} else {
			 //syso print (no println) para que no haya salto de l�nea
			// y podamos continuar diciendo si es primo o no despu�
			 System.out.print("El n�mero " + numero + " es impar y");
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
