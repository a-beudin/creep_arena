package fr.creeparena.elements;


import fr.creeparena.elements.actions.CombatDistant;
import fr.creeparena.jeu.Config;
import javafx.scene.image.ImageView;

// classe de soldat de type mage (combat à distance)
public class Mage extends Soldat {
    
    public Mage(int image, int x, int y){
        super(Config.VIE_MAGE, Config.DEGATS_MAGE, x, y);
        imageView = new ImageView();
        getChildren().add(imageView);
        imageView.setImage(Config.getImages().get(image));
        imageView.setFitWidth(Config.TAILLE_SOLDAT);
        imageView.setFitHeight(Config.TAILLE_SOLDAT);
        combat = new CombatDistant();
    }
}
