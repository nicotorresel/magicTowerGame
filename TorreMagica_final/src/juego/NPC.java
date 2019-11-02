package juego;

import entorno.Entorno;

public class NPC {
    private Constantes constantes;
    private Repositorio repo;
    private double x,y;
    private double angulo;
    private boolean estado;
    private boolean congelado;
    private boolean direccion;
    private boolean golpeFinal;

    /**Constructor**/
    public NPC(){
        constantes = new Constantes();
        repo = new Repositorio();

        this.x = 0;
        this.y = 0;

        this.estado = true;
        this.congelado = false;
        this.golpeFinal=false;

        this.direccion = true;
    }
    //-----------------------------------------------GETTERS------------------------------------//
    public double getXPos(){return this.x;}
    public double getYPos(){return this.y;}
    public boolean getCongelado(){return this.congelado;}
    public boolean getEstado(){return this.estado;}
    public boolean getDireccion(){return this.direccion;}
    public boolean getGolpeFinal() {return this.golpeFinal;}
    //-----------------------------------------------SETTERS------------------------------------//
    public void setPos(double x, double y){this.x = x; this.y = y;}
    public void setEstado(boolean estado){this.estado = estado;}
    public void setCongelado(boolean congelado){this.congelado = congelado;}
    public void setGolpeFinal(boolean golpeFinal) {this.golpeFinal=golpeFinal;}
    //-----------------------------------------------METODOS------------------------------------//
    /**Validaciones**/

    /*Delimitadores de mapa*/
    //Valida si se llego al inicio del mapa
    public boolean inicioMapa(){boolean retorno = (this.x<=50) ? true : false; return retorno;}

    //Valida si se llego al fin del mapa
    public boolean finMapa(){boolean retorno = (this.x>=750) ?  true : false ; return retorno;}

    //Verifica si esta sobre una viga
    public boolean estaSobreViga() {return constantes.tienePiso(this.x, this.y);}

    /**Utilidad**/
    public void girar(double modificador){this.angulo = this.angulo + modificador;}

    /*Movimiento del NPC*/
    public void caminarDerecha() {
        if (constantes.tienePiso(this.x, this.y) && !finMapa()) {
            this.x += 2;
            this.y += 0;
        }
        else if(!constantes.tienePiso(this.x,this.y) && !finMapa()) {
            this.x += 2;
            this.y += 5;
        }
        else if (!constantes.tienePiso(this.x,this.y) && finMapa()){
            this.x -= 2;
            this.y += 5;
        }
    }

    public void caminarIzquierda() {
        if (constantes.tienePiso(this.x,this.y) && !inicioMapa()) {
            this.x -= 2;
            this.y -= 0;
        }
        else if(!constantes.tienePiso(this.x,this.y) && !inicioMapa()) {
            this.x -= 2;
            this.y += 5;
        }
        else if (!constantes.tienePiso(this.x,this.y) && inicioMapa()){
            this.x += 2;
            this.y += 5;
        }
    }

    //Vuelve al principio del juego, reapareciendo en la parte superior del mapa
    public void aparecerArriba(){
        if (constantes.caerPozo(this.x,this.y) && !this.congelado){
            this.y = 0;
        }
        else if (constantes.caerPozo(this.x,this.y) && this.congelado){
            this.estado = false;
        }
    }

    public void dibujarNPC(Entorno entorno,int ms) {
        if (!this.congelado && this.estado){
        //Asigna movimiento al npc si es que no esta congelado, si esta congelado se queda quieto.
        	movimiento();           
        }
        else if (this.congelado && this.getGolpeFinal()){
            walkToDeath();
        }
        //Si el npc cae al pozo aparece arriba
        if(constantes.caerPozo(this.x,this.y) && this.estado && !this.congelado){      
            aparecerArriba();
        }
        else if (constantes.caerPozo(this.x,this.y) && this.congelado){
            this.estado=false;
        }

        // SI TIENE PISO, ESTA VIVO Y NO ESTA CONGELADO LO DIBUJA DE ACUERDO A LA DIRECCION DEL PARAMETRO
        //Determina que frames se van a mostrar segundo la direccion del npc.
        else if (constantes.tienePiso(this.x, this.y) && direccion && !this.congelado && this.estado) {
            if (ms <= 3) {
                entorno.dibujarImagen(repo.getNPCRight()[0], this.x, this.y, this.angulo, 1);
            } else if (ms <= 6) {
                entorno.dibujarImagen(repo.getNPCRight()[1], this.x, this.y, this.angulo, 1);
            } else if (ms <= 9) {
                entorno.dibujarImagen(repo.getNPCRight()[2], this.x, this.y, this.angulo, 1);
            } else if (ms <= 12) {
                entorno.dibujarImagen(repo.getNPCRight()[3], this.x, this.y, this.angulo, 1);
            } else if (ms <= 15) {
                entorno.dibujarImagen(repo.getNPCRight()[4], this.x, this.y, this.angulo, 1);
            } else if (ms <= 18) {
                entorno.dibujarImagen(repo.getNPCRight()[5], this.x, this.y, this.angulo, 1);
            } else if (ms <= 21) {
                entorno.dibujarImagen(repo.getNPCRight()[6], this.x, this.y, this.angulo, 1);
            } else if (ms <= 24) {
                entorno.dibujarImagen(repo.getNPCRight()[7], this.x, this.y, this.angulo, 1);
            }
        }
        // IDEM ANTERIOR
        //Determina que frames se van a mostrar segundo la direccion del npc.
        else if (constantes.tienePiso(this.x, this.y) && !direccion && !this.congelado && this.estado) {
            if (ms <= 3) {
                entorno.dibujarImagen(repo.getNPCLeft()[0], this.x, this.y, this.angulo, 1);
            } else if (ms <= 6) {
                entorno.dibujarImagen(repo.getNPCLeft()[1], this.x, this.y, this.angulo, 1);
            } else if (ms <= 9) {
                entorno.dibujarImagen(repo.getNPCLeft()[2], this.x, this.y, this.angulo, 1);
            } else if (ms <= 12) {
                entorno.dibujarImagen(repo.getNPCLeft()[3], this.x, this.y, this.angulo, 1);
            } else if (ms <= 15) {
                entorno.dibujarImagen(repo.getNPCLeft()[4], this.x, this.y, this.angulo, 1);
            } else if (ms <= 18) {
                entorno.dibujarImagen(repo.getNPCLeft()[5], this.x, this.y, this.angulo, 1);
            } else if (ms <= 21) {
                entorno.dibujarImagen(repo.getNPCLeft()[6], this.x, this.y, this.angulo, 1);
            } else if (ms <= 24) {
                entorno.dibujarImagen(repo.getNPCLeft()[7], this.x, this.y, this.angulo, 1);
            }
        }
        // SI NO ESTA EN EL PISO (ESTA EN EL AIRE) Y NO ESTA CONGELADO Y ESTA VIVO:
        else if (!constantes.tienePiso(this.x, this.y)&& !this.congelado && this.estado) {
            entorno.dibujarImagen(repo.getNPCStatic(), this.x, this.y, this.angulo, 1);
        }

        // SI ESTA CONGELADO PERO ESTA VIVO DIBUJA LA IMAGEN DE CONGELADO:
        else if (this.congelado && this.estado && estaSobreViga()){
            entorno.dibujarImagen(repo.getFreeze() [0], this.x,this.y,this.angulo,1);
        }
        else if (this.congelado && this.estado && !estaSobreViga()){
            walkToDeath();
            entorno.dibujarImagen(repo.getFreeze() [0], this.x,this.y,this.angulo,1);
        }

    }

    public void movimiento(){
        int validacion = (int) (Math.random() * (1 - 0 + 1));
        //Movimiento hacia la derecha.
        if(estaSobreViga()){
            if(direccion){
                if(!finMapa()){
                    caminarDerecha();
                    if(finMapa()){
                        this.direccion =false;
                    }
                }
            }
            //Movimiento hacia la izq.
            else if(!direccion){
                if(!inicioMapa()){
                    caminarIzquierda();
                    if(inicioMapa()){
                        this.direccion=true;
                    }
                }
            }
        }
        //Toma de decision de proxima direccion mientras no esta sobre viga
        else if (direccion|| !direccion && !estaSobreViga()){
            caminarDerecha();
            caminarIzquierda();

            if ( validacion == 0){
                this.direccion = false;
            }
            else this.direccion = true;
        }
    }
    
    public void walkToDeath(){
        if(estaSobreViga()){
            if(direccion){
                if(!finMapa()){
                    caminarDerecha();
                    if(finMapa()){
                        this.direccion =false;
                    }
                }
            }
            else if(!direccion){
                if(!inicioMapa()){
                    caminarIzquierda();
                    if(inicioMapa()){
                        this.direccion=true;
                    }
                }
            }
        }
        else if (!direccion || direccion && !estaSobreViga()){
            if(!inicioMapa()){
                caminarIzquierda();         // Se utilizan ambas para q la caida sea vertical.
                caminarDerecha();           //
                if(inicioMapa()){
                    this.direccion=true;
                }
            }
        }
    }
}