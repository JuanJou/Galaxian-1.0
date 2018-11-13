package Premio;

import java.awt.Point;

import Juego.InterfazJuego;

public abstract class PrototipoPremio extends Premio{
	protected InterfazJuego game;
	
	public PrototipoPremio(Point pos,InterfazJuego g){
		super(pos);
		game=g;
	}

	public abstract PrototipoPremio clone();
}