package Onglet1;

import java.util.function.Consumer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
 *
 * @author stag Nellie
 */
public class Dessin extends Parent{
    Pinceau pinceau;
    
   public Dessin()
   {
       // creation d' un layout BorderPane sur lequel je fixerai les canvas
       BorderPane root = new BorderPane();
       
       // Je donne une couleur de fond à mon borderPane pour mon dessin
       root.setStyle("-fx-background-color: white;");
      
        // creation d'un objet canvas permet de définir une sorte d'image transparente
       //sur laquelle l'application peut dessiner.
       Canvas ardoise = new Canvas(820,810);
     
       
       Canvas ombre = new Canvas(820, 810);
       root.setCenter(new Group(ardoise, ombre));
       ombre.setOpacity(0.1);
       ombre.setDisable(true);
     
       //La classe GraphicsContext est une classe importante, liée à la
       //classe Canvas , et qui représente le contexte graphique utilisé pour
       //dessiner les éléments
       // on l'associe au canvas pour récupéré le dessin
       GraphicsContext gcxt = ardoise.getGraphicsContext2D();
       

       
       // Creation d 'un bouton simple pour effacer le dessin
       Button effacer = new Button();
       
       // Recupération d 'une image du package image pour remplacer le bouton 
       //effacer par une icone poubelle
       final Image poubelle = new Image("Images/poubelle.png"); 
       final ImageView icon = new ImageView(poubelle); 
       effacer.setGraphic(icon);
       
       
       //Creation de radioBoutons pour la seléection des couleurs sur la barre
       // a outils de mon ardoise à dessin
       // ici nous voulons que l'utilisateur puisse choisir entre 3 couleurs
       
        RadioButton rbRouge = new RadioButton();
        RadioButton rbBleu = new RadioButton();
        RadioButton rbVert = new RadioButton();
        //****************NB**************************************
       // Je ne met pas de couleur selectionné par défaut car
       // je dis plus loin dans le code que le pinceau peint en noir par defaut
       //lors de la creation de mon color picker
       //**********************************************************
       
       // je remplace les raddiobutton par des icons mis dans le package image
       // bouton rouge
       final Image peintureRouge = new Image("Images/peintureRouge.png"); 
       final ImageView iconRouge = new ImageView(peintureRouge);
       iconRouge.setFitHeight(40);
       iconRouge.setFitWidth(40);
       rbRouge.setGraphic(iconRouge);
       //bouton bleu
       final Image peintureBleu = new Image("Images/peintureBleu.png"); 
       final ImageView iconBleu = new ImageView(peintureBleu);
       iconBleu.setFitHeight(40);
       iconBleu.setFitWidth(40);
       rbBleu.setGraphic(iconBleu);
        //bouton Vert
       final Image peintureVerte = new Image("Images/peintureVerte.png"); 
       final ImageView iconVerte = new ImageView(peintureVerte);
       iconVerte.setFitHeight(40);
       iconVerte.setFitWidth(40);
       rbVert.setGraphic(iconVerte);
       //
        // creation du groupe de bouton pour y fixer les radio boutons
       ToggleGroup groupBouton = new ToggleGroup();
       rbRouge.setToggleGroup(groupBouton);
       rbBleu.setToggleGroup(groupBouton);
       rbVert.setToggleGroup(groupBouton);
      
       
       // creation de trois separateurs sur la barre a outils
       Separator sep = new Separator();
       Separator sep2 = new Separator();
       Separator sep3 = new Separator();
      
       // creation d'un outils de selection de couleurs
       ColorPicker couleurPinceau = new ColorPicker();
       
       // par defaut la couleur sera du noir :
       couleurPinceau.setValue(Color.BLACK);
       // creation d 'une barre de variation pour la taille du pinceau
       Slider taillePinceau = new Slider(1, 40, 20);
       //customisation du slider pour rendre visible les graduations
       taillePinceau.setShowTickMarks(true);
       //creation d 'un label pour rendre plus clair la barre d 'outils
       Label l1= new Label("taille pinceau");
       
 
       //Choix du pinceau
       // on creer une choiceBox de pinceaux
       ChoiceBox<Pinceau> pinceaux = new ChoiceBox<>();
       // on y ajoute les pinceaux
       pinceaux.getItems().addAll(Pinceau.values());
       //on recupére la valeur du model selectionné
       pinceaux.getSelectionModel().select(0);
       



        //***********************************************************************************
       // gestion evenementielle
       //************************************************************************************* 
       // gestion evenementielle des boutonRadio
       //Couleur Rouge
        rbRouge.setOnMouseClicked(new EventHandler<MouseEvent>()
       {
            public void handle(MouseEvent me)
            {
                 couleurPinceau.setValue(Color.RED);
            }
       });
        
        //obtention de la couleur bleu
      rbBleu.setOnMouseClicked(new EventHandler<MouseEvent>()
       {
            public void handle(MouseEvent me)
            {
                 couleurPinceau.setValue(Color.BLUE);
            }
       });
       
       // obtention de la couleur verte
       rbVert.setOnMouseClicked(new EventHandler<MouseEvent>()
       {
            public void handle(MouseEvent me)
            {
                 couleurPinceau.setValue(Color.GREEN);
            }
       });
       
       // gestion evenementielle du bouton effacer
       effacer.setOnMouseClicked(new EventHandler<MouseEvent>()
       {
            public void handle(MouseEvent me)
            {
                ardoise.getGraphicsContext2D().clearRect(0,0, 10000,1000);
                 
            }
       });
       
       Consumer<GraphicsContext> effacerDessin = gctx -> {
			gctx.setFill(Color.WHITE);
			gctx.fillRect(0, 0, ardoise.getWidth(),ardoise.getHeight());
		};

                
         // gestion evenementielle de l'outils dessin
         // forme du pinceau
         // couleur du pinceau
         // taille du pinceau
                
               ManipulationCont manipulationCont = (e, gctx) -> {

                        double v = taillePinceau.getValue();
			Pinceau typePinceau = pinceaux.getValue();
			double x = e.getX() - v / 2;
			double y = e.getY() - v / 2;
                        
			Color selCouleur = couleurPinceau.getValue();

                        gctx.setFill(selCouleur);
    			gctx.setStroke(selCouleur);

                   
				switch (typePinceau) {
				case OVALE:
					gctx.fillOval(x, y, v, v);
					break;
				case RETANGLE:
					gctx.fillRect(x, y, v, v);
					break;
				default:
					break;
				}

			
		};
    
       
	// gestion evenementielle pour le dessin
        // on utilise un eventHandler
        EventHandler<? super MouseEvent> dessiner = e -> {
			GraphicsContext gctx;
			if (e.getEventType() == MouseEvent.MOUSE_MOVED) {
				gctx = ombre.getGraphicsContext2D();
				effacerDessin.accept(gctx);
			} else {
				gctx = ardoise.getGraphicsContext2D();
			}
			manipulationCont.configure(e, gctx);
		};

        ardoise.setOnMouseDragged(dessiner);
        ardoise.setOnMouseReleased(dessiner);
        ardoise.setOnMousePressed(dessiner);
	ardoise.setOnMouseMoved(dessiner);
       
       ToolBar barreOutils = new ToolBar( effacer,sep, rbRouge,rbBleu,rbVert,couleurPinceau, sep2,l1,taillePinceau,sep3,pinceaux );
       
       this.getChildren().add(root);
       this.getChildren().addAll( barreOutils);



     }    
    }
   
   
   
   
   

