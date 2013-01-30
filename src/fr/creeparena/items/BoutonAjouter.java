package fr.creeparena.items;

import fr.creeparena.jeu.Config;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class BoutonAjouter extends Button{
       
    public BoutonAjouter(ImageView image) {
        super("", image);
        setMaxWidth(Config.TAILLE_BOUTON);
        setMaxHeight(Config.TAILLE_BOUTON/2);
    }
}
