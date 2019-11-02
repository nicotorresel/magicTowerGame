package juego;

import entorno.Entorno;

public class Spell {
    private Repositorio repo;
    private double x, y;
    private double angulo;

    /**Constructor**/
    public Spell(){
        //El spell tendra movimiento continuo hasta colisionar con la pared o si el mago cae a otra viga
        this.repo = new Repositorio();
        //this.hitbox = new Hitbox();
        //Uso el centro del mago como punto de referencia para dibujar el spell
        this.x = 0 ;
        this.y = 0 ;
        this.angulo = 0.5;
    }
    //-----------------------------------------------GETTERS------------------------------------//
    public double getXPos() {return this.x;}
    public double getYPos() {return this.y;}
    //-----------------------------------------------SETTERS------------------------------------//
    public void setPos(double x, double y) {this.x = x; this.y = y;}
    public void setAnguloSpell(double a) {this.angulo=a;}
    //-----------------------------------------------METODOS------------------------------------//
    /**Validaciones**/
    //Si el mago cae de una viga a la otra ...
    public void reset (Entorno entorno, double x, double y){
        this.x=x;
        this.y=y;
    }
    /**Utilidad**/
    //Metodo para mover el spell
    public void mover(Entorno entorno, boolean direccion){
        if(direccion){this.x+=15;}else{this.x-=15;}
    }

    //Metodo para dibujar en la pantalla el spell
    public void dibujarSpell (Entorno entorno, int ms){
        for(int i = 0; i < ms; i++){
            entorno.dibujarImagen(repo.getArcane_Spell(), this.x, this.y, i/6, angulo);
        }
    }
}