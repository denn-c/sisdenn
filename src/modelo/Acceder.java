package modelo;

import java.sql.*;

public class Acceder {
    ConeccionBasedatos coneccionBasedatos = new ConeccionBasedatos();
    Connection miconeccion = coneccionBasedatos.estableceConeccion();

    public boolean verificarAcceso(Usuarios usuarios) {

        try {
            Statement sentencia = miconeccion.createStatement();
            String sql = "SELECT idusuario, idtipo_usuario, nombres_apellidos, correo, usuario, contrasenia FROM usuario where usuario = ?";
            sentencia.setQueryTimeout(30);
            PreparedStatement preparacionDeclarada = miconeccion.prepareStatement(sql);
            preparacionDeclarada.setString(1,usuarios.getUsuario());
            ResultSet resultados = preparacionDeclarada.executeQuery();

            if (resultados.next()) {
                if(usuarios.getContrasenia().equals(resultados.getString(6))){
                    usuarios.setId(resultados.getInt(1));
                    usuarios.setNombres_apellidos(resultados.getString(3));
                    usuarios.setTipo_usuario(resultados.getInt(2));
                    return true;
                }
               return false;
            } return false;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } finally {
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
