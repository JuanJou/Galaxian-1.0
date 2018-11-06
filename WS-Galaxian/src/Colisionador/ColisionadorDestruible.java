package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.Jugador;
import Obstaculo.*;
import Premio.*;

public class ColisionadorDestruible extends Colisionador {

	public ColisionadorDestruible() {
		fuerzaImpacto = 10;
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
		e.setPos(e.getPos().x, e.getPos().y - 50);
		e.setPorcentajeVida(e.getPorcentajeVida() - fuerzaImpacto);
	}

	public void atacarDisparo(Disparo d) {

		d.aniquilado();
	}

	public void atacarPremio(Premio p) {
	}

	public void atacarObstaculo(Destruible d) {		
	}
	
	public void atacarObstaculo(Barricada b) {}
}
