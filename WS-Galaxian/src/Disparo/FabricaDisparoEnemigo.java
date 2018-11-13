package Disparo;

import java.awt.Point;

import Colisionador.ColisionadorNeutro;
import Juego.InterfazJuego;

public class FabricaDisparoEnemigo extends FabricaDisparos {
	boolean escudo;
	public FabricaDisparoEnemigo(InterfazJuego juego) {
		super(juego);
		escudo=false;
	}

	public void crearDisparo(int x, int y) {
		if(escudo==false) {
			Disparo disp = new DisparoEnemigo(new Point(x, y), 10);
			juego.getNivel().agregarEntidadEnLista(disp);
		}
		else {
			Disparo disp = new DisparoEnemigo(new Point(x, y), 10);
			disp.setColisionador(new ColisionadorNeutro());
			juego.getNivel().agregarEntidadEnLista(disp);
		}	
	}
	
	public void setEscudo(boolean b) {
		escudo=b;
	}
	
	
	

}
