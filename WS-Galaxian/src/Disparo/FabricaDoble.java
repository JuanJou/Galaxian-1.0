package Disparo;

import java.awt.Point;

import Comportamiento.DisparaDerecha;
import Comportamiento.DisparaIzquierda;
import Juego.InterfazJuego;

public class FabricaDoble extends FabricaDisparos {
	private int cantDisparos;


	public FabricaDoble(InterfazJuego juego) {
		super(juego);
		cantDisparos = 8;
	}

	public void crearDisparo(int x, int y) {
		if (cantDisparos > 0) {
			Disparo disp1 = new DisparoSimple(new Point(x - 50, y), 10);
			disp1.setComportamiento(new DisparaDerecha(disp1));
			Disparo disp3 = new DisparoSimple(new Point(x + 50, y), 10);
			disp3.setComportamiento(new DisparaIzquierda(disp3));
			juego.getNivel().agregarEntidadEnLista(disp1);
			juego.getNivel().agregarEntidadEnLista(disp3);
			cantDisparos--;
		}
		else
			juego.getJugador().setFabrica(new FabricaSimple(juego));
	}
}
