package calculer;

/*
 *-------------------------- 
 * @author FABYO CARDOSO
 *--------------------------
 * JavaFX Jeaux Enfants
 * 2017
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;




public class Calcule  extends Application {
        
    
    private int resultat = 0;
    private String op = "";
    private int reponse = 0;
    private int nb1 = 0;
    private int nb2 = 0;
    private double points = 0;
    
    private Niveau niveau = Niveau.getInstance();
    private boolean flagRepondu = false;
    private Alert alert = new Alert(AlertType.WARNING);
    private String txtNiveau;
    
    
    public void start(Stage primaryStage) {
       
        
        initialiser();
        primaryStage.setTitle("Jeux d'Enfants");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(pane, 300, 275);

        scene.getStylesheets().add("Calcule/styleCalc.css");
        
        if(niveau.getNiveau() == 1){
        txtNiveau = "------------- NIVEAU I -------------";
        }else{
        txtNiveau = "------------- NIVEAU II ------------";
        }
            
        Text sceneTitle = new Text(txtNiveau);
        
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL,15));
        sceneTitle.setTextAlignment(TextAlignment.CENTER);
        pane.add(sceneTitle, 0, 0, 2, 1);
        
        
        Label lblQuestion = new Label(getLabel());
        pane.add(lblQuestion, 0, 1);
        
        
        final TextField totalField = new TextField();
        pane.add(totalField, 1, 1);
       
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, -15));
        hbox.setSpacing(10);    
        
        Button calculateButton = new Button("Entrer");        
        Button SuivantButton = new Button("Suivant");    
        
            hbox.getChildren().addAll(calculateButton, SuivantButton);

        calculateButton.getStyleClass().add("btn");
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
        
        
     
        
        
        
        calculateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                String regex = "[a-zA-Z]";
                int NB = (totalField.getText()).equals("") || isAlphabetic(totalField.getText().toString()) ? 0 : Integer.parseInt(totalField.getText());
              
                if(NB == resultat){
                   finalMessage.setText("Response : "+ NB);
                   mauvaiseResposte.setVisible(false); 
                   bonneResposte.setVisible(true);
                  flagRepondu = true;
                  aPoints();
        
                }else{
                   finalMessage.setText("Response : "+ NB);
                   bonneResposte.setVisible(false);
                   mauvaiseResposte.setVisible(true);
                }
                   
                
                calculateButton.setDisable(true);
                totalField.clear();
                lblQuestion.setText(getLabel());
                lbPoints.setText(getPoints());
            }
        });
        
        
        
        
        
        
        
        SuivantButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                  if(!flagRepondu){
                      String txt = "REPONSE : " + getLabel()+  resultat;
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
                  calculateButton.setDisable(false); 
                  bonneResposte.setVisible(false);
                  mauvaiseResposte.setVisible(false); 
                  totalField.clear();
                  
                  //Reinitialiser Calcule et Label
                  initialiser();
                  lblQuestion.setText(getLabel());
                  lbPoints.setText(getPoints());

            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    
  
    
    public void initialiser(){
    
        if(niveau.getNiveau() == 1){
            calculerNiveauI();        
        }else{
            calculerNiveauII();
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
    
    public int getResultat(){
    
        return this.resultat;
    }
    
    public String getLabel(){
    
        return  this.nb1 + " " + this.op + " " + this.nb2 + "  = ";

    }
   
    
    
    public void calculerNiveauI(){
    
        Random gerador = new Random();
        this.nb1 = gerador.nextInt(10);
        this.nb2 = gerador.nextInt(10);
 
        if(nb1 > nb2){
             op= "-";
             resultat = nb1-nb2;  
        }else{
             op= "+";
             resultat = nb1+nb2;  
        }
       
    }
    
    
    
    public void calculerNiveauII(){
    
        Random gerador = new Random();
        this.nb1 = gerador.nextInt(1000);
        this.nb2 = gerador.nextInt(1000);
 
        switch(Operateur.randomOperateur().toString()){
        
            case "*" : this.nb1 = gerador.nextInt(10);
                        if(nb1 == 0)nb1=1;
                        resultat = nb1 * nb2;
                        op = "x";
                break;
            case "-" : resultat = nb1 - nb2;
                        op = "-";
                break;
            default: resultat = nb1 + nb2;
                        op = "+";
                break;
        }
        

    }
    
    
    
    static enum Operateur {SOMME("+"), SOUSTRACTION("-"), MULTIPLICATION("*");

                private final String txt;

		private  Operateur(String txt) {
			this.txt = txt;
		}

		@Override
		public String toString() {
			return txt;
		}
  
                private static final List<Operateur> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
                private static final int SIZE = VALUES.size();
                private static final Random RANDOM = new Random();

                public static Operateur randomOperateur()  {
                
                    return VALUES.get(RANDOM.nextInt(SIZE));
                }
    }
    
 
    
    
    public boolean IsTrue(){
       
        return (this.resultat == this.reponse)? true : false;
    }
  
    
    
    public boolean isAlphabetic(String temp){
        int i = 0;
   
        while( i < temp.length()) {
          if (Character.isAlphabetic(temp.charAt(i)))
               return true;
      
           i++;
     }
         
    return false;
    
    }
    
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}