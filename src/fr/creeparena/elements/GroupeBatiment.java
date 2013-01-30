package fr.creeparena.elements;

import fr.creeparena.elements.Batiment;
import java.util.LinkedList;

// collection de bâtiments
public class GroupeBatiment extends Groupe {
    private LinkedList<Batiment> batiments = new LinkedList();
    
    public void ajouterBatiment(Batiment batiment) {
        batiments.add(batiment);
    }
    
    public LinkedList<Batiment> getBatiments() {
        return batiments;
    }
}
