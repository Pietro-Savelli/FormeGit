package Forme;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GruppoDiForme gruppo = new GruppoDiForme();
		Forma f1 = new Rettangolo(new Punto(1,1), 5, 5);
		Forma f2 = new Rettangolo(new Punto(1,1), 10, 5);
		Forma f3 = new Rettangolo(new Punto(1,1), 5, 10);
		
		f1.trasla(1, 1);
		
		gruppo.aggiungiForma(f1);
		gruppo.aggiungiForma(f2);
		gruppo.aggiungiForma(f3);
		
		gruppo.trasla(2, 2);
		
		
	}

}
