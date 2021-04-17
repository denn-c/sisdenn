package modelo;

import controlador.ErrorControlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionBasedatos {

    Connection coneccion = null;

    public Connection estableceConeccion() {
        try {
            coneccion = DriverManager.getConnection("jdbc:mysql://localhost/sisdenn", "roo", "");
        } catch (SQLException e) {
            ErrorControlador errorControlador = new ErrorControlador();
            errorControlador.cargarVentana();
        }
        return coneccion;
    }
}

