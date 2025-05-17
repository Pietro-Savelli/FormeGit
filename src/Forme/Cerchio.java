package Forme;

public class Cerchio implements Forma{
	private int raggio;
	private Punto centro;

	public Cerchio(Punto centro, int raggio) {
		this.raggio = raggio;
		this.centro = new Punto(centro.getX(), centro.getY());
	}

	@Override
	public void trasla(int deltaX, int deltaY) {
		this.centro.setX(this.centro.getX() + deltaX);
		this.centro.setY(this.centro.getY() + deltaY);
	}

	public Punto getCentro() {
		return this.centro;
	}

	public int getRaggio() {
		return this.raggio;
	}
	

	@Override
	public boolean equals(Object o) {
		if(o==null||!(o instanceof Forma))
			return false;
		
		Forma f=(Forma) o;
		if(this.isDegenere()&&f.isDegenere())
			return this.getPuntoDegenere().equals(f.getPuntoDegenere());
		
		//da qui in poi sono sicuro che entrambi sono non degeneri
		if(this.getClass()!=o.getClass())
			return false;
		
		final Cerchio that = (Cerchio) o;
		return (this.getCentro().equals(that.getCentro()) && this.getRaggio() == that.getRaggio());
	}
	
	@Override
	public int hashCode() {
		return this.getCentro().hashCode()+this.getRaggio();
	}

	@Override
	public boolean isDegenere() {
		// TODO Auto-generated method stub
		return this.getRaggio()==0;
	}

	@Override
	public Punto getPuntoDegenere() {
		if(!isDegenere())
			return null;
		return this.getCentro();
	}
}
