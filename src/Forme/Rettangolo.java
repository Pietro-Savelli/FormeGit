package Forme;

public class Rettangolo implements Forma{
	private int altezza, base;
	private Punto vertice;

	public Rettangolo(Punto vertice, int altezza, int base) {
		this.altezza = altezza;
		this.base = base;
		this.vertice = new Punto(vertice.getX(), vertice.getY());
	}

	public Punto getVertice() { return this.vertice; }

	public int getBase() { return this.base;}

	public int getAltezza()   { return this.altezza; }

	@Override
	public void trasla(int deltaX, int deltaY) {
		this.vertice.setX(this.vertice.getX() + deltaX);
		this.vertice.setY(this.vertice.getY() + deltaY);
	}

	@Override
	public boolean equals(Object o) {
		if(o==null||!(o instanceof Forma))
			return false;
		Forma f=(Forma) o;
		if(this.isDegenere()&&f.isDegenere())
			return this.getPuntoDegenere().equals(f.getPuntoDegenere());
		if(o==null || this.getClass()!=o.getClass())
			return false;
		final Rettangolo that = (Rettangolo) o;
		return (this.getVertice().equals(that.getVertice()) && this.getBase() == that.getBase() && this.getAltezza()==that.getAltezza());
	}
	@Override
	public int hashCode() {
		return this.getClass().hashCode()+this.getVertice().hashCode()+this.getBase()+this.getAltezza();
	}

	@Override
	public Punto getPuntoDegenere() {
		if(!isDegenere())
			return null;
		return this.getVertice();
	}

	@Override
	public boolean isDegenere() {
		return this.getAltezza()==0 && this.getBase()==0;
	}
}