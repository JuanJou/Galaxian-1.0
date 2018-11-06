package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.Jugador;
import Obstaculo.Barricada;
import Obstaculo.Destruible;
import Premio.Premio;

public class ColisionadorNeutro extends Colisionador{

	public ColisionadorNeutro() {
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
	}

	public void atacarObstaculo(Destruible d) {}
	
	public void atacarObstaculo(Barricada b) {}
}
