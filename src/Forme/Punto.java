package Forme;


public class Punto implements Forma {
	private int x,y;
	public Punto (int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setX(int x){ 
		this.x = x; 
	}
	public void setY(int y){ 
		this.y = y; 
	}
	public int getX(){ 
		return this.x; 
	}
	public int getY(){ 
		return this.y; 
	}

	@Override
	public boolean equals(Object o) {
//		if(o==null||!(o instanceof Forma))
//			return false;
//		Forma f=(Forma) o;
//		if(this.isDegenere()&&f.isDegenere()) {
//			if(f.getClass()==Punto.class) {
//				final Punto that = (Punto)f;
//				return this.x==that.getX() && this.y==that.getY();
//			}
//			return this.getPuntoDegenere().equals(f.getPuntoDegenere());
//		}
		// un punto è degenere a priori, non c'è bisogno dei controlli e di chiamare altri equals basta il controllo base
		if(o==null || this.getClass()!=o.getClass())
			return false;
		
		final Punto that = (Punto)o;
		return this.x==that.getX() && this.y==that.getY();
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode()+this.getX()+this.getY();
	}
	@Override
	public void trasla(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		this.setX(deltaX+this.getX());
		this.setY(deltaY+this.getY());

	}
	@Override
	public boolean isDegenere() {
		return true;
	}
	@Override
	public Punto getPuntoDegenere() {
		return this;
	}
}