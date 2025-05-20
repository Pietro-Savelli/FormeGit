package Forme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GruppoDiFormeTest {
	Punto p1 = new Punto(1, 1);
    Punto p2 = new Punto(5, 5);
    Punto centro = new Punto(3, 3);

    Rettangolo rett = new Rettangolo(p1, 4, 7);
    Cerchio cerchio = new Cerchio(centro, 2);
    Punto singolo = new Punto(0, 0);

    GruppoDiForme gruppo;
    GruppoDiForme gruppo2;
	
	@BeforeEach
	void setUp() {
		gruppo = new GruppoDiForme();
		gruppo.aggiungiForma(p1);
		gruppo.aggiungiForma(p2);
		gruppo.aggiungiForma(centro);
		gruppo.aggiungiForma(rett);
		gruppo.aggiungiForma(cerchio);
		gruppo.aggiungiForma(singolo);
		gruppo2 = new GruppoDiForme();
		gruppo2.aggiungiForma(new Punto(0, 1));
	}
	
	@Test
	void testEquals() {
		assertEquals(gruppo, gruppo);
	}
	
	@Test
	void testEquals2() {
		assertNotEquals(gruppo2, gruppo);
	}
	
	@Test
	void testEqualsDiversi() {
		assertNotEquals(p1, gruppo);
		assertNotEquals(gruppo, p2);
		assertNotEquals(p1, rett);
	}
	@Test
	void testEqualsUgualiOrdineDiverso() {
		GruppoDiForme g1 = new GruppoDiForme();
		GruppoDiForme g2 = new GruppoDiForme();
		g1.aggiungiForma(p1);
		g1.aggiungiForma(p2);
		g2.aggiungiForma(p2);
		g2.aggiungiForma(p1);
		assertEquals(g1, g2);
	}
	
	@Test
	void testEqualsDegenerePuntoCerchio() {
		GruppoDiForme g1 = new GruppoDiForme();
		GruppoDiForme g2 = new GruppoDiForme();
		g1.aggiungiForma(new Cerchio(singolo, 0));
		g1.aggiungiForma(new Rettangolo(p1, 0, 0));
		g1.aggiungiForma(p2);
		g2.aggiungiForma(p2);
		g2.aggiungiForma(singolo);
		g2.aggiungiForma(p1);
		assertEquals(g1, g2);
	}
	
	@Test
	void testAggiungForma() {
		GruppoDiForme g1 = new GruppoDiForme();
		GruppoDiForme g2 = new GruppoDiForme();
		g1.aggiungiForma(new Cerchio(singolo, 0));
		g1.aggiungiForma(p2);
		g2.aggiungiForma(g1);
		g2.aggiungiForma(singolo);// non verra inserrito perche esiete gia il cerchio degenere in posizione (0,0)
		assertEquals(g1, g2);
		g2.aggiungiForma(p1);
		assertNotEquals(g1, g2);
	}
}

