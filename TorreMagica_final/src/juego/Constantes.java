package juego;

public class Constantes {
    //Delimitacion de la pantalla
    private int anchoPantalla;
    private int altoPantalla;
    //Y Axis
    private int y0;
    private int y1;
    private int y2;
    private int y3;
    private int y4;
    private int y5;
    private int y6;
    //X Axis
    private int x0;
    private int x1;
    private int x2;
    private int x3;
    private int x4;
    private int x5;
    private int x6;
    //Medidas para los Npcs y el mago
    private int ALTO_CHARACTERS;
    private int ANCHO_CHARACTERS;
    //Medidas para Vigas y Spells
    private double ALTO_OTHERS;
    private double ANCHO_OTHERS;

    /**Constructor**/
    Constantes(){
        /**Valores por defecto**/
        this.anchoPantalla = 800;
        this.altoPantalla = 600;
        //X Axis
        this.x0 = 0;
        this.x1 = this.anchoPantalla/6;
        this.x2 = this.x1*2;
        this.x3 = this.anchoPantalla/2;
        this.x4 = this.anchoPantalla-(this.anchoPantalla/3);
        this.x5 = this.anchoPantalla-(this.anchoPantalla/3)+(this.anchoPantalla/6);
        this.x6 = this.anchoPantalla;
        //Y Axis
        this.y0 = 0;
        this.y1 = this.altoPantalla/6;
        this.y2 = this.altoPantalla/3;
        this.y3 = this.altoPantalla/2;
        this.y4 = (this.altoPantalla/6)*4;
        this.y5 = (this.altoPantalla/6)*5;
        this.y6 = this.altoPantalla;
        //Mago y Npcs
        this.ALTO_CHARACTERS = 30;
        this.ANCHO_CHARACTERS = 30;
        //Vigas y Spells
        this.ALTO_OTHERS = 20;
        this.ANCHO_OTHERS = 266.66; //---> Esta = a this.x1 * 2.
    }
    //-----------------------------------------------GETTERS------------------------------------//
    //X Axis
    public int getXPos_0() {return this.x0;}
    public double getXPos_1() {return this.x1;}
    public int getXPos_2() {return this.x2;}
    public int getXPos_3() {return this.x3;}
    public int getXPos_4() {return this.x4;}
    public double getXPos_5() {return this.x5;}
    public int getXPos_6() {return this.x6;}

    //Y Axis
    public int getYPos_0() {return this.y0;}
    public int getYPos_1() {return this.y1;}
    public int getYPos_2() {return this.y2;}
    public int getYPos_3() {return this.y3;}
    public int getYPos_4() {return this.y4;}
    public int getYPos_5() {return this.y5;}
    public int getYPos_6() {return this.y6;}

    //Mago y Npcs
    public int getAltoCharacter() {return this.ALTO_CHARACTERS;}
    public int getAnchoCharacter() {return this.ANCHO_CHARACTERS;}
    //Viga y Spells
    public double getAnchoOthers(){return this.ANCHO_OTHERS;}
    public double getAltoOthers() {return this.ALTO_OTHERS;}
    //Limites de la pantalla
    public int getAnchoPantalla() {return this.anchoPantalla;}
    public int getAltoPantalla() {return this.altoPantalla;}
    //-----------------------------------------------SETTERS------------------------------------//
    //X Axis
    public void setXPos_1(int x1) {
        if(!validarAltura(x1)){
            throw new RuntimeException(x1 +" no esta entre los limites permitidos");
        }this.x1 = x1;
    }
    public void setXPos_2(int x2) {
        if(!validarAltura(x2)){
            throw new RuntimeException(x2 +" no esta entre los limites permitidos");
        }this.x2 = x2;
    }
    public void setXPos_3(int x3) {
        if(!validarAltura(x3)){
            throw new RuntimeException(x3 +" no esta entre los limites permitidos");
        }this.x3 = x3;
    }
    public void setXPos_4(int x4) {
        if(!validarAltura(x4)){
            throw new RuntimeException(x4 +" no esta entre los limites permitidos");
        }this.x4 = x4;
    }
    public void setXPos_5(int x5) {
        if(!validarAltura(x5)){
            throw new RuntimeException(x5 +" no esta entre los limites permitidos");
        }this.x5 = x5;
    }
    public void setXPos_6(int x6) {
        if(!validarAltura(x6)){
            throw new RuntimeException(x6 +" no esta entre los limites permitidos");
        }this.x6 = x6;
    }

    //Y Axis
    public void setYPos_1(int y1) {
        if(!validarAltura(y1)){
            throw new RuntimeException(y1 +" no esta entre los limites permitidos");
        }this.y1 = y1;
    }
    public void setYPos_2(int y2) {
        if(!validarAltura(y2)){
            throw new RuntimeException(y2 +" no esta entre los limites permitidos");
        }this.y2 = y2;
    }
    public void setYPos_3(int y3) {
        if(!validarAltura(y3)){
            throw new RuntimeException(y3 +" no esta entre los limites permitidos");
        }this.y3 = y3;
    }
    public void setYPos_4(int y4) {
        if(!validarAltura(y4)){
            throw new RuntimeException(y4 +" no esta entre los limites permitidos");
        }this.y4 = y4;
    }
    public void setYPos_5(int y5) {
        if(!validarAltura(y5)){
            throw new RuntimeException(y5 +" no esta entre los limites permitidos");
        }this.y5 = y5;
    }
    public void setYPos_6(int y6) {
        if(!validarAltura(y6)){
            throw new RuntimeException(y6 +" no esta entre los limites permitidos");
        }this.y6 = y6;
    }

    //-----------------------------------------------METODOS------------------------------------//
    /**Validaciones**/
    //Valida la altura del entorno
    private boolean validarAltura(int altura){
        if(altura>=0 && altura<=600)
            return true;
        return false;
    }
    
    //Valida el ancho del entorno
    @SuppressWarnings("unused")
	private boolean validarAncho(double ancho){
        if(ancho>=0 && ancho<=800)
            return true;
        return false;
    }
    //Devuelve verdadero si el NPC || Mago estan sobre una viga
    public boolean tienePiso(double x, double y) {
        if (y == this.y1-40 || y == this.y3-40) {
            if ( x>=this.x2 && x<=this.x4) {
                return true;
            }
        }
        else if (y == this.y2-40 || y == this.y6-40) {
            if (x>= this.x0-50 && x<= this.x2 || x>=x4 && x<=x6+50) {
                return true;
            }
        }
        else if (y == this.y4-40 && x<=this.x5 && x>=this.x1) {
            return true;
        }
        else if (y == this.y5-40 && x>=(this.x1-(this.x1/2)) && x<=(this.x1+(this.x1/2))
                || y==this.y5-40 && x>=(this.x5-(this.x1/2)) && x<=(this.x5+(this.x1/2))){
            return true;
        }
        return false;

    }
    //Devuelve true si el NPC || Mago caen por el pozo en el final del mapa
    public boolean caerPozo(double x, double y){
        if (x >= x0  && x<=x6 && y>=642)
            return true;
        return false;
    }
}