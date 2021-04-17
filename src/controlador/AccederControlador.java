package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelo.*;

public class AccederControlador {

    @FXML
    public Button btnRegistrarse;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtContraseniavisible;

    @FXML
    public CheckBox ckbVercontrasenia;

    @FXML
    void accionAcceder() {
        Acceder acceder = new Acceder();
        Usuarios usuarios = new Usuarios();

        String contrasenia = EncriptarContrasenia.sha1(txtContrasenia.getText());
        usuarios.setUsuario(txtUsuario.getText());
        usuarios.setContrasenia(contrasenia);
        try {
            if (acceder.verificarAcceso(usuarios)) {
                new CambiarEscenario("../vista/Sistema.fxml", btnRegistrarse);
            } else {
                new CambiarEscenario("../vista/Error.fxml", btnRegistrarse);
            }
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void accionVercontrasenia() {
        MostrarContrasenia mostrarContrasenia = new MostrarContrasenia(ckbVercontrasenia, txtContrasenia, txtContraseniavisible);
        mostrarContrasenia.mostrar();
    }

    @FXML
    void sincronizarContrasenia(KeyEvent evento) {
        MostrarContrasenia mostrarContrasenia = new MostrarContrasenia(ckbVercontrasenia, txtContrasenia, txtContraseniavisible);
        mostrarContrasenia.sincronizar(evento);
    }

    public void accionRegistrarse() {
        new CambiarEscenario("../vista/Registrar.fxml", btnRegistrarse);
    }
}
