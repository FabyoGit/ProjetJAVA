

package beans;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


//public class Quizz extends Parent
//{
public class Calcul extends Application {
 
    
    private String resultat = "";
    private String op = "";
    private String reponse = "";
    
   
    private double points = 0;
    
    // Niveau niveau = Niveau.getInstance();
    private int niveau;
    private boolean flagRepondu = false;
    private Alert alert = new Alert(AlertType.WARNING);
    private String txtNiveau;
    
    public void start(Stage primaryStage) {
    //public Quizz()
    //{
       
         
        
        
        //Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("MULTIJEUX");
        TabPane root = new TabPane(); 
        final Tab tab2 = new Tab("Onglet 2"); 
        
        root.getTabs().setAll(tab2);
       
       
        
        initialiser();
      
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
       
        Scene scene = new Scene(pane, 300, 275);

       // scene.getStylesheets().add("Calcule/styleCalc.css");
        
       // if(niveau.getNiveau() == 1){
        if(niveau == 1){
        txtNiveau = "------------- NIVEAU I -------------";
        }else{
        txtNiveau = "------------- NIVEAU II ------------";
        }
            
        Text sceneTitle = new Text(txtNiveau);
        
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL,15));
        sceneTitle.setTextAlignment(TextAlignment.CENTER);
        pane.add(sceneTitle, 0, 0, 2, 1);
        
       
        Label lblQuestion = new Label("L'énoncé");
        pane.add(lblQuestion, 0, 1);
        
        
        final TextField enonceField = new TextField();
        pane.add(enonceField, 1, 1);
        
        Label resReponse = new Label("Réponse");
        pane.add(resReponse, 0, 2);
        
        
        final TextField reponseField = new TextField();
        pane.add(reponseField, 1, 2);
      
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, -15));
        hbox.setSpacing(10);    
        
        Button verifierButton = new Button("Entrer");        
        Button SuivantButton = new Button("Suivant");    
        
            hbox.getChildren().addAll(verifierButton, SuivantButton);

        verifierButton.getStyleClass().add("btn");
        SuivantButton.getStyleClass().add("btn");
        
        //pane.add(calculateButton, 0,4);
       // pane.add(SuivantButton, 1,4);

        pane.add(hbox, 1,4);
        
        
        final Text finalMessage = new Text();
        pane.add(finalMessage, 1, 2, 2, 1);
        finalMessage.getStyleClass().add("txt-final");

         
        Text bonneResposte = new Text("BONNE REPONSE");
        Text mauvaiseResposte = new Text("MAUVAISE REPONSE");
        
        
        bonneResposte.getStyleClass().add("txt-bonne");
        mauvaiseResposte.getStyleClass().add("txt-mauvaise");
         
        pane.add(mauvaiseResposte, 0, 3, 2, 1);
        pane.add(bonneResposte, 0, 3, 2, 1);
       
        bonneResposte.setVisible(false);
        mauvaiseResposte.setVisible(false);
     
        Label lbPoints = new Label(getPoints());
        pane.add(lbPoints, 1,6,1,1);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        verifierButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
               // String regex = "[a-zA-Z]";
               String REPONSE = reponseField.getText();
             
               if(REPONSE.equalsIgnoreCase(resultat)){
                   finalMessage.setText("Response : "+ REPONSE);
                   mauvaiseResposte.setVisible(false); 
                   bonneResposte.setVisible(true);
                  flagRepondu = true;
                  aPoints();
       
                }else{
                   finalMessage.setText("Response : "+ REPONSE);
                   bonneResposte.setVisible(false);
                   mauvaiseResposte.setVisible(true);
                }
                   
                
                verifierButton.setDisable(true);
                reponseField.clear();
                lblQuestion.setText("énoncé");
                lbPoints.setText(getPoints());
            }
        });
        
        
        
        
        
        
        
        SuivantButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                  if(!flagRepondu){
                      String txt = "REPONSE : " + "énoncé"+  resultat;
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Resultat");
                        alert.setContentText(txt);
                        alert.showAndWait();
                        finalMessage.setText(" ");

                       // finalMessage.setText("REPONSE : " + getLabel()+  resultat);
                    mPoints(0.5);
                  }else{
                      finalMessage.setText(" ");
                  } 
                                    
                  
                  //Reinitialiser Valeurs
                  flagRepondu = false;
                  verifierButton.setDisable(false); 
                  bonneResposte.setVisible(false);
                  mauvaiseResposte.setVisible(false); 
                  reponseField.clear();
                  
                  //Reinitialiser Question et Label
                  initialiser();
                  lblQuestion.setText("enonce");
                  lbPoints.setText(getPoints());

            }
        });

     
    }
    
    
    
    
  
    
    public void initialiser(){
    
        //if(niveau.getNiveau() == 1){
        if(niveau == 1){
            questionNiveauI();        
        }else{
            questionNiveauII();
        }
        
       
               
   }

    public String getPoints(){    
    
        return    "Points :  "+ this.points + " ";
    }
    
    public void aPoints(){
        this.points++;
    }
    public void mPoints(double n){
        this.points-= n ;
    }
    
    public String getResultat(){
   
        return this.resultat;
    }
    
//   public String getLabel(){
//    
//        return  this.nb1 + " " + this.op + " " + this.nb2 + "  = ";
//
//    }
   
    
    
    public void questionNiveauI(){
        
         // Les instances de DAO
       // DAO<Question> questiondao = DAOFactory.getQuestionDAO();
       // DAO<User> userdao = DAOFactory.getUserDAO();
        
        System.out.println("Requêtes de sélection sur le niveau 1");
      
        
      
       
    }
   
    
   
    public void questionNiveauII(){
    
        System.out.println("Requêtes de sélection sur le niveau 2");
       

   }
    
    
   
   
    
 
    
   
    public boolean IsTrue(){
       
        return this.resultat.equalsIgnoreCase(reponse) ? true : false;
   }
  
    
   
    
  

public static void main(String[] args){
        launch();
    }
}