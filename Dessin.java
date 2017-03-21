/*import java.util.function.Consumer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class Dessin extends Application {

	public static void main(String[] args) {
		launch(args);
	}

        
        
	static enum Pinceau {
		OVALE("Ovale"), RETANGLE("Retangle");

		private final String nome;

		private Pinceau(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return nome;
		}
	}




// uma interface funcional para manusear o context gráfico
	static interface ManipulationCont {
		public void configure(MouseEvent m, GraphicsContext ctx);
	}


	@Override
	public void start(Stage s) throws Exception {

		Canvas canvas = new Canvas(800, 600);
		// Canvas de sombra, para fazer a pré visualização de algumas coisas
		Canvas ombre = new Canvas(800, 600);
		
                
                BorderPane root = new BorderPane();
		ColorPicker couleurLigne = new ColorPicker();
		ColorPicker couleurFond = new ColorPicker();
		
                
		Slider sldEpaisseur = new Slider(1, 40, 20);
		ChoiceBox<Pinceau> pinceaux = new ChoiceBox<>();
		
		
		// configurações gerais
		pinceaux.getItems().addAll(Pinceau.values());
		
                
		sldEpaisseur.setShowTickMarks(true);
		pinceaux.getSelectionModel().select(0);
		couleurLigne.setValue(Color.BLACK);
		ombre.setDisable(true);

		// Organizando os controles do paint
		GridPane pnlControles = new GridPane();

		pnlControles.add(new Label("Ligne"), 0, 0);
		pnlControles.add(couleurLigne, 1, 0);

		pnlControles.add(new Label("Effacer"), 0, 1);
		pnlControles.add(couleurFond, 1, 1);

		pnlControles.add(new Label("Taille"), 0, 2);
		pnlControles.add(sldEpaisseur, 1, 2);

		pnlControles.add(new Label("Type de pinceau"), 0, 3);
		pnlControles.add(pinceaux, 1, 3);


		pnlControles.setVgap(10);
		pnlControles.setHgap(10);
		pnlControles.setTranslateX(2);
		pnlControles.setTranslateY(10);

		root.setLeft(pnlControles);
		root.setCenter(new Group(canvas, ombre));
		ombre.setOpacity(0.1);
 
                
		Consumer<GraphicsContext> effacer = ctx -> {
			ctx.setFill(couleurFond.getValue());
			ctx.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		};

                
                
                
                ManipulationCont manipulationCont = (e, ctx) -> {

                        double v = sldEpaisseur.getValue();
			Pinceau tipo = pinceaux.getValue();
			double x = e.getX() - v / 2;
			double y = e.getY() - v / 2;
                        
			Color selCorLinha = couleurLigne.getValue();

                        ctx.setFill(selCorLinha);
    			ctx.setStroke(selCorLinha);

                   
				switch (tipo) {
				case OVALE:
					ctx.fillOval(x, y, v, v);
					break;
				case RETANGLE:
					ctx.fillRect(x, y, v, v);
					break;
				default:
					break;
				}

			
		};

                
                
		EventHandler<? super MouseEvent> dessiner = e -> {
			GraphicsContext ctx;
			if (e.getEventType() == MouseEvent.MOUSE_MOVED) {
				ctx = ombre.getGraphicsContext2D();
				effacer.accept(ctx);
			} else {
				ctx = canvas.getGraphicsContext2D();
			}
			manipulationCont.configure(e, ctx);
		};

                
                
		canvas.setOnMouseDragged(dessiner);
		canvas.setOnMouseReleased(dessiner);
		canvas.setOnMousePressed(dessiner);
		canvas.setOnMouseMoved(dessiner);

		couleurFond.setOnAction(e -> effacer.accept(canvas.getGraphicsContext2D()));
		effacer.accept(canvas.getGraphicsContext2D());
		s.setScene(new Scene(new Pane(root)));
		s.show();
	}
}*/