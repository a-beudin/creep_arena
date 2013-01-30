package fr.creeparena.elements.usine;
import fr.creeparena.elements.Soldat;

// Usine abstraite qui sert de base aux usines concrètes.
public abstract class Usine {
     
    // Méthode qui permet de former les soldats.
    public Soldat formerSoldat(TypeSoldat type, int image, int x, int y) {
        Soldat soldat = this.creerSoldat(type, image, x, y);
        return soldat;
    }
    
    // La création d'un soldat est déléguée aux sous classes.
    public abstract Soldat creerSoldat(TypeSoldat type, int image, int x, int y);
}
