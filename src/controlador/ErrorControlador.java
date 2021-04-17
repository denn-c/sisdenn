package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorControlador {

    @FXML
    public ImageView imgTipo;

    @FXML
    public Label lbTitulo;

    @FXML
    public TextArea txaDescripcion;



    public void cargarVentana(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vista/Error.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void accionAceptar() {
    }
}
