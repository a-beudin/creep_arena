package fr.creeparena.elements.actions;

import fr.creeparena.elements.Element;

public class CombatDistant implements Combat {
    public void attaquer(Element cible, int degats){
        // méthode d'attaque à distance
        cible.subir(degats);
    }
}
