package fr.creeparena.elements.actions;

import fr.creeparena.elements.Element;

public class CombatMelee implements Combat {
    public void attaquer(Element cible, int degats){
        // méthode d'attaque en mélée
        cible.subir(degats);
    }
}
