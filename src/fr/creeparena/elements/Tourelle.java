package fr.creeparena.elements;

import fr.creeparena.elements.actions.CombatDistant;
import fr.creeparena.elements.actions.DetectionDistant;
import fr.creeparena.jeu.Config;
import javafx.scene.image.ImageView;

public class Tourelle extends Batiment {

    public Tourelle(int image){
        super(Config.VIE_TOURELLE);
        degats=Config.DEGATS_TOURELLE;
        this.taille=1;
        imageView = new ImageView();
        getChildren().add(imageView);
        imageView.setImage(Config.getImages().get(image));
        imageView.setFitWidth(Config.TAILLE_TOURELLE);
        imageView.setFitHeight(Config.TAILLE_TOURELLE);
        combat = new CombatDistant();
        detection = new DetectionDistant();
        portee = Config.PORTEE_TOURELLE;
    }

    
    public void attaquer(Element cible){
        combat.attaquer(cible, degats);
    }
}
