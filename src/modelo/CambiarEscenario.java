package modelo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CambiarEscenario {

    public CambiarEscenario(String resource, Button boton){
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource(resource));
            Stage primaryStage = (Stage) boton.getScene().getWindow();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
