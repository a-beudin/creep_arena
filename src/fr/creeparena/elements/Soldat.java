package fr.creeparena.elements;

import fr.creeparena.elements.actions.DetectionDistant;
import fr.creeparena.jeu.Config;
import fr.creeparena.util.Direction;

// classe mère des soldats
public abstract class Soldat extends Element {
    
    private Direction direction;
    private int attente;
    
    public Soldat(int totalVie, int degats, int x, int y){
        vie=totalVie;
        this.taille=1;
        this.degats=degats;
        this.x=x;
        this.y=y;
        this.portee = Config.PORTEE_SOLDAT;
        detection = new DetectionDistant();
    }
    
    public Batiment detecterBatiment(GroupeBatiment batiments) {
        return detection.detecterBatiment(batiments, x, y, portee);
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    
    public void setAttente(int a) {
        attente = a;
    }
    
    public int getAttente() {
        return attente;
    }
}
