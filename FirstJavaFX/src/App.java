

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
 
public class App extends Application {
    private int totalBottle = 0;
    private Label statusLabel; 
    private Button addBottleButton, removeBottleButton;

    @Override
    public void start(Stage stage) throws Exception {
        // StackPane root = new StackPane();
        // Polygon g = new Polygon(0, 0, 100, 200, 200, 100);
        // Polygon p = new Polygon();

        // root.getChildren().add(new Rectangle(200, 200, Color.GREENYELLOW));
        // root.getChildren().add(new Circle(100, Color.AQUAMARINE));
        // g.setFill(Color.BURLYWOOD);
        // root.getChildren().add(g);
        // // p.getPoints().addAll(new Double[]{
        // //      100.0, 100.0,
        // //      100.0, 200.0,
        // //      200.0, 150.0 });
        // // p.setFill(Color.AQUA);     
        // // root.getChildren().add(p);
        // root.getChildren().add(new Label("Mon label"));
        VBox root = new VBox(10);
        
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);
        stage.setTitle("Compteur de bouteilles");
        statusLabel = new Label("Nombre de bouteilles: " + totalBottle + " Bouteille");
        ImageView heartBlack = new ImageView(getClass().getResource("Assets/heart1.png").toString());
        heartBlack.setFitHeight(30);
        heartBlack.setFitWidth(30);
        heartBlack.setPreserveRatio(true);

        ImageView heartRed = new ImageView(getClass().getResource("Assets/heart2.png").toString());
        heartRed.setFitHeight(30);
        heartRed.setFitWidth(30);
        heartRed.setPreserveRatio(true);

        ImageView dislikeFull = new ImageView(getClass().getResource("Assets/dislike2.png").toString());
        dislikeFull.setFitHeight(30);
        dislikeFull.setFitWidth(30);
        dislikeFull.setPreserveRatio(true);

        ImageView dislikeHollow = new ImageView(getClass().getResource("Assets/dislike1.png").toString());
        dislikeHollow.setFitHeight(30);
        dislikeHollow.setFitWidth(30);
        dislikeHollow.setPreserveRatio(true);
        
        addBottleButton = new Button("Ajouter Bouteille");
        addBottleButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                totalBottle++;
                statusLabel.setText("Nombre de bouteilles: " + totalBottle);
                if (totalBottle <= 1)
                    statusLabel.setText("Nombre de bouteilles: " + totalBottle + " Bouteille");
                else
                    statusLabel.setText("Nombre de bouteilles: " + totalBottle + " Bouteilles");

            }
        });
        addBottleButton.setGraphic(heartBlack);
        addBottleButton.setOnMouseEntered(e -> addBottleButton.setGraphic(heartRed));
        addBottleButton.setOnMouseExited(e -> addBottleButton.setGraphic(heartBlack));
        removeBottleButton = new Button("Retirer une bouteille");
        removeBottleButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                if (totalBottle > 0)
                    totalBottle--;
                if (totalBottle <= 1)
                    statusLabel.setText("Nombre de bouteilles: " + totalBottle + " Bouteille");
                else
                    statusLabel.setText("Nombre de bouteilles: " + totalBottle + " Bouteilles");
            }
        });
        removeBottleButton.setGraphic(dislikeHollow);
        removeBottleButton.setOnMouseEntered(e -> removeBottleButton.setGraphic(dislikeFull));
        removeBottleButton.setOnMouseExited(e -> removeBottleButton.setGraphic(dislikeHollow));
        root.getChildren().addAll(statusLabel, addBottleButton, removeBottleButton);
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);

        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
