package Premio;

import java.awt.Point;

import javax.swing.ImageIcon;

import Logica.*;
import Juego.*;

public class DetenerTiempo extends PrototipoPremio {
	
	public DetenerTiempo(Point pos,InterfazJuego g) {
		super(pos,g);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/tiempoN.png"));
	}

	public PrototipoPremio clone() {
		DetenerTiempo clon = new DetenerTiempo(new Point(this.pos.x, this.pos.y),game);
		return clon;
	}
	
	public void meActivo() {
		Temp t = new Temp(game.getNivel());
		t.start();
		aniquilado();
		
	}
	
    

	
}
