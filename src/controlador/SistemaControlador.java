package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import modelo.CambiarEscenario;

import java.io.IOException;

public class SistemaControlador {

    @FXML
    private Button btnAtaz;

    @FXML
    void atrazAction() throws IOException {
       new CambiarEscenario("../vista/Acceder.fxml",btnAtaz);
    }
}
