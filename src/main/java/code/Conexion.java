package code;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:sqlite:target/ProfesCentro.dat";
    public static Connection conectar() {

        Connection conexion = null;
        try {
            //si la base de datos no existe la crea.
            conexion = DriverManager.getConnection((URL));
            System.out.println("Conexión OK.");

        }catch (SQLException e) {
            System.out.println("Error en la conexión. " + e.getMessage());
        } catch (InvalidModuleDescriptorException e) {
            System.out.println("Error PAM");
        }
        return conexion;
    }
}
