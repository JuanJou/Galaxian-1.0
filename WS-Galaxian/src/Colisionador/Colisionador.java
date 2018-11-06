package Colisionador;

import Juego.*;
import Enemigo.*;
import Obstaculo.*;
import Disparo.*;
import Premio.*;

public abstract class Colisionador {
	
	protected int fuerzaImpacto;

	public abstract void atacarJugador(Jugador j);

	public abstract void atacarEnemigo(Enemigo e);

	public abstract void atacarDisparo(Disparo d);

	public abstract void atacarPremio(Premio p);

	public abstract void atacarObstaculo(Barricada b);
	
	public abstract void atacarObstaculo(Destruible d);
}
