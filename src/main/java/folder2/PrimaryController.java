package folder2;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PrimaryController {
    @FXML
    private ImageView welcome_img; 
   
    @FXML
    private ImageView bg_img;
   
    @FXML
    public void initialize() {
        // Retrieve the stage from the scene (assuming this is set correctly)
        Scene scene = bg_img.getScene();
    

        // Use Platform.runLater to ensure this runs on the JavaFX Application thread
        Platform.runLater(() -> {
        if (bg_img != null) {
            // Bind the width and height of the ImageView to the Stage's width and height
            Util.bindImageHeight(bg_img, 1, 0);
           
            
                applyFloatingEffect(welcome_img, 1.0, 10);
               
            }
        });
    }
    
    @FXML
    private void switchToSecondary() throws IOException{
    App.setRoot("secondary");
    }

    private void applyFloatingEffect(ImageView imageView, double duration, int range) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), imageView);
        translateTransition.setByY(range);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
}