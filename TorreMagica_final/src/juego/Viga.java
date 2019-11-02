package juego;
import entorno.Entorno;
import java.awt.*;

public class Viga {
	private Constantes constantes;
	private double x,y;
	private double ancho, alto;
	private double escala;
	private Image img;

	/**Constructor**/
	public Viga(){
		this.constantes = new Constantes();
		this.x = 0;
		this.y = 0;
		this.ancho = 0;
		this.alto = 0;
		this.escala = 0;
		this.img = null;
	}
	//-----------------------------------------------GETTERS------------------------------------//
	public double getAltoViga() {return this.alto;}
	public double getAnchoViga() {return this.ancho;}
	public double getXPos() {return this.x;}
	public double getYPos() {return this.y;}
	//-----------------------------------------------SETTERS------------------------------------//
	public void setPos(double x, double y) {
		//X axis
		this.x = x;
		//Y axis
		this.y = y;
	}

	public void setDimensiones(double w, double h, double escala){
		//Alto
		this.alto = h;
		//Ancho
		this.ancho = w;
		//Escala
		this.escala = escala;
	}

	public void setImage(Image img){
		this.img = img;
	}

	//-----------------------------------------------METODOS------------------------------------//
	/**Validaciones**/
	public boolean validarXPos(double x) {
		if (x>=0 && x<constantes.getAnchoPantalla()) {
			return true;
		}return false;
	}

	public boolean validarYPos(double y) {
		if (y >= 0 && (y + getAltoViga())<constantes.getAltoPantalla()) {
			return true;
		}return false;
	}

	public boolean validarAnchoViga(double w) {
		if ((this.x + w) <= constantes.getAnchoPantalla()) {
			return true;
		}return false;
	}

	public boolean validarAltoViga(double h) {
		if ((this.y + h) <= constantes.getAltoPantalla()) {
			return true;
		}return false;
	}

	/**Utilidad**/
	public void dibujarViga(Entorno entorno) {
		entorno.dibujarImagen(this.img, this.x, this.y, 0, escala);
	}

	public void dibujarPared(Entorno entorno){
		for(int i = 0; i < constantes.getAltoPantalla(); i+=15){
			entorno.dibujarImagen(this.img, 10 , i, 0);
			entorno.dibujarImagen(this.img, 790, i, 0);
		}
	}

}
