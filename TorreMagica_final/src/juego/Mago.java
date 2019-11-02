package juego;

import entorno.Entorno;
import java.awt.*;

public class Mago {
    private Constantes constantes;
    private Repositorio repo;
    private double x,y;
    private double angulo;
    private boolean estado;
    private boolean direccion;
    private Image img_center;

    /**Constructor**/
    Mago(){
        constantes = new Constantes();
        repo = new Repositorio();
        img_center = repo.getMageStatic();

        // estado de mago---> true=vivo y false=muerto
        this.estado=true;

        //Posicion del mago en el entorno
        this.x = 0;
        this.y = 0;

        //direccion del mago
        this.direccion=true;
    }
    //-----------------------------------------------GETTERS------------------------------------//
    public double getXPos() {return this.x;}
    public double getYPos() {return this.y;}
    public boolean getEstado() {return this.estado;}
    public boolean getDireccion(){return this.direccion;}
    //-----------------------------------------------SETTERS------------------------------------//
    public boolean setEstado(boolean a){return this.estado = a;}
    public void setPos(double x,double y){this.x=x; this.y=y;}
    //-----------------------------------------------METODOS------------------------------------//
    /**Validaciones**/
    /*Delimitadores de mapa*/
    //Valida si se llego al fin del mapa
    public boolean finMapa(){boolean retorno = (this.x>=750) ?  true : false ; return retorno;}

    //Valida si se llego al inicio del mapa
    public boolean inicioMapa(){boolean retorno = (this.x<=50) ? true : false; return retorno;}

    //Verifica si esta sobre una viga
    public boolean estaSobreViga() {return constantes.tienePiso(this.x, this.y);}

    /**Utilidad**/
    public void girar(double modificador){this.angulo = this.angulo + modificador;}

    /*Metodos de caminar*/
    public void caminarDerecha() {
        if (constantes.tienePiso(this.x, this.y) && !finMapa()) {
            this.x += 2;
            this.y += 0;
        }
        else if(!constantes.tienePiso(this.x,this.y) && !finMapa()) {
            this.x += 1;
            this.y += 5;
        }
    }

    public void caminarIzquierda() {
        if (constantes.tienePiso(this.x,this.y) && !inicioMapa()) {
            this.x -= 2;
            this.y -= 0;
        }
        else if(!constantes.tienePiso(this.x,this.y) && !inicioMapa()) {
            this.x -= 1;
            this.y += 5;
        }
    }

    public void movimientoContinuo(Entorno entorno){
        if (!finMapa()) {
            if (entorno.sePresiono(entorno.TECLA_DERECHA)) {
                direccion = true; // true---> camina a la derecha
            }
        }else {direccion=false;}

        if (!inicioMapa()) {
            if (entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
                direccion = false; // false---> camina a la izquierda
            }
        }else {direccion=true;}

        if (direccion){caminarDerecha();} else{caminarIzquierda();}
    }
    //Vuelve al principio del juego, reapareciendo en la parte superior del mapa
    public void aparecerArriba(){
        if (constantes.caerPozo(this.x,this.y)){
            this.y = 0;
        }
    }

    /*Dibujar mago en el entorno*/
    /*
    El direccion que toma de parametro es la direccion en la que camina el mago.
    true---> derecha      false------> izquierda*/
    public void dibujarMago(Entorno entorno,int ms) {
        //Dibuja el mago dependiendo el tiempo en el que se encuentra
        if(constantes.caerPozo(this.x,this.y)){aparecerArriba();}
        else if (constantes.tienePiso(this.x, this.y) && direccion) {
            if (ms <= 3) {
                entorno.dibujarImagen(repo.getMageRight()[0], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 6) {
                entorno.dibujarImagen(repo.getMageRight()[1], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 9) {
                entorno.dibujarImagen(repo.getMageRight()[2], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 12) {
                entorno.dibujarImagen(repo.getMageRight()[3], this.x, this.y, this.angulo, 0.20);
            } else if (ms <= 15) {
                entorno.dibujarImagen(repo.getMageRight()[4], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 18) {
                entorno.dibujarImagen(repo.getMageRight()[5], this.x, this.y, this.angulo, 0.20);
            } else if (ms <= 21) {
                entorno.dibujarImagen(repo.getMageRight()[6], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 24) {
                entorno.dibujarImagen(repo.getMageRight()[7], this.x, this.y, this.angulo, 0.20);
            }
        }
        else if (!constantes.tienePiso(this.x, this.y) && direccion) {
            entorno.dibujarImagen(img_center, this.x, this.y, this.angulo, 0.20);
        }
        else if(!constantes.tienePiso(this.x,this.y) && !direccion){
            entorno.dibujarImagen(repo.getMageLeft()[0],this.x,this.y,this.angulo,0.20);
        }
        else if (constantes.tienePiso(this.x, this.y) && !direccion) {
            if (ms <= 3) {
                entorno.dibujarImagen(repo.getMageLeft()[0], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 6) {
                entorno.dibujarImagen(repo.getMageLeft()[1], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 9) {
                entorno.dibujarImagen(repo.getMageLeft()[2], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 12) {
                entorno.dibujarImagen(repo.getMageLeft()[3], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 15) {
                entorno.dibujarImagen(repo.getMageLeft()[4], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 18) {
                entorno.dibujarImagen(repo.getMageLeft()[5], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 21) {
                entorno.dibujarImagen(repo.getMageLeft()[6], this.x, this.y, this.angulo, 0.20);
            }else if (ms <= 24) {
                entorno.dibujarImagen(repo.getMageLeft()[7], this.x, this.y, this.angulo, 0.20);
            }
        }
        else if (!constantes.tienePiso(this.x, this.y) && !direccion) {
            entorno.dibujarImagen(this.img_center, this.x, this.y, this.angulo, 0.10);
        }
    }
}