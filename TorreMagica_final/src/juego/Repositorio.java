package juego;

import javax.sound.sampled.*;
import java.io.File;
import java.awt.Image;
import entorno.Herramientas;

/**Repositorio de direcciones de imagenes para el juego**/
/**Tambien pensado para almacenar las direcciones de audio**/
public class Repositorio {
	//Fondo del juego
	private Image background;
	//Mago - posicion estatica
	private Image mageStatic;
	//Mago - Lado derecho
	private Image mageR_0;
	private Image mageR_1;
	private Image mageR_2;
	private Image mageR_3;
	private Image mageR_4;
	private Image mageR_5;
	private Image mageR_6;
	private Image mageR_7;
	//Armo un array y almaceno los sprites de movimiento
	private Image[] mageRight = new Image[8];
	//Mago - Lado Izquierdo
	private Image mageL_0;
	private Image mageL_1;
	private Image mageL_2;
	private Image mageL_3;
	private Image mageL_4;
	private Image mageL_5;
	private Image mageL_6;
	private Image mageL_7;
	//Armo un array y almaceno los sprites de movimiento
	private Image[] mageLeft = new Image[8];
	//Npc - estatico
	private Image npcStatic;
	//Npc - Lado derecho
	private Image npcR_0;
	private Image npcR_1;
	private Image npcR_2;
	private Image npcR_3;
	private Image npcR_4;
	private Image npcR_5;
	private Image npcR_6;
	private Image npcR_7;
	private Image[] npcRight = new Image[8];
	//Npc - Lado Izquierdo
	private Image npcL_0;
	private Image npcL_1;
	private Image npcL_2;
	private Image npcL_3;
	private Image npcL_4;
	private Image npcL_5;
	private Image npcL_6;
	private Image npcL_7;
	private Image[] npcLeft = new Image[8];
	//Spell
	private Image ice_spell;
	private Image fire_spell;
	private Image arcane_spell;
	private Image frozenEffect0;
	private Image frozenEffect1;
	private Image[] frozenEffect = new Image[3];
	//Barra de vida
	private Image health_full;
	private Image health_mid;
	private Image health_low;
	//Viga
	private Image viga_1;
	private Image viga_2;
	private Image viga_3;
	//Pared
	private Image brickWall;
	/**Constructor**/
	Repositorio(){
		//Background
		this.background = Herramientas.cargarImagen("sprites/ambient/background.jpg");
		//Mago - Estatico - 375x500
		this.mageStatic = Herramientas.cargarImagen("sprites/mage/idle_1.png");
		//Mago - derecha
		this.mageR_0 = Herramientas.cargarImagen("sprites/mage/run_1.png");
		this.mageR_1 = Herramientas.cargarImagen("sprites/mage/run_2.png");
		this.mageR_2 = Herramientas.cargarImagen("sprites/mage/run_3.png");
		this.mageR_3 = Herramientas.cargarImagen("sprites/mage/run_4.png");
		this.mageR_4 = Herramientas.cargarImagen("sprites/mage/run_5.png");
		this.mageR_5 = Herramientas.cargarImagen("sprites/mage/run_6.png");
		this.mageR_6 = Herramientas.cargarImagen("sprites/mage/run_7.png");
		this.mageR_7 = Herramientas.cargarImagen("sprites/mage/run_8.png");
		this.mageRight[0] = mageR_0;
		this.mageRight[1] = mageR_1;
		this.mageRight[2] = mageR_2;
		this.mageRight[3] = mageR_3;
		this.mageRight[4] = mageR_4;
		this.mageRight[5] = mageR_5;
		this.mageRight[6] = mageR_6;
		this.mageRight[7] = mageR_7;
		//Mago - izquierda
		this.mageL_0 = Herramientas.cargarImagen("sprites/mage/run_1L.png");
		this.mageL_1 = Herramientas.cargarImagen("sprites/mage/run_2L.png");
		this.mageL_2 = Herramientas.cargarImagen("sprites/mage/run_3L.png");
		this.mageL_3 = Herramientas.cargarImagen("sprites/mage/run_4L.png");
		this.mageL_4 = Herramientas.cargarImagen("sprites/mage/run_5L.png");
		this.mageL_5 = Herramientas.cargarImagen("sprites/mage/run_6L.png");
		this.mageL_6 = Herramientas.cargarImagen("sprites/mage/run_7L.png");
		this.mageL_7 = Herramientas.cargarImagen("sprites/mage/run_8L.png");
		this.mageLeft[0] = mageL_0;
		this.mageLeft[1] = mageL_1;
		this.mageLeft[2] = mageL_2;
		this.mageLeft[3] = mageL_3;
		this.mageLeft[4] = mageL_4;
		this.mageLeft[5] = mageL_5;
		this.mageLeft[6] = mageL_6;
		this.mageLeft[7] = mageL_7;
		//Npc - estatico
		this.npcStatic = Herramientas.cargarImagen("sprites/npcs/npc_idle.png");
		//Npc - derecha
		this.npcR_0 = Herramientas.cargarImagen("sprites/npcs/npcR_0.png");
		this.npcR_1 = Herramientas.cargarImagen("sprites/npcs/npcR_1.png");
		this.npcR_2 = Herramientas.cargarImagen("sprites/npcs/npcR_2.png");
		this.npcR_3 = Herramientas.cargarImagen("sprites/npcs/npcR_3.png");
		this.npcR_4 = Herramientas.cargarImagen("sprites/npcs/npcR_4.png");
		this.npcR_5 = Herramientas.cargarImagen("sprites/npcs/npcR_5.png");
		this.npcR_6 = Herramientas.cargarImagen("sprites/npcs/npcR_6.png");
		this.npcR_7 = Herramientas.cargarImagen("sprites/npcs/npcR_7.png");
		this.npcRight[0] = npcR_0;
		this.npcRight[1] = npcR_1;
		this.npcRight[2] = npcR_2;
		this.npcRight[3] = npcR_3;
		this.npcRight[4] = npcR_4;
		this.npcRight[5] = npcR_5;
		this.npcRight[6] = npcR_6;
		this.npcRight[7] = npcR_7;
		//Npc - izquierda
		this.npcL_0 = Herramientas.cargarImagen("sprites/npcs/npcL_0.png");
		this.npcL_1 = Herramientas.cargarImagen("sprites/npcs/npcL_1.png");
		this.npcL_2 = Herramientas.cargarImagen("sprites/npcs/npcL_2.png");
		this.npcL_3 = Herramientas.cargarImagen("sprites/npcs/npcL_3.png");
		this.npcL_4 = Herramientas.cargarImagen("sprites/npcs/npcL_4.png");
		this.npcL_5 = Herramientas.cargarImagen("sprites/npcs/npcL_5.png");
		this.npcL_6 = Herramientas.cargarImagen("sprites/npcs/npcL_6.png");
		this.npcL_7 = Herramientas.cargarImagen("sprites/npcs/npcL_7.png");
		this.npcLeft[0] = npcL_0;
		this.npcLeft[1] = npcL_1;
		this.npcLeft[2] = npcL_2;
		this.npcLeft[3] = npcL_3;
		this.npcLeft[4] = npcL_4;
		this.npcLeft[5] = npcL_5;
		this.npcLeft[6] = npcL_6;
		this.npcLeft[7] = npcL_7;
		//Spell
		this.ice_spell = Herramientas.cargarImagen("sprites/spells/ice_spell.png");
		this.fire_spell = Herramientas.cargarImagen("sprites/spells/fire_spell.png");
		this.arcane_spell = Herramientas.cargarImagen("sprites/spells/arcane_spell.png");
		this.frozenEffect0 = Herramientas.cargarImagen("sprites/spells/freeze1.png");
		this.frozenEffect1 = Herramientas.cargarImagen("sprites/spells/freeze2.png");
		this.frozenEffect[0] = frozenEffect0;
		this.frozenEffect[1] = frozenEffect1;
		//Barra de vida
		this.health_full = Herramientas.cargarImagen("sprites/mage/health3.png");
		this.health_mid = Herramientas.cargarImagen("sprites/mage/health2.png");
		this.health_low = Herramientas.cargarImagen("sprites/mage/health1.png");
		//Vigas
		this.viga_1 = Herramientas.cargarImagen("sprites/ambient/Viga1.png");
		this.viga_2 = Herramientas.cargarImagen("sprites/ambient/Viga2.png");
		this.viga_3 = Herramientas.cargarImagen("sprites/ambient/Viga3.png");
		//Pared
		this.brickWall = Herramientas.cargarImagen("sprites/ambient/brickWall.png");
	}
	//-----------------------------------------------GETTERS------------------------------------//
	//Background
	public Image getBackground(){return this.background;}
	//Mage - static
	public Image getMageStatic(){return this.mageStatic;}
	//Mage - Right
	public Image[] getMageRight(){return this.mageRight;}
	//Mage - Left
	public Image[] getMageLeft(){return this.mageLeft;}
	//Npc - static
	public Image getNPCStatic(){return this.npcStatic;}
	//Npc - Right
	public Image[] getNPCRight(){return this.npcRight;}
	//Npc - Left
	public Image[] getNPCLeft(){return this.npcLeft;}
	//Spell
	public Image getIce_Spell(){return this.ice_spell;}
	public Image getFire_Spell(){return this.fire_spell;}
	public Image getArcane_Spell(){return this.arcane_spell;}
	public Image[] getFreeze(){return this.frozenEffect;}
	//Barra de vida 
	public Image getHealth_Full(){return this.health_full;}
	public Image getHealth_Mid(){return this.health_mid;}
	public Image getHealth_Low(){return this.health_low;}
	//Vigas 
	public Image getViga_1(){return this.viga_1;}
	public Image getViga_2(){return this.viga_2;}
	public Image getViga_3(){return this.viga_3;}
	//Pared 
	public Image getBrickWall(){return this.brickWall;}
	
	//------------------------------------SONIDO---------------------------------------------
	//Metodo para leer un archivo .wav desde una direccion especifica
    public Clip getSound(String file){
        try{
        	//Creo el objeto AudioImputStream y cargo la direccion donde se alojan los audios
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\sounds" + System.getProperty("file.separator") + file).getAbsoluteFile());
            //Obtengo el formato de los audios
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            //Casteo el audio en un objeto de tipo Clip
            Clip sound = (Clip)AudioSystem.getLine(info);
            //Abro e inicializo el audio pasado por parametro 
            sound.open(audioInputStream);
            return sound;
        }
        catch(Exception e){return null;}
    }
    //Metodo para reproducir el audio que se cargo previamente
    public void playSound(Clip clip) {
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }
}

