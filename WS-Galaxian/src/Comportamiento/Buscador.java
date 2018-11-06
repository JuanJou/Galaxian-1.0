package Comportamiento;

import Juego.Entidad;

public class Buscador extends Comportamiento {

	private Entidad seguidor;
	private Entidad buscado;

	public Buscador(Entidad seguidor, Entidad buscado) {
		this.seguidor = seguidor;
		velocidad = 4;
		this.buscado = buscado;
	}

	public void activar() {
		int cordXBuscado = buscado.getPos().x;
		int cordXSeguidor = seguidor.getPos().x;
		int cordYSeguidor = seguidor.getPos().y;

		if(cordXSeguidor>cordXBuscado)
			seguidor.setPos(seguidor.getPos().x-1, seguidor.getPos().y+velocidad);
		else if(cordXSeguidor<cordXBuscado)
				seguidor.setPos(seguidor.getPos().x+1, seguidor.getPos().y+velocidad);
			else
				seguidor.setPos(seguidor.getPos().x, seguidor.getPos().y+velocidad);
		
		if (cordYSeguidor > 500) {
			seguidor.setPos(seguidor.getPos().x, 0);
		}
	}

}
