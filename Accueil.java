/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multijeux;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author stag Nellie
 */
public class Accueil extends Parent{
     public Accueil()
     {
       //Création d 'un Layout Border Pane pour orientation top bottom, ritgh, left...
       BorderPane bp = new BorderPane ();
    
       // Création d 'un label pour le titre de la page d'accueil
       Label lblTitle =  new Label("Bienvenue dans ton espace Multi-Jeux");
       // On lui donne une couleur , une police , un fond gras  et une taille
       lblTitle.setTextFill(Color.DARKORANGE );
       lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 28));
       
       // Je positionne le titre sur le borderPane
       // creation d 'une marge
       BorderPane.setMargin(lblTitle,new Insets(40,0,40,0));
       //je le positionne au centre
       BorderPane.setAlignment(lblTitle, Pos.CENTER);
       bp.setCenter(lblTitle);
       
       
       // Récupération de l'image mascotte dans le package image
       final Image imAccueil = new Image("Images/pierreafeu.gif"); 
       final ImageView icon = new ImageView(imAccueil); 
       // on lui donne une taille hauteur et largeur
       icon.setFitHeight(500);
       icon.setFitWidth(600);
       //On place l'image sur le borderPane marge et position au centre en bas
       BorderPane.setMargin(icon, new Insets(0,70,10,100));
       BorderPane.setAlignment(icon, Pos.CENTER);
       bp.setBottom(icon);
       
       
       //fixation de la cration sur la scene
               
       this.getChildren().add(bp);
     
     }
    
}
