package Disparo;

import java.awt.Point;

import Comportamiento.DisparaDerecha;
import Comportamiento.DisparaIzquierda;
import Juego.InterfazJuego;

public class FabricaTriple extends FabricaDisparos {
	private int cantDisparos;


	public FabricaTriple(InterfazJuego juego) {
		super(juego);
		cantDisparos = 5;
	}

	public void crearDisparo(int x, int y) {
		if (cantDisparos > 0) {
			Disparo disp1 = new DisparoSimple(new Point(x - 50, y), 10);
			disp1.setComportamiento(new DisparaIzquierda(disp1));
			Disparo disp2 = new DisparoSimple(new Point(x, y), 10);
			Disparo disp3 = new DisparoSimple(new Point(x + 50, y), 10);
			disp3.setComportamiento(new DisparaDerecha(disp3));
			juego.getNivel().agregarEntidadEnLista(disp1);
			juego.getNivel().agregarEntidadEnLista(disp2);
			juego.getNivel().agregarEntidadEnLista(disp3);
			cantDisparos--;
		}
		else
			juego.getJugador().setFabrica(new FabricaSimple(juego));
	}
}
