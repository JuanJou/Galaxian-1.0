package Comportamiento;

import Disparo.Disparo;

public class DisparaAbajo extends Comportamiento {

	private Disparo disparo;

	public DisparaAbajo(Disparo d) {
		disparo = d;
		velocidad = 10;
	}

	public void activar() {
		disparo.setPos(disparo.getPos().x, disparo.getPos().y + (velocidad));
	}

}
