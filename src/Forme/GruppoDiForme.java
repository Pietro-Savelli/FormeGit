package Forme;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Rappresenta un gruppo di forme geometriche che può contenere altre forme,
 * incluse istanze di GruppoDiForme (che vengono espanse ricorsivamente).
 */
public class GruppoDiForme implements Forma {
	private Set<Forma> gruppo;

	/**
	 * Costruttore che inizializza un gruppo vuoto di forme.
	 */
	public GruppoDiForme() {
		gruppo = new HashSet<>();
	}

	/**
	 * Restituisce l'insieme delle forme contenute nel gruppo.
	 *
	 * @return un Set di forme.
	 */
	public Set<Forma> getForme() {
		return gruppo;
	}

	/**
	 * Trasla tutte le forme contenute nel gruppo di un certo deltaX e deltaY.
	 *
	 * @param deltaX lo spostamento sull'asse X
	 * @param deltaY lo spostamento sull'asse Y
	 */
	@Override
	public void trasla(int deltaX, int deltaY) {
		Iterator<Forma> i = gruppo.iterator();

		while (i.hasNext()) {
			Forma f = i.next();
			f.trasla(deltaX, deltaY);
		}
	}

	/**
	 * Aggiunge una forma al gruppo. Se la forma è un altro GruppoDiForme,
	 * le sue forme vengono aggiunte ricorsivamente. Se è una forma degenere
	 * (come un cerchio o rettangolo con dimensioni nulle), viene eventualmente
	 * sostituita con un punto.
	 *
	 * @param f la forma da aggiungere
	 */
	public void aggiungiForma(Forma f) {

		if (f instanceof GruppoDiForme) {
			GruppoDiForme g = (GruppoDiForme) f;

			for (Forma sotto : g.getForme()) {
				this.aggiungiForma(sotto);
			}
		} 
		
		else if (!f.isDegenere() || (f instanceof Punto)) {
			gruppo.add(f);
			System.out.println("Punto o non degenere");
		} 
		
		else if (f instanceof Cerchio) {
			Cerchio c = (Cerchio) f;
			gruppo.add(c.getCentro()); // aggiungi solo il punto
			System.out.println("cerchio->punto");
		} 
		
		else if (f instanceof Rettangolo) {
			Rettangolo r = (Rettangolo) f;
			gruppo.add(r.getVertice()); // aggiungi solo il punto
			System.out.println("Triangolo->punto");
		}
	}

	/**
	 * Verifica se il gruppo è vuoto.
	 *
	 * @return true se il gruppo è vuoto, false altrimenti
	 */
	public boolean isEmpty() {
		Iterator<Forma> i = gruppo.iterator();
		return !i.hasNext(); // fixato: ritorna true se NON ci sono elementi
	}

	/**
	 * Restituisce false: un gruppo di forme non è considerato degenere.
	 *
	 * @return false
	 */
	@Override
	public boolean isDegenere() {
		return false;
	}

	/**
	 * Restituisce null: un gruppo non ha un punto degenere proprio.
	 *
	 * @return null
	 */
	@Override
	public Punto getPuntoDegenere() {
		return null;
	}

	/**
	 * Restituisce l'hashCode del gruppo, basato sull'insieme delle forme.
	 *
	 * @return hash code calcolato
	 */
	@Override
	public int hashCode() {
		return gruppo.hashCode();
	}

	/**
	 * Verifica l'uguaglianza tra questo gruppo e un altro oggetto.
	 * Due gruppi sono uguali se contengono le stesse forme, indipendentemente dall’ordine.
	 *
	 * @param obj l’oggetto da confrontare
	 * @return true se uguali, false altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || this.getClass() != obj.getClass())
			return false;

		GruppoDiForme that = (GruppoDiForme) obj;
		return gruppo.equals(that.gruppo);
	}
}
