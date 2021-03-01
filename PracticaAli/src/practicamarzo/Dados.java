package practicamarzo;

import java.util.Random;

public class Dados {
	
	private int puntosOrdenador;
	private int puntosHumano;
	
	private String turno;
	private String tirada;
	
	private int dado1;
	private int dado2;
	private int dado3;
	
	private int premio;
	
	public Dados() {
		this.puntosOrdenador = 0;
		this.puntosHumano = 0;
		this.turno = "HUMANO";
		this.tirada = "";
		this.dado1 = 0;
		this.dado2 = 0;
		this.dado3 = 0;
	}
	

	public int getPuntosOrdenador() {
		return puntosOrdenador;
	}

	public void setPuntosOrdenador(int puntosOrdenador) {
		this.puntosOrdenador = puntosOrdenador;
	}

	public int getPuntosHumano() {
		return puntosHumano;
	}

	public void setPuntosHumano(int puntosHumano) {
		this.puntosHumano = puntosHumano;
	}

	public String getTurno() {
		return this.turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getTirada() {
		return tirada;
	}

	public void setTirada(String tirada) {
		this.tirada = tirada;
	}

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

	public int getDado3() {
		return dado3;
	}

	public void setDado3(int dado3) {
		this.dado3 = dado3;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}
	
	public void tirarDados() {
		Random rand = new Random();
		int max = 6;
		int min = 1;
		
		this.dado1 = rand.nextInt((max-min) + 1) + min;
		this.dado2 = rand.nextInt((max-min) + 1) + min;
		this.dado3 = rand.nextInt((max-min) + 1) + min;
	}
	
	public void comprobarDados() throws Exception {
		if(this.dado1 == this.dado2 && this.dado2 == this.dado3) throw new Exception();

		this.premio = 0;

		if(this.dado1 == this.dado2 || this.dado1 == this.dado3) this.premio += 10;
		
		if(this.dado1 == 6) {
			this.premio += 50;
		} else {
			this.premio +=20;
		}
	}
	
	public void sumarPremio() {
		if(this.turno=="HUMANO") {
			this.puntosHumano += this.premio;
		} else {
			this.puntosOrdenador += this.premio;
		}
	}
	
	public static void main(String[] args) {
		
	}



}
