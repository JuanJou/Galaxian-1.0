package Premio;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparo.FabricaTriple;
import Juego.*;

public class MejoraArmaTriple extends PrototipoPremio {

	public MejoraArmaTriple(Point pos,InterfazJuego g) {
		super(pos,g);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/armaNN.png"));
	}
	
	public PrototipoPremio clone() {
		MejoraArmaTriple clon = new MejoraArmaTriple(new Point(this.pos.x, this.pos.y),game);
		return clon;
	}

	public void meActivo() {
		game.getJugador().setFabrica(new FabricaTriple(game));
	}

}
