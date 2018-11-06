package Comportamiento;

import Disparo.Disparo;

public class DisparaIzquierda extends Comportamiento {
	
	private Disparo disparo;

	public DisparaIzquierda(Disparo d) {
		disparo = d;
		velocidad = 14;
	}

	public void activar() {
		disparo.cambiarGrafico(0);
		disparo.setPos(disparo.getPos().x-4, disparo.getPos().y - (velocidad));
	}

}
