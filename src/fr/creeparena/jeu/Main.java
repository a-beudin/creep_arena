package fr.creeparena.jeu;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static MainFrame mainFrame;

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
    
    @Override
    public void start(Stage stage) {
        
        Config.initialize();
        stage.setTitle("Creep Arena");
        Group root = new Group();
        mainFrame = new MainFrame(root);
        Scene scene = new Scene(root, Config.BG_SIZE, Config.BG_SIZE, Color.BLACK);
        scene.getStylesheets().add(Main.class.getResource("css/scene.css").toExternalForm());
        stage.setResizable(false);
        stage.setWidth(Config.SCREEN_WIDTH + 2*Config.WINDOW_BORDER);
        stage.setHeight(Config.SCREEN_HEIGHT + Config.WINDOW_BORDER + Config.TITLE_BAR_HEIGHT);
        stage.setFullScreen(Config.full_screen);
        stage.setScene(scene);
        mainFrame.debutPartie();
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
    
    public class MainFrame {
        
        private Group root;
        private Partie partie;
        private Victoire victoire;
        private int state;
        
        private MainFrame(Group root) {
            this.root = root;
        }
        
        public int getState() {
            return state;
        }
        
        public void debutPartie() {
            changeState(0);
        }
        
        public void victoireRouge() {
            changeState(1);
        }
        
        public void victoireVert() {
            changeState(2);
        }
        
        public void changeState(int newState) {
            state = newState;
            switch(state) {
                case 0: partie = new Partie();
                        root.getChildren().add(partie);
                        partie.start(); 
                        break;
                case 1: victoire = new Victoire(Camp.ROUGE);
                        root.getChildren().add(victoire);
                        break;
                case 2: victoire = new Victoire(Camp.VERT);
                        root.getChildren().add(victoire);
                        break;
            }
        }
    }
}
