package Premio;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparo.FabricaTriple;
import Juego.*;

public class MejoraArmaTriple extends PrototipoPremio {

	public MejoraArmaTriple(Point pos) {
		super(pos);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/armaNN.png"));
	}
	
	public PrototipoPremio clone() {
		MejoraArmaTriple clon = new MejoraArmaTriple(new Point(this.pos.x, this.pos.y));
		return clon;
	}

	public void meActivo(InterfazJuego juego) {
		juego.getJugador().setFabrica(new FabricaTriple(juego));
	}

}
