package Enemigo;

import java.awt.Point;
import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Comportamiento.Buscador;
import Disparo.FabricaDisparoEnemigo;
import Juego.InterfazJuego;

public class Kamikaze extends PrototipoEnemigo {
	
	public Kamikaze(Point pos, FabricaDisparoEnemigo fabio, InterfazJuego juego) {
		super(pos, fabio, juego);
		setGraficos();
		comportamiento = new Buscador(this, juego.getJugador());
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/kamikazeN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public PrototipoEnemigo clone() {
		Kamikaze clon = new Kamikaze(new Point(this.pos.x, this.pos.y), fabricaDisparoEnemigo, this.juego);
		return clon;

	}

	public void meAtacan(Colisionador c) {
		c.atacarEnemigo(this);
	}

	public void actualizar() {
		if (porcentajeVida > 0)
			moverme();
		else
			aniquilado();
	}

	public void disparar() {
	}
	
	public void reanudar() {
		comportamiento = new Buscador(this, juego.getJugador());
	}
	
	
	public void tieneEscudo(int n) {
		aniquilado();
		juego.getNivel().sacarEscudo();
	}
	
	
}
