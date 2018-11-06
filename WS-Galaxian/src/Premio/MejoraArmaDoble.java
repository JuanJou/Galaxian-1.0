package Premio;

import java.awt.Point;

import javax.swing.ImageIcon;

import Disparo.FabricaDoble;

import Juego.*;

public class MejoraArmaDoble extends PrototipoPremio {

	public MejoraArmaDoble(Point pos) {
		super(pos);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/armaN.png"));
	}

	public PrototipoPremio clone() {
		MejoraArmaDoble clon = new MejoraArmaDoble(new Point(this.pos.x, this.pos.y));
		return clon;
	}
	public void meActivo(InterfazJuego juego) {
		juego.getJugador().setFabrica(new FabricaDoble(juego));
	}

	
}
