package fr.creeparena.elements.actions;

import fr.creeparena.elements.*;
import fr.creeparena.elements.Armee;
import fr.creeparena.elements.GroupeBatiment;

public interface Detection {
    public Soldat detecterSoldat(Armee armee, int x, int y, int portee);
    public Batiment detecterBatiment(GroupeBatiment batiments, int x, int y, int portee);
}
