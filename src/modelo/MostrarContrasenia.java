package modelo;

import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MostrarContrasenia {

    private final CheckBox verContrasenia;
    private final PasswordField contrasenia;
    private final TextField contraseniaVisible;

    public CheckBox getVerContrasenia() {
        return verContrasenia;
    }

    public PasswordField getContrasenia() {
        return contrasenia;
    }

    public TextField getContraseniaVisible() {
        return contraseniaVisible;
    }
    public MostrarContrasenia(CheckBox verContrasenia, PasswordField contrasenia, TextField contraseniaVisible) {
        this.verContrasenia = verContrasenia;
        this.contrasenia = contrasenia;
        this.contraseniaVisible = contraseniaVisible;
    }

    public void mostrar() {
        if(getVerContrasenia().isSelected()){
            getContraseniaVisible().setText(getContrasenia().getText());
            getContrasenia().setVisible(false);
            getContraseniaVisible().setVisible(true);
            getContraseniaVisible().requestFocus();
            getContraseniaVisible().selectEnd();
        }else{
            getContrasenia().setText(getContraseniaVisible().getText());
            getContraseniaVisible().setVisible(false);
            getContrasenia().setVisible(true);
            getContrasenia().requestFocus();
            getContrasenia().selectEnd();
        }
    }
    public void sincronizar(KeyEvent evento){
        if(evento.getSource().equals(getContrasenia())){
            getContraseniaVisible().setText(getContrasenia().getText());
        }else if(evento.getSource().equals(getContraseniaVisible())){
            getContrasenia().setText(getContraseniaVisible().getText());
        }
    }


}
