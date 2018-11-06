package Disparo;

import java.awt.Point;
import Juego.InterfazJuego;

public class FabricaSimple extends FabricaDisparos {

	public FabricaSimple(InterfazJuego juego) {
		super(juego);
	}

	public void crearDisparo(int x, int y) {
		Disparo disp = new DisparoSimple(new Point(x,y), 20);
		juego.getNivel().agregarEntidadEnLista(disp);
	}

}
