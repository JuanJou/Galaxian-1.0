package Enemigo;

import java.awt.Point;
import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Comportamiento.Standard;
import Disparo.FabricaDisparoEnemigo;
import Juego.InterfazJuego;

public class Distraido extends PrototipoEnemigo {

	public Distraido(Point pos, FabricaDisparoEnemigo fabio, InterfazJuego juego) {
		super(pos, fabio, juego);
		setGraficos();
		comportamiento = new Standard(this);
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/boboN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public PrototipoEnemigo clone() {
		Distraido clon = new Distraido(new Point(this.pos.x, this.pos.y), fabricaDisparoEnemigo, this.juego);
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
		comportamiento = new Standard(this);
	}

	public void tieneEscudo(int n) {
		setPorcentajeVida(getPorcentajeVida() - n);
	}
}
