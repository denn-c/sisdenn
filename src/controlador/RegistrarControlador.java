package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import modelo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarControlador implements Initializable {

    @FXML
    public ComboBox<String> cbxTipousuario;

    @FXML
    public Button btnRegistrar;

    @FXML
    public CheckBox ckbVercontrasenia1;

    @FXML
    public CheckBox ckbVercontrasenia2;
    public TextField txtContraseniavisible1;
    public PasswordField txtContrasenia1;
    public TextField txtContraseniavisible2;
    public PasswordField txtContrasenia2;
    public TextField txtNombresApellidos;
    public TextField txtCorreo;
    public TextField txtUsuario;
    public TextField txtDni;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Registrar registrar = new Registrar();
        cbxTipousuario.setItems(registrar.cargaTipoUsuario());
    }

    public void accionVercontrasenia(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(ckbVercontrasenia1)) {
            MostrarContrasenia mostrarContrasenia = new MostrarContrasenia(ckbVercontrasenia1, txtContrasenia1, txtContraseniavisible1);
            mostrarContrasenia.mostrar();
        }else if(actionEvent.getSource().equals(ckbVercontrasenia2)){
            MostrarContrasenia mostrarContrasenia = new MostrarContrasenia(ckbVercontrasenia2, txtContrasenia2, txtContraseniavisible2);
            mostrarContrasenia.mostrar();
        }
    }

    public void sincronizarContrasenia(KeyEvent event) {
        if(event.getSource().equals(txtContrasenia1) || event.getSource().equals(txtContraseniavisible1)){
            MostrarContrasenia mostrarContrasenia = new MostrarContrasenia(ckbVercontrasenia1, txtContrasenia1, txtContraseniavisible1);
            mostrarContrasenia.sincronizar(event);
        }else if(event.getSource().equals(txtContrasenia2) || event.getSource().equals(txtContraseniavisible2)){
            MostrarContrasenia mostrarContrasenia = new MostrarContrasenia(ckbVercontrasenia2, txtContrasenia2, txtContraseniavisible2);
            mostrarContrasenia.sincronizar(event);
        }
    }
    public void accionRegistar() throws IOException {
        Registrar registrar = new Registrar();
        Usuarios usuarios = new Usuarios();

        String contrasenia = txtContrasenia1.getText();
        String contrasenia_encriptada = EncriptarContrasenia.sha1(contrasenia);

        usuarios.setTipo_usuario(2);
        usuarios.setNombres_apellidos(txtNombresApellidos.getText());
        usuarios.setCorreo(txtCorreo.getText());
        usuarios.setUsuario(txtUsuario.getText());
        usuarios.setContrasenia(contrasenia_encriptada);
        usuarios.setDni(Integer.parseInt(txtDni.getText()));

        if(registrar.registrarUsuario(usuarios)){
            System.out.println("registro Exitoso");
        }else{
            System.out.println("Registro fallido");
        }
        new CambiarEscenario("../vista/Acceder.fxml", btnRegistrar);
    }
}