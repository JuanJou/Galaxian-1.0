package Comportamiento;

import Disparo.*;

public class DisparaArriba extends Comportamiento {
	
	private Disparo disparo;

	public DisparaArriba(Disparo d) {
		disparo = d;
		velocidad = 10;
	}

	public void activar() {
		disparo.setPos(disparo.getPos().x, disparo.getPos().y - velocidad);
	}
}