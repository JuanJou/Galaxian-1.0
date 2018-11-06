package Comportamiento;

import Premio.*;

public class MovimientoPremio extends Comportamiento {

	private Premio e;

	public MovimientoPremio(Premio e) {
		this.e = e;
		velocidad = 5;
	}

	public void activar() {
		moverEntidad();
	}

	private void moverEntidad() {
		e.setPos(e.getPos().x, e.getPos().y + velocidad);
		if ((e.getPos().y) > 550) 
			e.aniquilado();
	}
}
