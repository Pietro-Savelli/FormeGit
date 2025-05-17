package Forme;

public class Puntino extends Punto{

	private int somma;
	private String D;
	//private char 

	public Puntino(int x, int y, String dde) {
		super(x, y);
		D = dde;
		this.somma = 0;
	}

	public int getSomma() {
		return somma;
	}

	public void setSomma(int somma) {
		this.somma = somma;
	}
}