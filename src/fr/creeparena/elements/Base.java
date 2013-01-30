package fr.creeparena.elements;

import fr.creeparena.jeu.Camp;
import fr.creeparena.jeu.Config;
import javafx.scene.image.ImageView;

public class Base extends Batiment {
    
    public final Camp CAMP;
    
    public Base(int image, Camp camp){
        super(Config.VIE_BASE);
        this.taille = 8;
        this.CAMP = camp;
        imageView = new ImageView();
        getChildren().add(imageView);
        imageView.setImage(Config.getImages().get(image));
        imageView.setFitWidth(Config.BASE_SIZE);
        imageView.setFitHeight(Config.BASE_SIZE);
    }
    
}
