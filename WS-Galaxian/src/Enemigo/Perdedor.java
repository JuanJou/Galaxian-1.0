package Enemigo;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Comportamiento.Buscador;
import Comportamiento.Standard;
import Disparo.FabricaDisparoEnemigo;
import Juego.InterfazJuego;
import Logica.*;

public class Perdedor extends PrototipoEnemigo {

	public Perdedor(Point pos, FabricaDisparoEnemigo fabio, InterfazJuego juego) {
		super(pos, fabio, juego);
		setGraficos();
		comportamiento = new Standard(this);
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/perdedorN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public PrototipoEnemigo clone() {
		Perdedor clon = new Perdedor(new Point(this.pos.x, this.pos.y), fabricaDisparoEnemigo, this.juego);
		return clon;
	}

	public void meAtacan(Colisionador c) {
		c.atacarEnemigo(this);
	}

	public void actualizar() {
		if (porcentajeVida > 0) {
			moverme();
			if (!pausado)
				if (porcentajeVida <= 20)
					comportamiento = new Buscador(this, juego.getJugador());
				else {
					// DISPARO RANDOM
					Random rnd = new Random();
					if (rnd.nextInt(100) == 0) {
						disparar();
						Sound.COL.play();
					}
				}
		} else
			aniquilado();
	}

	public void disparar() {
		fabricaDisparoEnemigo.crearDisparo(getPos().x, getPos().y + 10);
	}

	public void reanudar() {
		comportamiento = new Standard(this);
		pausado = false;
	}
	
	public void tieneEscudo(int n) {
		setPorcentajeVida(getPorcentajeVida() - n);
	}
	


}