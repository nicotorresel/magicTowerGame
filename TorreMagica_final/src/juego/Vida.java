package juego;

import java.awt.Image;
import entorno.Entorno;

public class Vida {
    private Repositorio repo;
    private Image health;
    private Image health_mid;
    private Image health_low;

    /** Constructor **/
    public Vida() {
        this.repo = new Repositorio();
        this.health = repo.getHealth_Full();
        this.health_mid = repo.getHealth_Mid();
        this.health_low = repo.getHealth_Low();
    }
    //-----------------------------------------------SETTERS------------------------------------//
    public void cambiar(int a){
        if (a==1){
            this.health=this.health_low;
        }
        else if(a==2){
            this.health=this.health_mid;
        }
    }
    //-----------------------------------------------METODOS------------------------------------//
    /*Utilidad*/
    public void dibujarVidas(Entorno entorno,double x,double y){
        entorno.dibujarImagen(this.health, x,y, 0,0.05);
    }

}