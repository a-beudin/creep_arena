package fr.creeparena.grille;

import fr.creeparena.util.Coordonnee;

public class Case {
    
    public final Coordonnee COORDONNEE;
    public final double X;
    public final double Y;
    private boolean libre = true;
    
    public Case(Coordonnee c) {
        COORDONNEE = c;
        X = c.getX();
        Y = c.getY();
    }
    
    public boolean estLibre() {
        return libre;
    }
    
    public void setOccuppee(){
        libre = false;
    }
    
    public void setLibre() {
        libre = true;
    }
    
    public String toString() {
        return "Coordonnees :" + COORDONNEE.toString() + "\n";
    }
}
