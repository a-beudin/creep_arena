package fr.creeparena.elements.usine;

import fr.creeparena.elements.Mage;
import fr.creeparena.elements.Melee;
import fr.creeparena.elements.Soldat;

public class UsineSbire extends Usine {
    
    public Soldat creerSoldat(TypeSoldat type, int image, int x, int y) {
        Soldat soldat = null;
        switch(type) {
            case MELEE: soldat = new Melee(image, x, y);break;
            case MAGE: soldat = new Mage(image, x, y);break;
        }
        return soldat;
    }
}

