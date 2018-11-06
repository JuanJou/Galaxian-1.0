package Colisionador;

import Disparo.*;
import Enemigo.Enemigo;
import Juego.Jugador;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorDisparo extends Colisionador {

	private Disparo disparo;

	public ColisionadorDisparo(Disparo d) {
		fuerzaImpacto = d.getFuerzaImpacto();
		disparo = d;
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
		e.setPorcentajeVida(e.getPorcentajeVida() - fuerzaImpacto);
		disparo.cambiarGrafico(1);
		disparo.aniquilado();
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
	}

	public void atacarObstaculo(Destruible d) {
		d.setPorcentajeVida(d.getPorcentajeVida() - 10);
		if (d.getPorcentajeVida() <= 0) {
			disparo.cambiarGrafico(1);
			disparo.aniquilado();
		}
	}
	
	public void atacarObstaculo(Barricada b) {
		b.setPorcentajeVida(b.getPorcentajeVida() - 10);
		if (b.getPorcentajeVida() <= 0) {
			disparo.cambiarGrafico(1);
			disparo.aniquilado();
		}
	};
}
