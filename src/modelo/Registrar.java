package modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Registrar {

    ConeccionBasedatos coneccionBasedatos = new ConeccionBasedatos();
    Connection miconeccion = coneccionBasedatos.estableceConeccion();

    public ObservableList<String> cargaTipoUsuario(){
        ObservableList<String> tipo_usuario = FXCollections.observableArrayList();

        try {
            Statement sentencia=miconeccion.createStatement();
            sentencia.setQueryTimeout(30);
            ResultSet resultados = sentencia.executeQuery("SELECT * FROM tipo_usuario;");
            while (resultados.next()) {
                tipo_usuario.add(resultados.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos al combobox\n"+e.getMessage());
        }finally {
            try {
                if (miconeccion != null) {
                    miconeccion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
       return tipo_usuario;
    }

    public boolean registrarUsuario(Usuarios usuarios){
        String sql = "INSERT INTO usuario (idtipo_usuario,nombres_apellidos, correo, usuario, contrasenia, dni) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparacionDeclarada = miconeccion.prepareStatement(sql);
            preparacionDeclarada.setInt(1,usuarios.getTipo_usuario());
            preparacionDeclarada.setString(2,usuarios.getNombres_apellidos());
            preparacionDeclarada.setString(3, usuarios.getCorreo());
            preparacionDeclarada.setString(4,usuarios.getUsuario());
            preparacionDeclarada.setString(5,usuarios.getContrasenia());
            preparacionDeclarada.setInt(6,usuarios.getDni());
            preparacionDeclarada.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (miconeccion != null) {
                    miconeccion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
