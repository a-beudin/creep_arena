package fr.creeparena.grille;

import fr.creeparena.util.Coordonnee;
import fr.creeparena.jeu.Config;
import fr.creeparena.elements.Element;

// classe représentant la grille de jeu
public class Grille {
    
    public final double TAILLE;
    private Case [][] cases;
    
    public Grille() {
        // créé la grille selon le nombre de cases de la configuration
        TAILLE = Config.NOMBRE_CASES;
        cases = new Case[(int)TAILLE][(int)TAILLE];
        for(int i=0; i < TAILLE; i++){
            for(int j=0; j < TAILLE; j++){
                cases[i][j] = new Case(new Coordonnee((int)i*Config.TAILLE_SOLDAT, (int)j*Config.TAILLE_SOLDAT));
            }
        }
    }
    
    public void placerElement(Element e, int i, int j) {
        // place un élément sur la case (i,j) si celle-ci est dans la grille, libère l'ancienne case et occupe la nouvelle
        if (i < Config.NOMBRE_CASES && i >= 0 && j < Config.NOMBRE_CASES && j >= 0) {
            int taille = e.getTaille();
            e.setX(i);
            e.setY(j);
            for(int a=0; a<taille; a++){
                for(int b=0; b<taille; b++){
                    cases[i+a][j+b].setOccuppee();
                }
            }
            e.setLayoutX(cases[i][j].X);
            e.setLayoutY(cases[i][j].Y);
        }
    }
    
    public boolean caseLibre(int i, int j) {
        if (i < Config.NOMBRE_CASES && i >= 0 && j < Config.NOMBRE_CASES && j >= 0) {
            return cases[i][j].estLibre();
        }
        return false;
    }
    
    public void liberer(int i, int j) {
        if (i < Config.NOMBRE_CASES && i >= 0 && j < Config.NOMBRE_CASES && j >= 0) {
            cases[i][j].setLibre();
        }
    }
    
    public String toString() {
        String chaine = "Grille :\n";
        for (int i=0; i<cases.length; i++) {
                for (int j=0; j<cases.length; j++) {
                    chaine += cases[i][j].toString();
                }
        }
        return chaine;
    }
}
