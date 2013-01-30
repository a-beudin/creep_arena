package fr.creeparena.jeu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import fr.creeparena.jeu.Main.MainFrame;
import fr.creeparena.items.BoutonAjouter;
import fr.creeparena.util.Direction;
import fr.creeparena.grille.Grille;
import fr.creeparena.util.Coordonnee;
import fr.creeparena.elements.usine.*;
import fr.creeparena.elements.*;

public class Partie extends Parent {
    
    private Group group;
    private Timeline timelineVagues;
    private Timeline timeline;
    private static final MainFrame mainFrame = Main.getMainFrame();
    private Grille grille = new Grille();
    private Base baseVerte;
    private Base baseRouge;
    private Armee armeeRouge;
    private Armee armeeVerte;
    private GroupeBatiment tourellesRouges;
    private GroupeBatiment tourellesVertes;
    private GroupeSoldat groupe;
    private int [] nbSoldats = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
    private BoutonAjouter[] boutons = new BoutonAjouter[12];
    private int orRouge = Config.OR_DEBUT_PARTIE;
    private int orVert = Config.OR_DEBUT_PARTIE;
    private Label labelOrRouge;
    private Label labelOrVert;
    
    // initialise le contenu de la partie
    public Partie() {
        group = new Group();
        getChildren().add(group);
        initContent();
    }
    
    // démarre le jeu
    public void start() {
        timelineVagues.play();
        timeline.play();
        group.getChildren().get(0).requestFocus();
        System.out.println("Debut de partie");
    }
    
    // stoppe le jeu
    public void stop() {
        timelineVagues.stop();
        timeline.stop();
        System.out.println("Fin de partie");
    }
    
    public void lancerVagues() {
        // appelle la création des groupes de soldats et les ajoutes aux armées correspondantes
        armeeRouge.ajouterGroupe(creerGroupe(TypeSoldat.MELEE, 0, Config.IMAGE_MELEEROUGE, Config.POP_VAGUE_1_X, Config.POP_VAGUE_1_Y, Config.ATTENTE_MELEES, Direction.EST, 0));
        armeeRouge.ajouterGroupe(creerGroupe(TypeSoldat.MAGE, 3, Config.IMAGE_MAGEROUGE, Config.POP_VAGUE_1_X, Config.POP_VAGUE_1_Y, Config.ATTENTE_MAGES, Direction.EST, 0));
        
        armeeVerte.ajouterGroupe(creerGroupe(TypeSoldat.MELEE, 6, Config.IMAGE_MELEEVERT, Config.POP_VAGUE_2_X, Config.POP_VAGUE_2_Y, Config.ATTENTE_MELEES, Direction.SUD, 90));
        armeeVerte.ajouterGroupe(creerGroupe(TypeSoldat.MAGE, 9, Config.IMAGE_MAGEVERT, Config.POP_VAGUE_2_X, Config.POP_VAGUE_2_Y, Config.ATTENTE_MAGES, Direction.SUD, 90));
        
        armeeRouge.ajouterGroupe(creerGroupe(TypeSoldat.MELEE, 2, Config.IMAGE_MELEEROUGE, Config.POP_VAGUE_3_X, Config.POP_VAGUE_3_Y, Config.ATTENTE_MELEES, Direction.NORD, 270));
        armeeRouge.ajouterGroupe(creerGroupe(TypeSoldat.MAGE, 5, Config.IMAGE_MAGEROUGE, Config.POP_VAGUE_3_X, Config.POP_VAGUE_3_Y, Config.ATTENTE_MAGES, Direction.NORD, 270));

        armeeVerte.ajouterGroupe(creerGroupe(TypeSoldat.MELEE, 8, Config.IMAGE_MELEEVERT, Config.POP_VAGUE_4_X, Config.POP_VAGUE_4_Y, Config.ATTENTE_MELEES, Direction.OUEST, 180));
        armeeVerte.ajouterGroupe(creerGroupe(TypeSoldat.MAGE, 11, Config.IMAGE_MAGEVERT, Config.POP_VAGUE_4_X, Config.POP_VAGUE_4_Y, Config.ATTENTE_MAGES, Direction.OUEST, 180));
        
        armeeRouge.ajouterGroupe(creerGroupe(TypeSoldat.MELEE, 1, Config.IMAGE_MELEEROUGE, Config.POP_VAGUE_5_X, Config.POP_VAGUE_5_Y, Config.ATTENTE_MELEES, Direction.NORD_EST, 315));
        armeeRouge.ajouterGroupe(creerGroupe(TypeSoldat.MAGE, 4, Config.IMAGE_MAGEROUGE, Config.POP_VAGUE_5_X, Config.POP_VAGUE_5_Y, Config.ATTENTE_MAGES, Direction.NORD_EST, 315));
        
        armeeVerte.ajouterGroupe(creerGroupe(TypeSoldat.MELEE, 7, Config.IMAGE_MELEEVERT, Config.POP_VAGUE_6_X, Config.POP_VAGUE_6_Y, Config.ATTENTE_MELEES, Direction.SUD_OUEST, 135));
        armeeVerte.ajouterGroupe(creerGroupe(TypeSoldat.MAGE, 10, Config.IMAGE_MAGEVERT, Config.POP_VAGUE_6_X, Config.POP_VAGUE_6_Y, Config.ATTENTE_MAGES, Direction.SUD_OUEST, 135));
    }
    
    // créé un groupe de soldats selon les paramètres
    public GroupeSoldat creerGroupe(TypeSoldat type, int indice, int image, int x, int y, int [] attente, Direction direction, double rotation) {
        UsineSbire usine = new UsineSbire();
        groupe = new GroupeSoldat();
        int nombre = nbSoldats[indice];
        for (int i=5-nombre; i<5; i++) {
            Soldat soldat = usine.formerSoldat(type, image, x, y);
            soldat.setAttente(attente[i]);
            grille.placerElement(soldat, x, y);
            soldat.setRotate(rotation);
            soldat.setDirection(direction);
            group.getChildren().add(soldat);
            groupe.ajouterSoldat(soldat);
        }
        nbSoldats[indice] = 3;
        boutons[indice].setDisable(false);
        return groupe;
    }
    
    // initialise le contenu de la partie, les éléments graphiques, appelle l'initialisation des timelines
    public void initContent() {
        
        armeeRouge = new Armee();
        armeeVerte = new Armee();
        
        initTimelineVagues();
        initTimeline();
        final ImageView background = new ImageView();
        background.setFitWidth(Config.BG_SIZE);
        background.setFitHeight(Config.BG_SIZE);
        background.setImage(Config.getImages().get(Config.IMAGE_BACKGROUND));
        background.setFocusTraversable(true);
        
        tourellesRouges = new GroupeBatiment();
        tourellesVertes = new GroupeBatiment();

        baseRouge = new Base(Config.IMAGE_BASEROUGE, Camp.ROUGE);
        baseVerte = new Base(Config.IMAGE_BASEVERTE, Camp.VERT);
        
        grille.placerElement(baseRouge, 0, Config.NOMBRE_CASES - baseRouge.getTaille());
        grille.placerElement(baseVerte, Config.NOMBRE_CASES - baseVerte.getTaille(), 0);
        // replacement des coordonnees au milieu de la base pour la detection des soldats
        baseRouge.setX(baseRouge.getTaille()/2);
        baseRouge.setY(Config.NOMBRE_CASES - baseRouge.getTaille()/2);
        baseVerte.setX(Config.NOMBRE_CASES - baseVerte.getTaille()/2);
        baseVerte.setY(baseVerte.getTaille()/2);

        group.getChildren().addAll(background, baseRouge, baseVerte);
        
        for(Coordonnee position: Config.POS_TOUR_ROUGES){
            Tourelle tourelle = new Tourelle(Config.IMAGE_TOURELLEROUGE);
            grille.placerElement(tourelle, (int)position.getX(), (int)position.getY());
            group.getChildren().add(tourelle);
            tourellesRouges.ajouterBatiment(tourelle);
        }
        
        for(Coordonnee position: Config.POS_TOUR_VERTES){
            Tourelle tourelle = new Tourelle(Config.IMAGE_TOURELLEVERTE);
            grille.placerElement(tourelle, (int)position.getX(), (int)position.getY());
            group.getChildren().add(tourelle);
            tourellesVertes.ajouterBatiment(tourelle);
        }
        
        
        placerBoutons(Config.IMAGE_BOUTONMELEEROUGE, Config.POS_BOUTONS_MELEES_ROUGES, 0);
        placerBoutons(Config.IMAGE_BOUTONMAGEROUGE, Config.POS_BOUTONS_MAGES_ROUGES, 3);
        placerBoutons(Config.IMAGE_BOUTONMELEEVERT, Config.POS_BOUTONS_MELEES_VERTS, 6);
        placerBoutons(Config.IMAGE_BOUTONMAGEVERT, Config.POS_BOUTONS_MAGES_VERTS, 9);
        
        ImageView imageView = new ImageView();
        imageView.setImage(Config.getImages().get(Config.IMAGE_FONDLABELOR));
        imageView.setFitWidth(Config.TAILLE_BOUTON/2);
        imageView.setFitHeight(Config.TAILLE_BOUTON/2);
        labelOrRouge = new Label(""+orRouge, imageView);
        labelOrRouge.getStyleClass().add("labelOrRouge");
        labelOrRouge.setLayoutX(Config.POS_LABEL_OR_ROUGE.getX());
        labelOrRouge.setLayoutY(Config.POS_LABEL_OR_ROUGE.getY());
        imageView = new ImageView();
        imageView.setImage(Config.getImages().get(Config.IMAGE_FONDLABELOR));
        imageView.setFitWidth(Config.TAILLE_BOUTON/2);
        imageView.setFitHeight(Config.TAILLE_BOUTON/2);
        labelOrVert = new Label(""+orVert, imageView);
        labelOrVert.getStyleClass().add("labelOrVert");
        labelOrVert.setLayoutX(Config.POS_LABEL_OR_VERT.getX());
        labelOrVert.setLayoutY(Config.POS_LABEL_OR_VERT.getY());
        
        group.getChildren().addAll(labelOrRouge, labelOrVert);
    }
    
    // créé et place un bouton de renforcement de troupes selon les paramètres
    public void placerBoutons(int image, Coordonnee[] positions, int indice){
        for(Coordonnee position : positions){
            ImageView imageView = new ImageView();
            imageView.setImage(Config.getImages().get(image));
            imageView.setFitWidth(Config.TAILLE_BOUTON);
            imageView.setFitHeight(Config.TAILLE_BOUTON/2);
            final int INDICE = indice;
            BoutonAjouter bouton = new BoutonAjouter(imageView);
            boutons[INDICE] = bouton;
            bouton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        incNbSoldats(INDICE);
                        if(nbSoldats[INDICE]>=5) boutons[INDICE].setDisable(true);
                    }
                });
            bouton.setLayoutX(position.getX());
            bouton.setLayoutY(position.getY());
            group.getChildren().add(bouton);
            indice++;
        }
    }
    
    // initialise la timeline et les frames gérant l'apparition des vagues
    public void initTimelineVagues() {
        timelineVagues = new Timeline();
        timelineVagues.setCycleCount(Timeline.INDEFINITE);
        KeyFrame genVagues = new KeyFrame(Duration.millis(Config.TEMPS_ENTRE_VAGUES), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lancerVagues();
            }
        });
        timelineVagues.getKeyFrames().addAll(genVagues);
    }
    
    // initialise la timeline et les vagues gérant les déplacement et combats des éléments
    public void initTimeline() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        KeyFrame kfRouge = new KeyFrame(Duration.millis(Config.VITESSE), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int gain = mouvement(armeeRouge, armeeVerte, baseVerte, tourellesVertes);
                augmenterOrRouge(gain);
            }
        });
                   
        KeyFrame kfVerte = new KeyFrame(Duration.millis(Config.VITESSE), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               int gain = mouvement(armeeVerte, armeeRouge, baseRouge, tourellesRouges);
               augmenterOrVert(gain);
            }
        });
        
        KeyFrame kfTourellesRouges = new KeyFrame(Duration.millis(Config.VITESSE), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               int gain = mouvementTourelles(tourellesRouges, armeeVerte);
               augmenterOrRouge(gain);
            }
        });
        
        KeyFrame kfTourellesVertes = new KeyFrame(Duration.millis(Config.VITESSE), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               int gain = mouvementTourelles(tourellesVertes, armeeRouge);
               augmenterOrVert(gain);
            }
        });
        timeline.getKeyFrames().addAll(kfVerte, kfRouge, kfTourellesRouges, kfTourellesVertes);
    }
    
    // méthode appelée lors de l'action d'un bouton pour ajouter
    // un nouveau soldat au groupe correspondant
    public void incNbSoldats(int numeroGroupe) {
        if(numeroGroupe < 6) {
            // joueur rouge achète des soldats
            if(nbSoldats[numeroGroupe] < 5 && orRouge>=Config.PRIX_SOLDAT) { 
                nbSoldats[numeroGroupe]+=1;
                orRouge -= Config.PRIX_SOLDAT;
                labelOrRouge.setText(""+orRouge);
            }
        }
        else {
            // joueur vert achète des soldats
            if(nbSoldats[numeroGroupe] < 5 && orVert>=Config.PRIX_SOLDAT) { 
                nbSoldats[numeroGroupe]+=1;
                orVert -= Config.PRIX_SOLDAT;
                labelOrVert.setText(""+orVert);
            }
        }
    }
    
    // augmente la quantité d'or du joueur rouge
    public void augmenterOrRouge(int valeur) {
        orRouge += valeur;
        if (orRouge>99) orRouge = 99;
        labelOrRouge.setText(""+orRouge);
    }
    
    // augmente la quantité d'or du joueur vert
    public void augmenterOrVert(int valeur) {
        orVert += valeur;
        if (orVert>99) orVert = 99;
        labelOrVert.setText(""+orVert);
    }
    
    // modifie les coordonnée d'un soldat en fonction de la direction
    public void modifierCoordonnees(Direction dir, Soldat soldat) {
        if(grille.caseLibre(dir.newX(soldat.getX()), dir.newY(soldat.getY()))) {
            soldat.setX(dir.newX(soldat.getX()));
            soldat.setY(dir.newY(soldat.getY()));
        }
        else {
            switch(dir) {
                case NORD: modifierCoordonnees(Direction.NORD_EST, soldat); break;
                case NORD_EST: modifierCoordonnees(Direction.NORD_OUEST, soldat); break;
                case SUD: modifierCoordonnees(Direction.SUD_OUEST, soldat); break;
                case SUD_OUEST: modifierCoordonnees(Direction.SUD_EST, soldat); break;
                case EST: modifierCoordonnees(Direction.NORD_EST, soldat); break;
                case OUEST: modifierCoordonnees(Direction.SUD_OUEST, soldat); break;
            }
        }
    }
    
    // deplace un soldat sur la grille
    public void deplacer(Soldat soldat){
        int x = soldat.getX();
        int y = soldat.getY();
        Direction direction = soldat.getDirection();
        grille.liberer(x, y);
        modifierCoordonnees(soldat.getDirection(), soldat);
        x = soldat.getX();
        y = soldat.getY();
        if (y < x && y < 0.2*Config.NOMBRE_CASES && direction == Direction.NORD){
            soldat.setRotate(0);
            direction = Direction.EST;
        }
        else if (y > x && y > 0.8*Config.NOMBRE_CASES && direction == Direction.SUD){
            soldat.setRotate(180);
            direction = Direction.OUEST;
        }
        else if (x < y && x < 0.2*Config.NOMBRE_CASES && direction == Direction.OUEST){
            soldat.setRotate(90);
            direction = Direction.SUD;
        }
        else if (x > y && x > 0.8*Config.NOMBRE_CASES && direction == Direction.EST){
            soldat.setRotate(270);
            direction = Direction.NORD;
        }
        soldat.setDirection(direction);
        grille.placerElement(soldat, x, y);
    }
    
    // méthode mouvement de l'armée appellée à chaque pas de temps de la timeline
    public int mouvement(Armee armee, Armee armeeAdverse, Base baseAdverse, GroupeBatiment tourellesAdverses){
        for (GroupeSoldat groupe: armee.getGroupes()) {
            for (Soldat soldat: groupe.getSoldats()) {
                if (soldat.estVivant()) {
                    Soldat ennemi = soldat.detecterSoldat(armeeAdverse);
                    if (ennemi == null) {
                        Batiment tourelle = soldat.detecterBatiment(tourellesAdverses);
                        if (tourelle == null) {
                            int dx = Math.abs(soldat.getX() - baseAdverse.getX());
                            int dy = Math.abs(soldat.getY() - baseAdverse.getY());
                            double distance = Math.sqrt(dx*dx + dy*dy);
                            if (distance <= soldat.getPortee()) {
                                soldat.attaquer(baseAdverse);
                                if (!baseAdverse.estVivant()){
                                    if (baseAdverse.CAMP == Camp.ROUGE) mainFrame.victoireVert();
                                    else mainFrame.victoireRouge();
                                    stop();
                                    }
                                }
                                else {
                                    if (soldat.getAttente() != 0) soldat.setAttente(soldat.getAttente() - 1);
                                    else deplacer(soldat);
                                }
                            }
                            else {
                                soldat.attaquer(tourelle);
                                if (!tourelle.estVivant()){
                                    grille.liberer(tourelle.getX(), tourelle.getY());
                                    group.getChildren().remove(tourelle);
                                    return Config.GAIN_TOURELLE;
                                }
                            }
                        }
                        else {
                            soldat.attaquer(ennemi);
                            if (!ennemi.estVivant()){
                                grille.liberer(ennemi.getX(), ennemi.getY());
                                group.getChildren().remove(ennemi);
                                return Config.GAIN_SOLDAT;
                            }
                        }
                }
            }
        }
        return 0;
    }
    
    // méthode mouvement des tourelles appellée à chaque pas de temps de la timeline
    public int mouvementTourelles(GroupeBatiment tourelles, Armee armeeAdverse) {
        for (Batiment tourelle: tourelles.getBatiments()) {
            if (tourelle.estVivant()) {
                Soldat ennemi = tourelle.detecterSoldat(armeeAdverse);
                if (ennemi != null) {
                    tourelle.attaquer(ennemi);
                    if (!ennemi.estVivant()){
                        grille.liberer(ennemi.getX(), ennemi.getY());
                        group.getChildren().remove(ennemi);
                        return Config.GAIN_SOLDAT;
                    }
                }
            }
        }
        return 0;
    }
}