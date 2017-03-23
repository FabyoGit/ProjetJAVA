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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Log extends Parent
{

 
    
    public Log()
    {
       
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
       
        
        pane.getStylesheets().add("Calcule/styleCalc.css");
                           
                 
       
        
        Label resLogin = new Label("Login");
        pane.add(resLogin, 0, 1);
        
        final TextField loginField = new TextField();
        pane.add(loginField, 1, 1);
        
        Label resPassword = new Label("PassWord");
        pane.add(resPassword, 0, 2);
        
        final TextField passwordField = new TextField();
        pane.add(passwordField, 1, 2);
        
        
      
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, -15));
        hbox.setSpacing(10);    
        
        Button LogButton = new Button("LOG"); 
          
        
        hbox.getChildren().addAll(LogButton);

        LogButton.getStyleClass().add("btn");
       
     

        pane.add(hbox, 1,1);
        
        
                     
        
        LogButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
//              
//                   
                
//                LogButton.setDisable(true);
//                reponseField.clear();
                              
            }
        });
        
        
      //**********************GESTION DES EVENEMENTS*******************//        
        
        

            this.getChildren().add(pane);
        
        
    }
    
     
 
}