package juego;

import java.awt.Rectangle;

public class Hitbox {
	private int x,y;
	private int ancho,alto;
	private Rectangle area;

	/**Constructor**/
	Hitbox(){
		this.x = 0;
		this.y = 0;
		this.ancho = 50;
		this.alto = 40;
		//creo un rectangulo hitbox
		this.area = new Rectangle(this.x, this.y, this.ancho, this.alto); 
	}
	//-----------------------------------------------GETTERS------------------------------------//
	public Rectangle area(){return this.area;}
	//-----------------------------------------------SETTERS------------------------------------//
	public void setPos(double x, double y){this.x = (int)x; this.y = (int)y;}
	public void setAncho(int ancho){ this.ancho = ancho; }
	public void setAlto(int alto){ this.alto = alto;}
	//-----------------------------------------------METODOS------------------------------------//
	/**Utilidad**/
	// metodo que calcula la interseccion de dos rectangulos
	public boolean hit(Rectangle a, Rectangle b ){
		if (a.intersects(b)){
			return true;
		}
		return false;
	}
	// metodo para mover el rectangulo (va a servir para mover el rectangulo segun la instancia del mago o npc)
	public void move(double x, double y){
		area.setFrame(x,y,this.ancho,this.alto);
	}
}