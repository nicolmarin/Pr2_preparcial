package co.edu.uniquindio.parcial2.pr2_parcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrestamoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrestamoApplication.class.getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Prestamo!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}