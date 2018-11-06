package Enemigo;

import java.awt.Point;

import Comportamiento.Nulo;
import Disparo.FabricaDisparoEnemigo;
import Juego.InterfazJuego;

public abstract class PrototipoEnemigo extends Enemigo {
	protected FabricaDisparoEnemigo fabricaDisparoEnemigo;
	protected InterfazJuego juego;
	protected boolean pausado;

	public PrototipoEnemigo(Point pos, FabricaDisparoEnemigo fadien, InterfazJuego juego) {
		super(pos);
		this.fabricaDisparoEnemigo = fadien;
		porcentajeVida = 100;
		this.juego = juego;
		this.nivel = juego.getNivel();
		pausado = false;
	}
	
	public PrototipoEnemigo clone() {
		return this.clone();
	}
	
	public void setJuego(InterfazJuego juego) {
		this.juego = juego;
	}
	
	public void setFabricaDisparos(FabricaDisparoEnemigo fad) {
		this.fabricaDisparoEnemigo = fad;
	}
	
	public abstract void disparar();
	
	public void pausar() {
		comportamiento = new Nulo();
		pausado = true;
	}
	
}
