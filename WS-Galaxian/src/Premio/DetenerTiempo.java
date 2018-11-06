package Premio;

import java.awt.Point;

import javax.swing.ImageIcon;

import Juego.*;

public class DetenerTiempo extends PrototipoPremio {
	
	public DetenerTiempo(Point pos) {
		super(pos);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/tiempoN.png"));
	}

	public PrototipoPremio clone() {
		DetenerTiempo clon = new DetenerTiempo(new Point(this.pos.x, this.pos.y));
		return clon;
	}
	
	public void meActivo(InterfazJuego j) {
		Temp t = new Temp(j.getNivel());
		t.start();
		aniquilado();
		
	}
	
    

	
}
