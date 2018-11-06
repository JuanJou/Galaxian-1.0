package Enemigo;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Comportamiento.*;
import Disparo.FabricaDisparoEnemigo;
import Juego.InterfazJuego;

public class Bomba extends PrototipoEnemigo {

	public Bomba(Point pos, FabricaDisparoEnemigo fabio, InterfazJuego juego) {
		super(pos, fabio, juego);
		setGraficos();
		comportamiento = new Standard(this);
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/bombaN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public PrototipoEnemigo clone() {
		Bomba clon = new Bomba(new Point(this.pos.x, this.pos.y), fabricaDisparoEnemigo, this.juego);
		return clon;
	}

	public void meAtacan(Colisionador c) {
		c.atacarEnemigo(this);
	}

	public void actualizar() {
		if (porcentajeVida > 0) {
			moverme();
			// DISPARO RANDOM
			if (!pausado) {
				Random rnd = new Random();
				if (rnd.nextInt(100) == 0)
					disparar();
			}
		}
		else
			aniquilado();
	}

	public void disparar() {
		fabricaDisparoEnemigo.crearDisparo(getPos().x, getPos().y + 10);
	}

	public void reanudar() {
		comportamiento = new Standard(this);
		pausado = false;
	}
	
}
