package fr.creeparena.elements;

import fr.creeparena.elements.actions.Detection;
import fr.creeparena.elements.actions.Combat;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

// classe mère des bâtiments et des soldats
public abstract class Element extends Parent{
    
    protected ImageView imageView;
    protected int x;
    protected int y;
    protected int portee;
    protected boolean vivant = true;
    protected int taille;
    protected int degats;
    protected int vie;
    protected Combat combat;
    protected Detection detection;
    
    public void subir(int degats){
        vie-=degats;
        if(vie<=0){
            detruire();
        }
    }
    
    // appelle la stratégie de détection associée à l'élément
    public Soldat detecterSoldat(Armee armeeEnnemie) {
        return detection.detecterSoldat(armeeEnnemie, this.x, this.y, this.portee);
    }
    
    // appelle la stratégie de combat associée à l'élément
    public void attaquer(Element cible){
        combat.attaquer(cible, this.degats);
    }
    
    public void detruire() {
        this.vivant = false;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
     public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getPortee() {
        return portee;
    }
    
    public int getVie(){
        return vie;
    }
    
    public boolean estVivant (){
        return vivant;
    }
    
    public int getTaille(){
        return taille;
    }
    
    public String toString() {
        String chaine = "Degats : " + degats + "\nVie : " + vie;
        return chaine;
    }
}
