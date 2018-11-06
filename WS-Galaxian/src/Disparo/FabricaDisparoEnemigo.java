package Disparo;

import java.awt.Point;
import Juego.InterfazJuego;

public class FabricaDisparoEnemigo extends FabricaDisparos {

	public FabricaDisparoEnemigo(InterfazJuego juego) {
		super(juego);
	}

	public void crearDisparo(int x, int y) {
		Disparo disp = new DisparoEnemigo(new Point(x, y), 10);
		juego.getNivel().agregarEntidadEnLista(disp);
	}

}
