package Forme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CerchioTest {
	
	private Punto origine;
	private Cerchio unitario;
	
	@BeforeEach
	void setUp() {
		origine = new Punto(0,0);
		unitario = new Cerchio(origine, 1);
	}

	
	@Test
	void testTrasla_CasoLimite() {
		unitario.trasla(0,0);
		assertEquals(origine.getX(), unitario.getCentro().getX());
		assertEquals(origine.getY(), unitario.getCentro().getY());
	}
	
	@Test
	void testTrasla() {	//prova di equals del punto
		//p = new Punto(1,0);
		unitario.trasla(1,0);
		assertEquals(new Punto(1, 0), unitario.getCentro());
	}
	
	
	@Test
	void testTrasla_Negativo() {
		unitario.trasla(-10,-4);
		assertEquals(new Punto(-10,-4), unitario.getCentro());
//		assertEquals(p.getX()-10, c.getCentro().getX());
//		assertEquals(p.getY()-4, c.getCentro().getY());
	}
	
	@Test
	void testGetCentro() {
		assertEquals(origine.getX(), unitario.getCentro().getX());
		assertEquals(origine.getY(), unitario.getCentro().getY());
	}
	
	@Test 
	void testGetRaggio() {
		assertEquals(1, unitario.getRaggio());
	}
	
	@Test
	void testEquivalenzaDiCerchi() {
		assertEquals(new Cerchio(origine, 1), this.unitario);
		assertNotEquals(new Cerchio(origine, 2), this.unitario);
		assertNotEquals(new Cerchio(new Punto(1, 1), 1), this.unitario);
		assertNotEquals(new Cerchio(new Punto(1, 1), 2), this.unitario);
	}
	
	@Test
	void testEquivalenzaDiCerchiControRettangoli() {
		Rettangolo r=new Rettangolo(origine, 3, 2);
		assertNotEquals(r, this.unitario);
		assertNotEquals(this.unitario, r);
	}
	
	@Test
	void testEquivalenzaDiCerchiControPunti() {
		assertNotEquals(this.origine, this.unitario);
		assertNotEquals(this.unitario, this.origine);
	}

	@Test
	void testEquivalenzaDiCerchioDegenere() {
		Cerchio cerchioDegenere=new Cerchio(origine, 0);
		assertEquals(cerchioDegenere, origine);
		assertNotEquals(cerchioDegenere, new Punto(1,1));
	}
}
