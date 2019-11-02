package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;

import javax.sound.sampled.Clip;
import java.awt.*;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno; 
    private Constantes constantes;
    private Repositorio repo;
    private Image img;

    // Vigas
    private Viga viga1;
    private Viga viga2;
    private Viga viga3;
    private Viga viga4;
    private Viga viga5;
    private Viga viga6;
    private Viga viga7;
    private Viga viga8;
    private Viga viga9;
    //Pared
    private Viga pared;

    // Mago, Vida y su spell
    private Mago mago;
    private Spell spell;
    private boolean spellDireccion;
    private Vida vidas;
    // cuenta las vidas del mago.
    private int contVidas; 
    
    // Npcs
    private NPC npc_0 = new NPC();
    private NPC npc_1 = new NPC();
    private NPC npc_2 = new NPC();
    private NPC npc_3 = new NPC();

    // HitBox
    private Hitbox boxMago;
    private Hitbox boxNpc_0;
    private Hitbox boxNpc_1;
    private Hitbox boxNpc_2;
    private Hitbox boxNpc_3;
    private Hitbox boxSpell;

    //Clip 
    private Clip sound;

    // Establezco timers.

    int tiempo;//------------->Para fotogramas de las animaciones

    //Tiempos de congelamiento de los NPC.
    int tiempoCongelado_0;
    int tiempoCongelado_1;
    int tiempoCongelado_2;
    int tiempoCongelado_3;

    double escala = 0.40;

    //Validacion va a cambiar los valores de las banderas. Ver mas abajo en el codigo.

    int validacion_spell; //verifica cuando ejecutar el sonido del spell.
    int contKills;

    // CORRESPONDE A LA DIRECCION DEL MAGO true--->derecha y false---->izquierda
    boolean direccion;

    int cont_npc_0;
    int cont_npc_1;
    int cont_npc_2;
    int cont_npc_3;

    /** Constructor **/
    Juego() {
        /* Inicializacion de objetos */
        constantes = new Constantes();
        repo = new Repositorio();
        img = repo.getBackground();
        
        // Vigas
        viga1 = new Viga();
        viga1.setPos(constantes.getXPos_3(), constantes.getYPos_1());
        viga1.setDimensiones(constantes.getAnchoOthers(), 0, escala);
        viga1.setImage(repo.getViga_1());
        
        viga2 = new Viga();
        viga2.setPos(constantes.getXPos_1(), constantes.getYPos_2());
        viga2.setDimensiones(constantes.getAnchoOthers(), 0, escala);
        viga2.setImage(repo.getViga_1());
        
        viga3 = new Viga();
        viga3.setPos(constantes.getXPos_5(), constantes.getYPos_2());
        viga3.setDimensiones(constantes.getAnchoOthers(), 0, escala);
        viga3.setImage(repo.getViga_1());
        
        viga4 = new Viga();
        viga4.setPos(constantes.getXPos_3(), constantes.getYPos_3());
        viga4.setDimensiones(constantes.getAnchoOthers(), 0, escala);
        viga4.setImage(repo.getViga_1());
        
        viga5 = new Viga();
        viga5.setPos(constantes.getXPos_3(), constantes.getYPos_4());
        viga5.setDimensiones((constantes.getAnchoOthers() * 2), 0, escala);
        viga5.setImage(repo.getViga_3());
        
        viga6 = new Viga();
        viga6.setPos(constantes.getXPos_1(), constantes.getYPos_5());
        viga6.setDimensiones((constantes.getAnchoOthers() / 2), 0, escala);
        viga6.setImage(repo.getViga_2());
        
        viga7 = new Viga();
        viga7.setPos(constantes.getXPos_5(), constantes.getYPos_5());
        viga7.setDimensiones((constantes.getAnchoOthers() / 2), 0, escala);
        viga7.setImage(repo.getViga_2());
        
        viga8 = new Viga();
        viga8.setPos(constantes.getXPos_1(), constantes.getYPos_6());
        viga8.setDimensiones(constantes.getAnchoOthers(), 0, escala);
        viga8.setImage(repo.getViga_1());
        
        viga9 = new Viga();
        viga9.setPos(constantes.getXPos_5(), constantes.getYPos_6());
        viga9.setDimensiones(constantes.getAnchoOthers(), 0, escala);
        viga9.setImage(repo.getViga_1());

        //Pared
        pared = new Viga();
        pared.setImage(repo.getBrickWall());

        // Mago y unos npcs
        mago = new Mago(); mago.setPos(400, 60);
        spell = new Spell();
        spellDireccion=true;
        vidas = new Vida();
        contVidas = 0;

        npc_0.setPos(100,100);
        npc_1.setPos(60,120);
        npc_2.setPos(720,120);
        npc_3.setPos(700, 330);

        // Validacion del audio_spell
        validacion_spell = 0;

        //contador de eliminaciones.
        contKills = 0;

        //Inicializo los hitbox para usarlos en las posiciones iniciales de mago y npc para luego calcular su interseccion

        boxMago = new Hitbox(); boxMago.setPos(mago.getXPos(), mago.getYPos());
        boxNpc_0 = new Hitbox(); boxNpc_0.setPos(npc_0.getXPos(),npc_0.getYPos());
        boxNpc_1 = new Hitbox(); boxNpc_1.setPos(npc_1.getXPos(),npc_1.getYPos());
        boxNpc_2 = new Hitbox(); boxNpc_2.setPos(npc_2.getXPos(),npc_2.getYPos());
        boxNpc_3 = new Hitbox(); boxNpc_3.setPos(npc_3.getXPos(),npc_3.getYPos());
        boxSpell = new Hitbox(); boxSpell.setPos(spell.getXPos(),spell.getYPos());

        //Tick en ms
        tiempo = 0;
        tiempoCongelado_0 = 0;
        tiempoCongelado_1 = 0;
        tiempoCongelado_2 = 0;
        tiempoCongelado_3 = 0;

        //Contador de score.
        cont_npc_0=0;
        cont_npc_2=0;
        cont_npc_2=0;
        cont_npc_3=0;

        // DIRECCION MAGO SEGUN SI SE PRESIONO TECLA DERECHA O IZQUIERDA:
        direccion = true; // mago inicia caminando hacia la derecha por que esta en true

        this.entorno = new Entorno(this, "Torre Mágica - Team UNO - Belgoff - Mierez - Torresel - V1.12.a", constantes.getAnchoPantalla(), constantes.getAltoPantalla());

        // Inicia el juego!
        this.entorno.iniciar();

        sound = repo.getSound("Audio_game.wav"); //Musica ambiental del juego.
        repo.playSound(sound);
    }


    /**Metodo Tick: es el encargado de hacer que funcione el juego**/

    public void tick() {

        //Dibujamos el fondo de pantalla
        entorno.dibujarImagen(img, 400, 300, 0, 1);

        //Temporizador para los fotogramas del mago//npcs//spell
        if (tiempo < 24) {
            tiempo++;
        } else {
            tiempo = 0;
        }

        //Dibujar vigas en entorno
        //Nota: se habia pensado hacer un array el cual contuviese las vigas creadas para el entorno
        //La idea se deprecÃ³ ya que nos complicaba algunas cosas con respecto al funcionamiento
        //general del juego.
        viga1.dibujarViga(entorno);
        viga2.dibujarViga(entorno);
        viga3.dibujarViga(entorno);
        viga4.dibujarViga(entorno);
        viga5.dibujarViga(entorno);
        viga6.dibujarViga(entorno);
        viga7.dibujarViga(entorno);
        viga8.dibujarViga(entorno);
        viga9.dibujarViga(entorno);
        pared.dibujarPared(entorno);
        
        //Movimiento del mago
        mago.movimientoContinuo(entorno);

        // muevo los hitbox en la nueva posicion en la que se encuentran los magos y los npc:
        boxMago.move(mago.getXPos(), mago.getYPos());
        boxNpc_0.move(npc_0.getXPos(), npc_0.getYPos());
        boxNpc_1.move(npc_1.getXPos(), npc_1.getYPos());
        boxNpc_2.move(npc_2.getXPos(), npc_2.getYPos());
        boxNpc_3.move(npc_3.getXPos(), npc_3.getYPos());
        boxSpell.move(spell.getXPos(),spell.getYPos());
//________________________________________________________________________________________________________________________________________

        if (contVidas <= 2) {
            vidas.dibujarVidas(entorno, mago.getXPos(), mago.getYPos() - 50);
        }
        // ESTADO DE LOS NCP y MAGO:

        //---------------------------------------NPC_0-------------------------------------------

        if (boxSpell.hit(boxSpell.area(), boxNpc_0.area())){  //------> Verifica que haya colision y entre spell y npc.
            npc_0.setCongelado(true);
        }
        if(npc_0.getCongelado()){      //---------------> Determina un tiempo de congelamiento del NPC.
            tiempoCongelado_0++;
            if(tiempoCongelado_0>=0 && tiempoCongelado_0<=1){
                sound = repo.getSound("Audio_spell_hit.wav");
                repo.playSound(sound);
            }
            if(tiempoCongelado_0>300){
                    npc_0.setCongelado(false);
                    npc_0.setGolpeFinal(false);
                    tiempoCongelado_0 = 0;
            }
        }

        //---------------------------------------NPC_1-------------------------------------------
        if (boxSpell.hit(boxSpell.area(), boxNpc_1.area())){
            npc_1.setCongelado(true);
        }
        if(npc_1.getCongelado()){
            tiempoCongelado_1++;
            if(tiempoCongelado_1>=0 && tiempoCongelado_1<=1){
                sound = repo.getSound("Audio_spell_hit.wav");
                repo.playSound(sound);
            }
            if(tiempoCongelado_1>300){
                npc_1.setCongelado(false);
                npc_1.setGolpeFinal(false);
                tiempoCongelado_1 = 0;
            }
        }

        //---------------------------------------NPC_2-------------------------------------------
        if (boxSpell.hit(boxSpell.area(), boxNpc_2.area())){
            npc_2.setCongelado(true);
        }
        if(npc_2.getCongelado()){
            tiempoCongelado_2++;
            if(tiempoCongelado_2>=0 && tiempoCongelado_2<=1){
                sound = repo.getSound("Audio_spell_hit.wav");
                repo.playSound(sound);
            }
            if(tiempoCongelado_2>300){
                npc_2.setCongelado(false);
                npc_2.setGolpeFinal(false);
                tiempoCongelado_2 = 0;
            }
        }

        //---------------------------------------NPC_3-------------------------------------------
        if (boxSpell.hit(boxSpell.area(), boxNpc_3.area())){
            npc_3.setCongelado(true);
        }
        if(npc_3.getCongelado()){
            tiempoCongelado_3++;
            if(tiempoCongelado_3>=0 && tiempoCongelado_3<=1){
                sound = repo.getSound("Audio_spell_hit.wav");
                repo.playSound(sound);
            }
            if(tiempoCongelado_3>300){
                npc_3.setCongelado(false);
                npc_3.setGolpeFinal(false);
                tiempoCongelado_3 = 0;
            }
        }


        //---------------------------------------NPC_0 - Colision con mago-------------------------------------------

        //Si esta congelado y el mago lo toca estado de npc.congelado = true
        if (npc_0.getCongelado() && boxMago.hit(boxMago.area(),boxNpc_0.area())){           
            npc_0.setGolpeFinal(true);
        }
        //Si el mago toca al npc pero no esta congelado resta vida.
        else if (boxMago.hit(boxMago.area(), boxNpc_0.area()) && !npc_0.getCongelado()) {   
        	contVidas++;
            sound = repo.getSound("Audio_mage_hit.wav");
            repo.playSound(sound);

            if (contVidas == 1) {                                                                
                vidas.cambiar(2);                                                        
                mago.setPos(constantes.getXPos_3(), constantes.getYPos_1() - 100);       
                mago.dibujarMago(entorno, tiempo);                                          
            } else if (contVidas == 2) {                                                         
                vidas.cambiar(1);                                                        
                mago.setPos(400, 100);                                                
                mago.dibujarMago(entorno, tiempo);                                          
            }
        }

        //---------------------------------------NPC_1 - Colision con mago-------------------------------------------
        if (npc_1.getCongelado() && boxMago.hit(boxMago.area(),boxNpc_1.area())){
            npc_1.setGolpeFinal(true);
        }
        
        else if (boxMago.hit(boxMago.area(), boxNpc_1.area()) && !npc_1.getCongelado()) {   
        	contVidas++;
            sound = repo.getSound("Audio_mage_hit.wav");
            repo.playSound(sound);
            if (contVidas == 1) {                                                                
                vidas.cambiar(2);                                                        
                mago.setPos(constantes.getXPos_3(), constantes.getYPos_1() - 100);       
                mago.dibujarMago(entorno, tiempo);                                          
            } else if (contVidas == 2) {                                                         
                vidas.cambiar(1);                                                       
                mago.setPos(400, 100);                                                
                mago.dibujarMago(entorno, tiempo);                                          
            }
        }

        //---------------------------------------NPC_2 - Colision con mago-------------------------------------------
        if (npc_2.getCongelado() && boxMago.hit(boxMago.area(),boxNpc_2.area())){
            npc_2.setGolpeFinal(true);                                                         
        }                                                                                   
        else if (boxMago.hit(boxMago.area(), boxNpc_2.area()) && !npc_2.getCongelado()) {   
        	contVidas++;
            sound = repo.getSound("Audio_mage_hit.wav");
            repo.playSound(sound);
            if (contVidas == 1) {                                                                
                vidas.cambiar(2);                                                        
                mago.setPos(constantes.getXPos_3(), constantes.getYPos_1() - 100);       
                mago.dibujarMago(entorno, tiempo);                                          
            } else if (contVidas == 2) {                                                         
                vidas.cambiar(1);                                                        
                mago.setPos(400, 100);                                                
                mago.dibujarMago(entorno, tiempo);                                          
            }
        }

        //---------------------------------------NPC_3 - Colision con mago-------------------------------------------
        if (npc_3.getCongelado() && boxMago.hit(boxMago.area(), boxNpc_3.area())) {
            npc_3.setGolpeFinal(true);                                                         
        } else if (boxMago.hit(boxMago.area(), boxNpc_3.area()) && !npc_3.getCongelado()) { 
        	contVidas++;
            sound = repo.getSound("Audio_mage_hit.wav");
            repo.playSound(sound);
            if (contVidas == 1) {                                                                
                vidas.cambiar(2);                                                        
                mago.setPos(constantes.getXPos_3(), constantes.getYPos_1() - 100);       
                mago.dibujarMago(entorno, tiempo);                                          
            } else if (contVidas == 2) {                                                         
                vidas.cambiar(1);                                                        
                mago.setPos(400, 100);                                                
                mago.dibujarMago(entorno, tiempo);                                          
            }
        }
//__________________________________________________________________________________________________________________________________
        //Dibujar mago y Npcs en el entorno
        npc_0.dibujarNPC(entorno, tiempo);
        npc_1.dibujarNPC(entorno, tiempo);
        npc_2.dibujarNPC(entorno, tiempo);
        npc_3.dibujarNPC(entorno, tiempo);
//________________________________________________________________________________________________________________________________________
        // MAGO LANZA SPELL SEGUN LA DIRECCION QUE SE GUARDA EN EL BOOLEANO SPELLDIRECCION
        if (!mago.estaSobreViga()) {
            spellDireccion=mago.getDireccion();
            spell.reset(entorno,mago.getXPos(),mago.getYPos());
            validacion_spell = 1;
        }
        else if(mago.estaSobreViga() && validacion_spell==1){
            //play sound spell
            sound = repo.getSound("Audio_spell.wav");
            repo.playSound(sound);
            validacion_spell = 0;
        }

        else{spell.mover(entorno, spellDireccion);
            spell.dibujarSpell(entorno, tiempo);
        }


        //-------------------------------------------Control de Score------------------------------------------------------------

        if(!npc_0.getEstado()){
            cont_npc_0 = 1;
        }
        if(!npc_1.getEstado()){
            cont_npc_1 = 1;
        }
        if(!npc_2.getEstado()){
            cont_npc_2 = 1;
        }
        if(!npc_3.getEstado()){
            cont_npc_3 = 1;
        }

        if(cont_npc_0 ==1 && cont_npc_1 ==1 && cont_npc_2 ==1 && cont_npc_3 ==1){
            contKills = cont_npc_0+cont_npc_1+cont_npc_2+cont_npc_3;
        }

        if(cont_npc_0 ==1 || cont_npc_1 ==1 || cont_npc_2 ==1 || cont_npc_3 ==1){
            contKills = cont_npc_0+cont_npc_1+cont_npc_2+cont_npc_3;
        }
        entorno.cambiarFont("Arial", 40, Color.red);
        entorno.escribirTexto("Score:", 25, 25);
        entorno.cambiarFont("Arial", 40, Color.white);
        entorno.escribirTexto(String.valueOf(contKills), 150, 25);


//_________________________________________________________________________________________________________________________________________
        // DIBUJO EL MAGO SI LAS VIDAS SON MENORES O IGUALES QUE 3:
        if (contVidas<=3){
            mago.dibujarMago(entorno, tiempo);
        }
        else{
            boxMago.setAlto(0);
            boxMago.setAncho(0);
            mago.setPos(400,600);
        	entorno.cambiarFont("Arial", 70, Color.red);
            entorno.escribirTexto("GAME OVER", 195, 280);
            entorno.cambiarFont("Arial", 35, Color.red);
            entorno.escribirTexto("Presione tecla INS para continuar", 160, 380);

            if(entorno.estaPresionada(entorno.TECLA_INSERT)){ //---------->reinicio variables de insntacia para volver a empezar.(Reinicio del juego) Si el mago se queda sin vidas.

                vidas = new Vida();

                contKills = 0;

                cont_npc_0 = 0;
                cont_npc_1 = 0;
                cont_npc_2 = 0;
                cont_npc_3 = 0;

                mago.setPos(400, 60);
                mago.setEstado(true);

                boxMago.setAncho(50);
                boxMago.setAlto(40);

                npc_0.setPos(100,100);
                npc_1.setPos(60,120);
                npc_2.setPos(720,120);
                npc_3.setPos(700, 330);

                npc_0.setEstado(true);
                npc_1.setEstado(true);
                npc_2.setEstado(true);
                npc_3.setEstado(true);

                npc_0.setCongelado(false);
                npc_1.setCongelado(false);
                npc_2.setCongelado(false);
                npc_3.setCongelado(false);

                contVidas=0;
            }
        }

        if(contKills==4){
            if(entorno.estaPresionada(entorno.TECLA_INSERT)){ //---------->reinicio variables de insntacia para volver a empezar. Si se acabaron los NPC

                vidas = new Vida();

                contKills = 0;

                cont_npc_0 = 0;
                cont_npc_1 = 0;
                cont_npc_2 = 0;
                cont_npc_3 = 0;

                mago.setPos(400, 60);
                mago.setEstado(true);

                boxMago.setAncho(50);
                boxMago.setAlto(40);

                npc_0.setPos(100,100);
                npc_1.setPos(60,120);
                npc_2.setPos(720,120);
                npc_3.setPos(700, 330);

                npc_0.setEstado(true);
                npc_1.setEstado(true);
                npc_2.setEstado(true);
                npc_3.setEstado(true);

                npc_0.setCongelado(false);
                npc_1.setCongelado(false);
                npc_2.setCongelado(false);
                npc_3.setCongelado(false);

                contVidas=0;

            }
            entorno.cambiarFont("Arial", 70, Color.red);
            entorno.escribirTexto("WIN", 320, 280);
            entorno.cambiarFont("Arial", 35, Color.red);
            entorno.escribirTexto("Presione tecla INS para continuar", 160, 380);

        }

    }


//_________________________________________________________________________________________________________________________________
    /* Main Program */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();

    }
}