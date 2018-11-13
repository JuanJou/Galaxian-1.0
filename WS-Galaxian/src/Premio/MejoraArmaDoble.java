package Premio;

import java.awt.Point;

import javax.swing.ImageIcon;

import Disparo.FabricaDoble;

import Juego.*;

public class MejoraArmaDoble extends PrototipoPremio {

	public MejoraArmaDoble(Point pos,InterfazJuego g) {
		super(pos,g);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/armaN.png"));
	}

	public PrototipoPremio clone() {
		MejoraArmaDoble clon = new MejoraArmaDoble(new Point(this.pos.x, this.pos.y),game);
		return clon;
	}
	public void meActivo() {
		game.getJugador().setFabrica(new FabricaDoble(game));
	}

	
}
