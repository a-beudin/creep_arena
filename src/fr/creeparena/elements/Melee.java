package fr.creeparena.elements;

import fr.creeparena.elements.actions.CombatMelee;
import fr.creeparena.jeu.Config;
import javafx.scene.image.ImageView;

// classe de soldat de mêlée (combat au corps-à-corps)
public class Melee extends Soldat {
    
    public Melee(int image, int x, int y){
        super(Config.VIE_MELEE, Config.DEGATS_MELEE, x, y);
        imageView = new ImageView();
        getChildren().add(imageView);
        imageView.setImage(Config.getImages().get(image));
        imageView.setFitWidth(Config.TAILLE_SOLDAT);
        imageView.setFitHeight(Config.TAILLE_SOLDAT);
        combat = new CombatMelee();
    }
}
