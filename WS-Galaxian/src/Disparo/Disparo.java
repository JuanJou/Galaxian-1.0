package Disparo;

import java.awt.Point;

import Juego.Entidad;

public abstract class Disparo extends Entidad {

	protected int fuerzaImpacto;
	
	public Disparo(Point pos, int fuerzaImpacto) {
		super(pos);
		this.fuerzaImpacto = fuerzaImpacto;
	}
	
	public void actualizar() {
		if(getPos().y < 0 || getPos().y > 600) {
			aniquilado();
		}
	}
	
	public int getFuerzaImpacto() {
		return fuerzaImpacto;
	}
	
	public void pausar() {
	}

	public void reanudar() {
	}
	
	public void ponerEscudo() {
	}
	
	public void sacarEscudo() {
	}
}
