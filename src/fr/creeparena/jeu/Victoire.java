package fr.creeparena.jeu;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import fr.creeparena.jeu.Main.MainFrame;

public class Victoire extends Parent {
    
    private Group group;
    private Label label;
    private ImageView imageView;
    private Camp camp;
    private int image;
    private MainFrame mainFrame = Main.getMainFrame();
    
    public Victoire(Camp camp){
        this.camp = camp;
        initContent();
        System.out.println("victoire "+camp);
        group = new Group();
        getChildren().add(group);
        group.getChildren().add(label);
    }
    
    public void initContent() {
        imageView = new ImageView();
        if(camp == Camp.ROUGE) image = Config.IMAGE_LABEL_VICTOIRE_ROUGE;
        else image = Config.IMAGE_LABEL_VICTOIRE_VERT;
        imageView.setImage(Config.getImages().get(image));
        label = new Label("", imageView);
        label.getStyleClass().add("labelVictoire");
        label.setLayoutX(Config.SCREEN_WIDTH/2 - 150);
        label.setLayoutY(Config.SCREEN_HEIGHT/2 - 37.5);
    }
}
