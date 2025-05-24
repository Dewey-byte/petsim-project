package folder2;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    private static MediaPlayer mediaPlayer; // Declare the MediaPlayer
    public static ImageView bg_img;
    static Object mp;
   
    @Override
    public void start(Stage stage) throws IOException {
        // Load the initial scene
        scene = new Scene(loadFXML("primary"), 800, 600);
        stage.setScene(scene);
        stage.show();

        // Play background music
        playBackgroundMusic("D:\\petsim\\src\\main\\java\\folder2\\music_omads.mp3");
    }

    static void setRoot(String fxml) throws IOException {
        // Switch to the new scene
        scene.setRoot(loadFXML(fxml));

        // Resume background music for primary and secondary scenes
        if ((fxml.equals("primary") || fxml.equals("secondary")) && mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play();
            }
        }
        // Pause background music for other scenes
        else if (mediaPlayer != null && !fxml.equals("primary") && !fxml.equals("secondary") && !fxml.equals("tertiary")) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
            }
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private void playBackgroundMusic(String musicFile) {
        if (mediaPlayer == null) {
            // Get the path of the music file
            String musicPath = Paths.get(musicFile).toUri().toString();

            // Create a Media object
            Media media = new Media(musicPath);

            // Create a MediaPlayer object
            mediaPlayer = new MediaPlayer(media);

            // Configure the media player
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the music
        }
        mediaPlayer.play(); // Play the music
    }


        }
    

