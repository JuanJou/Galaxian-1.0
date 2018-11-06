package Premio;

import java.awt.Point;
import javax.swing.ImageIcon;
import Disparo.FabricaSuper;
import Juego.*;

public class SuperDisparo extends PrototipoPremio {

	public SuperDisparo(Point pos) {
		super(pos);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/escu.png"));
	}

	public PrototipoPremio clone() {
		SuperDisparo clon = new SuperDisparo(new Point(this.pos.x, this.pos.y));
		return clon;
	}
	public void meActivo(InterfazJuego juego) {
		juego.getJugador().setFabrica(new FabricaSuper(juego));
	}

	
}
