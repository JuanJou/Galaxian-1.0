package Disparo;

import java.awt.Point;
import Colisionador.ColisionadorDisparo;
import Comportamiento.DisparaArriba;

public abstract class DisparoJugador extends Disparo {

	public DisparoJugador(Point pos,  int fuerzaImpacto) {
		super(pos, fuerzaImpacto);
		colisionador = new ColisionadorDisparo(this);
		comportamiento=new DisparaArriba(this);
	}
	
	public void ponerEscudo() {
	}
	
	public void sacarEscudo() {}


}
