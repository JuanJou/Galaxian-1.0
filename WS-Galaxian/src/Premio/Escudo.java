package Premio;

import java.awt.Point;
import javax.swing.ImageIcon;
import Juego.InterfazJuego;

public class Escudo extends PrototipoPremio {

	public Escudo(Point pos,InterfazJuego g) {
		super(pos,g);
		setGraficos();
	}
	
	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/escudo.png"));
	}

	public PrototipoPremio clone() {
		Escudo clon = new Escudo(new Point(this.pos.x, this.pos.y),game);
		return clon;
	}
	
	public void meActivo() {
		game.getNivel().ponerEscudo();
	}

}
