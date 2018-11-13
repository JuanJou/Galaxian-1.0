package Comportamiento;

import Juego.Entidad;

public class Standard extends Comportamiento {

	private Entidad e;

	public Standard(Entidad e) {
		this.e = e;
		velocidad = 4;
	}

	public void activar() {
		moverEntidad();
	}

	private void moverEntidad() {
		
			e.setPos(e.getPos().x, e.getPos().y + velocidad);
			if ((e.getPos().y) > 550) {
				e.setPos(e.getPos().x, 0);
			}
			
		
	}
}
