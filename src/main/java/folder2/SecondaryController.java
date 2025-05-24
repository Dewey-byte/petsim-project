package folder2;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SecondaryController {

    @FXML ImageView bg_img;

    @FXML ImageView select_img;
    
   
    

        // Use Platform.runLater to ensure this runs on the JavaFX Application thread
        public void initialize() {
            // Use Platform.runLater to ensure the bindings happen after the scene is set
            Platform.runLater(() -> {
                if (bg_img != null) {
                    bg_img.fitHeightProperty().bind(App.scene.heightProperty());
                    applyFloatingEffect(select_img, 1.0, 5);
        }
     });
}

    @FXML
    private void switchToTertiary() throws IOException {
        App.setRoot("tertiary");
    }

    private void applyFloatingEffect(ImageView imageView, double duration, int range) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), imageView);
        translateTransition.setByY(range);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
}
