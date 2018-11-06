package Comportamiento;

import Disparo.Disparo;

	public class DisparaDerecha extends Comportamiento {
		
		private Disparo disparo;

		public DisparaDerecha(Disparo d) {
			disparo = d;
			velocidad = 14;
		}

		public void activar() {
			disparo.cambiarGrafico(0);
			disparo.setPos(disparo.getPos().x+4, disparo.getPos().y - (velocidad));
		}

	}


