package Enemigo;

import java.awt.Point;
import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Comportamiento.Bobo;
import Comportamiento.Buscador;
import Disparo.FabricaDisparoEnemigo;
import Juego.InterfazJuego;

public class Debil extends PrototipoEnemigo {

	public Debil(Point pos, FabricaDisparoEnemigo fabio, InterfazJuego juego) {
		super(pos, fabio, juego);
		setGraficos();
		comportamiento = new Buscador(this, juego.getJugador());
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/cambianteN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public PrototipoEnemigo clone() {
		Debil clon = new Debil(new Point(this.pos.x, this.pos.y), fabricaDisparoEnemigo, this.juego);
		return clon;
	}

	public void meAtacan(Colisionador c) {
		c.atacarEnemigo(this);
	}

	public void actualizar() {
		if (porcentajeVida > 0) {
			moverme();
			if (porcentajeVida <= 50 && !pausado) {
				comportamiento = new Bobo(this);
			}
		} else
			aniquilado();
	}

	public void disparar() {
	}

	public void reanudar() {
		comportamiento = new Buscador(this,juego.getJugador());
		pausado = false;
	}
	
	public void tieneEscudo() {
	}
}
