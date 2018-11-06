package Disparo;

import java.awt.Point;

import Juego.InterfazJuego;

public class FabricaSuper extends FabricaDisparos {
	private int cantDisparos;

	public FabricaSuper(InterfazJuego juego) {
		super(juego);
		cantDisparos = 10;
	}

	public void crearDisparo(int x, int y) {
		if (cantDisparos > 0) {
			Disparo disp2 = new DisparoSuper(new Point(x, y), 80);
			juego.getNivel().agregarEntidadEnLista(disp2);
			cantDisparos--;
		}
		else
			juego.getJugador().setFabrica(new FabricaSimple(juego));
	}
}