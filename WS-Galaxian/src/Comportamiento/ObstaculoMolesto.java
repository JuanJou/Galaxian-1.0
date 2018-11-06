package Comportamiento;

import Juego.Entidad;

public class ObstaculoMolesto extends Comportamiento {

	private Entidad e;
	boolean derechaArriba;
	boolean derechaAbajo;
	boolean izquierdaArriba;
	boolean izquierdaAbajo;

	public ObstaculoMolesto(Entidad e) {
		this.e = e;
		velocidad = 2;
		derechaArriba = true;
		derechaAbajo=false;
		izquierdaArriba=false;
		izquierdaAbajo=false;
	}

	public void activar() {
		moverEntidad();
	}

	private void moverEntidad() {
		int cordXEntidad = e.getPos().x;
		int cordYEntidad=e.getPos().y;

		if (derechaArriba) {
			e.setPos(cordXEntidad + 5, e.getPos().y-5);
			if (cordXEntidad > 700 || cordYEntidad < 0) {
				derechaArriba = false;
				izquierdaAbajo=true;}
		} 
		else {
			if (izquierdaAbajo) {
				e.setPos(cordXEntidad - 5, e.getPos().y+5);
				if (cordXEntidad < 400 || cordYEntidad > 300) {
					izquierdaAbajo = false;
					izquierdaArriba=true;
				}
			}
			else {
				if (izquierdaArriba) {
					e.setPos(cordXEntidad - 5, e.getPos().y-5);
					if (cordXEntidad < 0 || cordYEntidad < 0) {
						izquierdaArriba = false;
						derechaAbajo=true;
					}
				}
				else {
					if (derechaAbajo) {
						e.setPos(cordXEntidad + 5, e.getPos().y+5);
						if (cordXEntidad > 400 || cordYEntidad > 300) {
							derechaAbajo = false;
							derechaArriba=true;
						}
					} 
				}	
			}
		} 

	}
}