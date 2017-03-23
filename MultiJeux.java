package multijeux;
import Onglet1.Dessin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author stag Caroline Nellie
 */
public class MultiJeux extends Application {

    @Override
    public void start(Stage primaryStage) {
       
        // Creation du Titre de ma fenetre
        primaryStage.setTitle("Plateforme Multi Jeux");
        
        //Creation d 'une barre de menu
   
        BorderPane bp = new BorderPane();
        
        Menu menuActivite = new Menu("Mes Jeux");
        MenuItem dessiner = new MenuItem("Dessiner");
        MenuItem calculer = new MenuItem("Calculer");
        MenuItem mQuizz = new MenuItem("QUIZZ");
        Menu connexion = new Menu ("Connexion");
        menuActivite.getItems().addAll(dessiner,calculer,mQuizz);
        MenuBar menuBar =  new MenuBar();
        menuBar.getMenus().addAll(menuActivite, connexion);
        //groupe.getChildren().add(menuBar);
        bp.setTop(menuBar);
        
        // Creation des onglets
        //on creer un tab pane sur lequel on fixera les onglets
        TabPane root = new TabPane();
        // creation de 5 onglets
        Tab accueil= new Tab("accueil");
        Tab dessin = new Tab("Dessin");
        Tab calcul = new Tab("Calcul");
        Tab quizz = new Tab("Quizz");
        Tab admin = new Tab("Admin");
        
        //cration des objets de mes classes
        Accueil a = new  Accueil();
        Dessin od = new Dessin();
        Calcul c = new Calcul();
        Quizz q = new Quizz();
        
        // on fixe les objets sur mes onglets
        accueil.setContent(a);
        dessin.setContent(od);
        calcul.setContent(c);
        quizz.setContent(q);
        root.getTabs().setAll(accueil,dessin, calcul,quizz);
        
        //groupe.getChildren().addAll(menuBar,root);
        bp.setBottom(root);
        
        Scene scene = new Scene(bp,820, 810, Color.WHITE);
        
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(MultiJeux.class, args);
    }

    
}
