package fr.creeparena.elements;

import java.util.LinkedList;

// l'armée regroupe les groupes de soldats de la même équipe
public class Armee extends Groupe {
    private LinkedList<GroupeSoldat> groupes = new LinkedList();
    
    public void ajouterGroupe(GroupeSoldat groupe) {
        groupes.add(groupe);
    }
    
    public LinkedList<GroupeSoldat> getGroupes() {
        return groupes;
    }
}
