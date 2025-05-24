module folder2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    
    opens folder2 to javafx.fxml;
    exports folder2;
}
