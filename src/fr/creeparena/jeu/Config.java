package fr.creeparena.jeu;

import fr.creeparena.util.Coordonnee;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

// classe de configuration du jeu
public final class Config {
    
    public static final String IMAGE_DIR = "images/";
    static boolean full_screen = false;
    public static final int WINDOW_BORDER = 3; // on desktop platform
    public static final int TITLE_BAR_HEIGHT = 25; // on desktop platform
    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    public static final int BG_SIZE = 700;
    public static final double BASE_SIZE = 0.16*BG_SIZE;
    public static final int TAILLE_SOLDAT = (int)Math.floor(0.02*BG_SIZE);
    public static final int TAILLE_TOURELLE = (int)Math.floor(0.04*BG_SIZE);
    public static final int TAILLE_BOUTON = (int)Math.floor(0.04*BG_SIZE); 
    public static final int NOMBRE_CASES = BG_SIZE/TAILLE_SOLDAT;
    
    // CONFIGURATION DE LA PARTIE
    public static final int VITESSE = 500; // temps entre chaque mouvement de jeu en ms
    public static final int TEMPS_ENTRE_VAGUES = 20000; // temps entre chaque apparition de vague de soldats en ms
    public static final int PRIX_SOLDAT = 6; // prix d'un soldat en or
    public static final int OR_DEBUT_PARTIE = 18; // or donné à chaque joueur au début de la partie
    public static final int GAIN_SOLDAT = 1; // or que donne un soldat tué à l'équipe adverse
    public static final int GAIN_TOURELLE = 6; // or que donne une tourelle détruite à l'équipe adverse
    public static final int PORTEE_TOURELLE = 6; // portee d'attaque des tourelles
    public static final int PORTEE_SOLDAT = 6; // portee d'attaque des soldats
    public static final int DEGATS_MELEE = 10; // degats des soldats de mêlée
    public static final int DEGATS_MAGE = 15; // degats des soldats mages
    public static final int DEGATS_TOURELLE = 15; // degats des tourelles
    public static final int VIE_MELEE = 45; // points de vie des mêlée
    public static final int VIE_MAGE = 20; // points de vie des mages
    public static final int VIE_TOURELLE = 50; // points de vie des tourelles
    public static final int VIE_BASE = 500; // points de vie des bases
    //
    
    // Positions des lieus d'apparition des vagues de soldats
    // groupe rouge du bas
    public static final int POP_VAGUE_1_X = (int)Math.floor(0.15*NOMBRE_CASES) + 1;
    public static final int POP_VAGUE_1_Y = NOMBRE_CASES - (int)Math.floor(0.0875*NOMBRE_CASES) + 1;
    // groupe vert du bas
    public static final int POP_VAGUE_2_X = NOMBRE_CASES - (int)Math.floor(0.0875*NOMBRE_CASES) + 1;
    public static final int POP_VAGUE_2_Y = (int)Math.floor(0.15*NOMBRE_CASES) + 1;
    // groupe rouge du haut
    public static final int POP_VAGUE_3_X = (int)Math.floor(0.0875*NOMBRE_CASES) - 2;
    public static final int POP_VAGUE_3_Y = NOMBRE_CASES - (int)Math.floor(0.15*NOMBRE_CASES) - 2;
    // groupe vert du haut
    public static final int POP_VAGUE_4_X = NOMBRE_CASES - (int)Math.floor(0.15*NOMBRE_CASES) - 2;
    public static final int POP_VAGUE_4_Y = (int)Math.floor(0.0875*NOMBRE_CASES) - 2;
    // groupe rouge du milieu
    public static final int POP_VAGUE_5_X = (int)Math.floor(0.15*NOMBRE_CASES) - 1;
    public static final int POP_VAGUE_5_Y = NOMBRE_CASES - (int)Math.floor(0.15*NOMBRE_CASES) - 1;
    // groupe vert du milieu
    public static final int POP_VAGUE_6_X = NOMBRE_CASES - (int)Math.floor(0.15*NOMBRE_CASES);
    public static final int POP_VAGUE_6_Y = (int)Math.floor(0.15*NOMBRE_CASES);
    
    
    // temps d'attentes des soldats à l'apparition pour les faire sortir en ligne
    
    public static final int[] ATTENTE_MELEES = {0,1,2,3,4};
    public static final int[] ATTENTE_MAGES = {5,6,7,8,9};
    
    // Positions des tourelles rouges
    public static final Coordonnee[] POS_TOUR_ROUGES = new Coordonnee[] {
        // tours devant la base de bas en haut
        new Coordonnee(rapport(0.15), NOMBRE_CASES - rapport(0.1)),
        new Coordonnee(rapport(0.07), NOMBRE_CASES - rapport(0.18)),
        // tours de la ligne du bas de la gauche vers la droite
        new Coordonnee(rapport(0.02), NOMBRE_CASES - rapport(0.4)),
        new Coordonnee(rapport(0.12), rapport(0.25)),
        // tours de la ligne du haut de bas en haut
        new Coordonnee(rapport(0.35), NOMBRE_CASES - rapport(0.06)),
        new Coordonnee(NOMBRE_CASES - rapport(0.3), NOMBRE_CASES - rapport(0.175)),
        // tours de la ligne du milieu de bas en haut
        new Coordonnee(rapport(0.3), NOMBRE_CASES - rapport(0.28)),
        new Coordonnee(rapport(0.36), NOMBRE_CASES - rapport(0.48))
    };
    
    // Positions des tourelles vertes
    public static final Coordonnee[] POS_TOUR_VERTES = new Coordonnee[] {
        // tours devant la base de bas en haut
        new Coordonnee(NOMBRE_CASES - rapport(0.1), rapport(0.15)),
        new Coordonnee(NOMBRE_CASES - rapport(0.18), rapport(0.07)),
        // tours de la ligne du bas de la droite vers la gauche
        new Coordonnee(NOMBRE_CASES - rapport(0.4), rapport(0.02)),
        new Coordonnee(rapport(0.25), rapport(0.12)),
        // tours de la ligne du haut de droite vers la gauche
        new Coordonnee(NOMBRE_CASES - rapport(0.06), rapport(0.35)),
        new Coordonnee(NOMBRE_CASES - rapport(0.175), NOMBRE_CASES - rapport(0.3)),
        // tours de la ligne du milieu de haut en bas
        new Coordonnee(NOMBRE_CASES - rapport(0.35), rapport(0.25)),
        new Coordonnee(NOMBRE_CASES - rapport(0.4), rapport(0.45))
    };
    
    // positions des boutons de renforcement
    public static final Coordonnee[] POS_BOUTONS_MELEES_ROUGES = new Coordonnee[] {
        // bouton ligne du bas
        new Coordonnee(5 + TAILLE_BOUTON, BG_SIZE - 10 - TAILLE_BOUTON/2),
        // bouton ligne du milieu
        new Coordonnee(5 + TAILLE_BOUTON, BG_SIZE - 30 - 2*TAILLE_BOUTON/2),
        // bouton ligne du haut
        new Coordonnee(5 + TAILLE_BOUTON, BG_SIZE - 50 - 3*TAILLE_BOUTON/2),
    };
    
    public static final Coordonnee[] POS_BOUTONS_MAGES_ROUGES = new Coordonnee[] {
        // bouton ligne du bas
        new Coordonnee(5, BG_SIZE - 10 - TAILLE_BOUTON/2),
        // bouton ligne du milieu
        new Coordonnee(5, BG_SIZE - 30 - 2*TAILLE_BOUTON/2),
        // bouton ligne du haut
        new Coordonnee(5, BG_SIZE - 50 - 3*TAILLE_BOUTON/2),
    };
    
    public static final Coordonnee[] POS_BOUTONS_MELEES_VERTS = new Coordonnee[] {
        // bouton ligne du bas
        new Coordonnee(BG_SIZE - 5 - 2*TAILLE_BOUTON, 44 + 2*TAILLE_BOUTON/2),
        // bouton ligne du milieu
        new Coordonnee(BG_SIZE - 5 - 2*TAILLE_BOUTON, 24 + TAILLE_BOUTON/2),
        // bouton ligne du haut
        new Coordonnee(BG_SIZE - 5 - 2*TAILLE_BOUTON, 4),
    };
    
    public static final Coordonnee[] POS_BOUTONS_MAGES_VERTS = new Coordonnee[] {
        // bouton ligne du bas
        new Coordonnee(BG_SIZE - 5 - TAILLE_BOUTON, 44 + 2*TAILLE_BOUTON/2),
        // bouton ligne du milieu
        new Coordonnee(BG_SIZE - 5 - TAILLE_BOUTON, 24 + TAILLE_BOUTON/2),
        // bouton ligne du haut
        new Coordonnee(BG_SIZE - 5 - TAILLE_BOUTON, 4),
    };
    
    // position des indicateurs d'or des joueurs
    public static final Coordonnee POS_LABEL_OR_ROUGE = new Coordonnee(10 + 2*TAILLE_BOUTON, BG_SIZE - 10 - TAILLE_BOUTON/2);
    public static final Coordonnee POS_LABEL_OR_VERT = new Coordonnee(BG_SIZE - 22 - 3*TAILLE_BOUTON, 4);
    
    // indices des images
    public static final int IMAGE_BACKGROUND = 0;
    public static final int IMAGE_BASEROUGE = 1;
    public static final int IMAGE_BASEVERTE = 2;
    public static final int IMAGE_MELEEROUGE = 3;
    public static final int IMAGE_MELEEVERT = 4;
    public static final int IMAGE_MAGEROUGE = 5;
    public static final int IMAGE_MAGEVERT = 6;
    public static final int IMAGE_TOURELLEROUGE = 7;
    public static final int IMAGE_TOURELLEVERTE = 8;
    public static final int IMAGE_FONDLABELOR = 9;
    public static final int IMAGE_BOUTONMELEEROUGE = 10;
    public static final int IMAGE_BOUTONMAGEROUGE = 11;
    public static final int IMAGE_BOUTONMELEEVERT = 12;
    public static final int IMAGE_BOUTONMAGEVERT = 13;
    public static final int IMAGE_LABEL_VICTOIRE_ROUGE = 14;
    public static final int IMAGE_LABEL_VICTOIRE_VERT = 15;
    
    // tableau correspondant aux chemins des images
    private static final String[] IMAGES_NAMES = new String[] {
        "items/background.jpg",
        "batiments/base_rouge.jpg",
        "batiments/base_verte.jpg",
        "soldats/melee_rouge.jpg",
        "soldats/melee_vert.jpg",
        "soldats/mage_rouge.jpg",
        "soldats/mage_vert.jpg",
        "batiments/tourelle_rouge.jpg",
        "batiments/tourelle_verte.jpg",
        "items/fond_label_or.jpg",
        "items/bouton_melee_rouge.jpg",
        "items/bouton_mage_rouge.jpg",
        "items/bouton_melee_vert.jpg",
        "items/bouton_mage_vert.jpg",
        "items/label_victoire_rouge.jpg",
        "items/label_victoire_vert.jpg"
    };
    
    private static ObservableList<Image> images = javafx.collections.FXCollections.<Image>observableArrayList();

    public static ObservableList<Image> getImages() {
        return images;
    }
    
    // méthode lancée au début d'un partie pour charger les images
    public static void initialize() {
        for (String imageName : IMAGES_NAMES) {
            Image image = new Image(Config.class.getResourceAsStream(IMAGE_DIR+imageName));
            if (image.isError()) {
                System.out.println("Image "+imageName+" not found");
            }
            images.add(image);
        }
    }
    
    // petite méthode de calcul servant à placer les éléments sur les cases
    public static int rapport(double coeff) {
        return (int)Math.floor(coeff*NOMBRE_CASES);
    }
}
