package practicamarzo;

import java.util.Random;
import java.util.Scanner;

public class JuegoDados {

	/* DECLARACIÓN DE ATRIBUTOS NECESARIOS */
	private int puntosOrdenador;
	private int puntosHumano;

	private String turno;
	private String tirada;

	private int dado1;
	private int dado2;
	private int dado3;

	private int premio;

	/*
	 * CONSTRUCTOR, TODO A 0 Y EL TURNO DEL HUMANO
	 */
	public JuegoDados() {
		this.puntosOrdenador = 0;
		this.puntosHumano = 0;
		this.turno = "HUMANO";
		this.tirada = "";
		this.dado1 = 0;
		this.dado2 = 0;
		this.dado3 = 0;
	}

	/* MÉTODO PARA DECIR DE QUIÉN ES EL TURNO */
	public void turnoDeQuien() {
		// Si es el turno del humano
		if (this.turno == "HUMANO") {
			System.out.print(
					"Es tu turno. Pulsa Enter para tirar los dados o 'Q' (sin las comillas y en mayúscula) para terminar: ");
			// Si no es el turno del humano es del ordenador
		} else {
			System.out.println("Es mi turno.");
		}
	}

	/* MÉTODO PARA CAMBIAR EL TURNO */
	public void cambiarTurno() {
		// Si es el turno del humano
		if (this.turno == "HUMANO") {
			// Cambiamos de turno al ordenador
			this.turno = "ORDENADOR";
			// Si no es el turno del humano es del ordenador
		} else {
			// Cambiamos de turno al humano
			this.turno = "HUMANO";
		}
	}

	/* MÉTODO PARA TIRAR LOS DADOS Y OBTENER UN NÚMERO ALEATORIO */
	public void tirarDados() {
		// Crear objeto Random
		Random rand = new Random();
		// Max y min de los dados
		int max = 6;
		int min = 1;
		/*
		 * CALCULA EL VALOR DE FORMA ALEATORIA DE LOS 3 DADOS
		 * 
		 * https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
		 * segunda respuesta
		 * 
		 */
		this.dado1 = rand.nextInt((max - min) + 1) + min;
		this.dado2 = rand.nextInt((max - min) + 1) + min;
		this.dado3 = rand.nextInt((max - min) + 1) + min;
		// Imprimir la tirada
		System.out.println("La tirada ha sido: " + this.dado1 + ", " + this.dado2 + ", " + this.dado3);
	}

	/*
	 * MÉTODO PARA COMPROBAR LOS DADOS, ASIGNA EL PREMIO DEPENDIENDO DE LA TIRADA
	 * AÑADIMOS THROWS EXCEPTION YA QUE VAMOS A LANZAR UNA EXCEPCIÓN SI LOS TRES
	 * DADOS SON IGUALES CON ESTA EXCEPCIÓN PODEMOS VOLVER A TIRAR
	 */
	// Traducción del pseudocódigo del ejercicio
	public void comprobarDados() throws Exception {
		// Imprimir mensaje que dice que estamos tirando los dados
		System.out.println("Tirando los dados...");
		// Si todos los dados son iguales el premio es 10
		if (this.dado1 == this.dado2 || this.dado1 == this.dado3) {
			this.premio += 10;
		}
		// Si todos los dados son iguales, además del premio 10, se reinicia el juego
		// lanzando una excepción
		if (this.dado1 == this.dado2 && this.dado2 == this.dado3) {
			System.out.println("Todos los dados son iguales... Volviendo a tirar...");
			throw new Exception();
		}

		// Si el primer dado vale 6, +50 puntos, si vale otra cosa, +20puntos
		if (this.dado1 == 6) {
			this.premio += 50;
		} else {
			this.premio += 20;
		}
		System.out.println("Premio de la tirada: " + this.premio);
	}

	/* MÉTODO PARA SUMAR EL PREMIO, DEPENDIENDO DE QUIÉN SEA EL TURNO */
	public void sumarPremio() {
		// Si es el turno del humano
		if (this.turno == "HUMANO") {
			this.puntosHumano += this.premio;
			// Una vez sumado el premio, establecemos de nuevo el premio en 0 para el
			// siguiente jugador
			this.premio = 0;
			// Si no es el turno del humano es del ordenador
		} else {
			this.puntosOrdenador += this.premio;
			// Una vez sumado el premio, establecemos de nuevo el premio en 0 para el
			// siguiente jugador
			this.premio = 0;
		}
	}

	/* MÉTODO PARA ESCRIBIR QUIÉN HA GANADO */
	public void escribirResultado() {
		// Muestra las puntuaciones de ambos
		System.out.println("Tu puntuación final: " + this.puntosHumano);
		System.out.println("Mi puntuación final: " + this.puntosOrdenador);

		// Si los puntos del humano son mayores que los puntos del ordenador
		if (this.puntosHumano > this.puntosOrdenador) {
			System.out.println("¡Has ganado, enhorabuena!");
			// Si los puntos del ordenador son mayores que los puntos del humano
		} else if (this.puntosHumano < this.puntosOrdenador) {
			System.out.println("Te he ganado. Inténtalo de nuevo en otra ocasión.");
			// Si los puntos de ambos son iguales
		} else {
			System.out.println("Hemos empatado. Intenta ganarme otro día.");
		}
	}

	/* MÉTODO PARA JUGAR UNA PARTIDA */
	public void Partida() {
		Scanner sc = new Scanner(System.in);

		inicio:

		do {
			// Imprimir de quién es el turno
			this.turnoDeQuien();

			// Si es el turno del humano hay entrada de consola, por lo tanto hay tirada
			if (this.turno == "HUMANO") {
				this.tirada = sc.nextLine();
			}

			// Si la tirada vale Q, se acaba el juego
			if (this.tirada.equals("Q")) {
				break;
			}

			// Intentamos comprobar la tirada
			try {
				// Tiramos los dados
				this.tirarDados();
				// Comprobamos la tirada
				this.comprobarDados();
				// Si salen todos los dados iguales cogemos la excepción
			} catch (Exception e) {
				// En la excepción, como todos los dados son iguales, salimos del bucle y
				// reiniciamos el juego
				// Para entender por qué volvemos al inicio (declarado arriba)
				// https://www.geeksforgeeks.org/g-fact-64/
				break inicio;
			}

			// sumamos el premio del jugador actual
			this.sumarPremio();

			// y cambiamos de turno
			this.cambiarTurno();
			System.out.println();
		} while (!this.tirada.equals("Q")); // Mientras la entrada no sea Q se juega
		// Para entender el equals, primera respuesta
		// https://stackoverflow.com/questions/12764485/exiting-a-do-while-loop-using-a-string

		// Una vez que hemos acabado la partida imprimimos el resultado
		this.escribirResultado();
	}

	/* MAIN */
	public static void main(String[] args) {
		// Nuevo objeto de tipo JuegoDados
		JuegoDados jd = new JuegoDados();
		// Llamamos al método de Partida para iniciar la partida
		jd.Partida();
	}
}
