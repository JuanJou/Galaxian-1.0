package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.*;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorEnemigo extends Colisionador {

	public ColisionadorEnemigo() {
		fuerzaImpacto = 5;
	}

	public void atacarJugador(Jugador j) {
		j.restarPorcentajeVida(fuerzaImpacto);
	}

	public void atacarEnemigo(Enemigo e) {
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
	}

	public void atacarObstaculo(Destruible d) {
		d.setPorcentajeVida(d.getPorcentajeVida() - fuerzaImpacto);
	}
	
	public void atacarObstaculo(Barricada b) {};
}
