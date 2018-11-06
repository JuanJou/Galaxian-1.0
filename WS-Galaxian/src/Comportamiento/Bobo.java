package Comportamiento;

import Juego.Entidad;

public class Bobo extends Comportamiento {

	private Entidad e;

	public Bobo(Entidad e) {
		this.e = e;
		velocidad = 4;
	}

	public void activar() {
		moverEntidad(1);
	}

	private void moverEntidad(int dir) {
		switch (dir) {
		case 0: // Arriba
			break;
		case 1: // Abajo
			e.setPos(e.getPos().x, e.getPos().y + velocidad);
			if ((e.getPos().y) > 500) {
				e.setPos(e.getPos().x, 0);
			}
			break;
		case 2: // Izquierda
			if (e.getPos().getX() > 0) {
				e.setPos(e.getPos().x - 1, e.getPos().y+velocidad);
			}
			break;
		case 3: // Derecha
			if (e.getPos().getX() < 600) {
				e.getPos().setLocation(e.getPos().x + 1, e.getPos().y+velocidad);
			}
			break;
		}
	}

}
