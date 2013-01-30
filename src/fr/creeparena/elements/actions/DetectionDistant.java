package fr.creeparena.elements.actions;

import fr.creeparena.elements.*;
import fr.creeparena.elements.Armee;
import fr.creeparena.elements.GroupeSoldat;
import fr.creeparena.elements.GroupeBatiment;

public class DetectionDistant implements Detection {
    
    public Soldat detecterSoldat(Armee armee, int x, int y, int portee) {
        for (GroupeSoldat groupe : armee.getGroupes()){
            for (Soldat ennemi : groupe.getSoldats()){
                if (ennemi.estVivant()){
                    int dx = Math.abs(x - ennemi.getX());
                    int dy = Math.abs(y - ennemi.getY());
                    double distance = Math.sqrt(dx*dx + dy*dy);
                    if (distance <= portee) {
                        return ennemi;
                    }
                }
            }
        }
        return null;
    }
    
    public Batiment detecterBatiment(GroupeBatiment batiments, int x, int y, int portee) {
        for (Batiment batiment : batiments.getBatiments()){
            if (batiment.estVivant()){
                int dx = Math.abs(x - batiment.getX());
                int dy = Math.abs(y - batiment.getY());
                double distance = Math.sqrt(dx*dx + dy*dy);
                if (distance <= portee) {
                    return batiment;
                }
            }
        }
        return null;
    }
}
