/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author stag
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class AccesTquestion extends Parent
{

 
    
    public AccesTquestion()
    {
       
        BorderPane borderpane = new BorderPane();
        
          ////////////////////////CREATION/////////////////////////////
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
       
        
        //pane.getStylesheets().add("Calcule/styleCalc.css");
                           
                 
       
        
        Label resNiveau = new Label("Niveau");
        pane.add(resNiveau, 0, 1);
        
        final TextField niveauField = new TextField();
        pane.add(niveauField, 1, 1);
        
        Label resEnonce = new Label("Enoncé");
        pane.add(resEnonce, 0, 2);
        
        final TextField enonceField = new TextField();
        pane.add(enonceField, 1, 2);
        
        Label resReponse = new Label("Reponse");
        pane.add(resReponse, 0, 2);
        
        final TextField reponseField = new TextField();
        pane.add(reponseField, 1, 2);
        
      
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, -15));
        hbox.setSpacing(10);    
        
        Button CreateButton = new Button("ENREGISTRER"); 
          
        
        hbox.getChildren().addAll(CreateButton);

        CreateButton.getStyleClass().add("btn");
       
     

        pane.add(hbox, 1,4);
        
        ////////////////////////MODIFICATION/////////////////////////////
        
        GridPane panem = new GridPane();
        panem.setAlignment(Pos.CENTER);
        panem.setHgap(10);
        panem.setVgap(10);
        panem.setPadding(new Insets(25, 25, 25, 25));
       
        
        //pane.getStylesheets().add("Calcule/styleCalc.css");
                           
        ChoiceBox<Quizz> enonce = new ChoiceBox<>();  
       // enonce.getItems().addAll(enonceliste.getContent());
       // enonce.getSelectionModel().select(obj);
       
        // Les objets suivants sont utilisés une fois le choix fait
        Label resNiveaum = new Label("Niveau");
        pane.add(resNiveaum, 0, 1);
        
        final TextField niveaumField = new TextField();
        pane.add(niveaumField, 1, 1);
        
        Label resEnoncem = new Label("Enoncé");
        pane.add(resEnoncem, 0, 2);
        
        final TextField enoncemField = new TextField();
        pane.add(enoncemField, 1, 2);
        
        Label resReponsem = new Label("Reponse");
        pane.add(resReponsem, 0, 2);
        
        final TextField reponsemField = new TextField();
        pane.add(reponsemField, 1, 2);
        
      
        HBox hboxm = new HBox();
        hboxm.setPadding(new Insets(0, 0, 0, -15));
        hboxm.setSpacing(10);    
        
        Button ModifButton = new Button("MODIFIER"); 
          
        
        hboxm.getChildren().addAll(ModifButton);

        ModifButton.getStyleClass().add("btn");
       
     

        panem.add(hboxm, 1,4);
        
        ///////////////////////RATTACHEMENT AU BORDERPANE//////////////////
        
        borderpane.setTop(pane);
        borderpane.setBottom(panem);
        
        
        //**********************GESTION DES EVENEMENTS*******************//   
        //****Boutton de création
        CreateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
//              
//                   
                
//                LogButton.setDisable(true);
//                reponseField.clear();
                              
            }
        });
        
        //****Boutton de modification
         ModifButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
//              
//                   
                
//                LogButton.setDisable(true);
//                reponseField.clear();
                              
            }
        });
        
           
        
        

            this.getChildren().add(pane);
        
        
    }
    
     
 
}