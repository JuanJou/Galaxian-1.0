package Disparo;

import Juego.InterfazJuego;


public abstract class FabricaDisparos {

	protected InterfazJuego juego;
	protected int cadenciaDisparo;
	
	public FabricaDisparos(InterfazJuego juego) {
		this.juego = juego;
	}
	
	public abstract void crearDisparo(int x, int y);
	
	public int getCadencia() {
		return cadenciaDisparo;
	}
	
}
