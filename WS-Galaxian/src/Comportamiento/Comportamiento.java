package Comportamiento;

public abstract class Comportamiento {
	protected int velocidad;
	protected int direccion;

	public abstract void activar();

	public void setDireccion(int d) {
		direccion = d;
	}
}
