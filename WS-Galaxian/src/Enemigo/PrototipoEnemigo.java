package Enemigo;

import java.awt.Point;

import Colisionador.ColisionadorEnemigo;
import Colisionador.ColisionadorNeutro;
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
	
	public abstract PrototipoEnemigo clone(); 
	
	public abstract void disparar();
	
	public void pausar() {
		comportamiento = new Nulo();
		pausado = true;
	}
	
	public void sacarEscudo() {
		colisionador=new ColisionadorEnemigo();
		fabricaDisparoEnemigo.setEscudo(false);
	}
	public void ponerEscudo() {
		colisionador=new ColisionadorNeutro();
		fabricaDisparoEnemigo.setEscudo(true);
	};
	
}
