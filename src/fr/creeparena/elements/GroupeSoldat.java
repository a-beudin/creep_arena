package fr.creeparena.elements;

import fr.creeparena.elements.Soldat;
import java.util.LinkedList;

// collection de soldats
public class GroupeSoldat extends Groupe {
    private LinkedList<Soldat> soldats = new LinkedList();
    
    public void ajouterSoldat(Soldat soldat) {
        soldats.add(soldat);
    }
    
    public LinkedList<Soldat> getSoldats() {
        return soldats;
    }
}
