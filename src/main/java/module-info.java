module ntnu.adriawh {
    requires javafx.controls;
    requires javafx.fxml;

    opens ntnu.adriawh to javafx.fxml;
    exports ntnu.adriawh;
}