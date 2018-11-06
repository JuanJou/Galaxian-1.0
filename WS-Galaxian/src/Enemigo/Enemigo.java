package Enemigo;

import Juego.*;
import Premio.*;
import java.awt.Point;
import Colisionador.*;
import Nivel.InterfazNivel;

public abstract class Enemigo extends Entidad {
	protected boolean entregaPremio;
	protected Premio miPremio;
	protected InterfazNivel nivel;

	protected Enemigo(Point pos) {
		super(pos);
		entregaPremio = false;
		estaAniquilado = false;
		colisionador = new ColisionadorEnemigo();
		puntaje = 30;
	}

	private void entregarPremio() {
		miPremio.setPos(this.getPos().x, this.getPos().y);
		nivel.agregarEntidadEnLista(miPremio);
	}

	public void asignarPremio(Premio p) {
		miPremio = p;
		entregaPremio = true;
	}

	public void aniquilado() {
		estaAniquilado = true;
		if (entregaPremio)
			entregarPremio();
	}

	public abstract void actualizar();

	public void tieneEscudo(int fuerzaImpacto) {
		porcentajeVida = porcentajeVida - fuerzaImpacto;
	}

	public void sacarEscudo() {
	}

	public void ponerEscudo() {
	}
}
