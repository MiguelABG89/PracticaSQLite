package code;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarProfesores {
    //Clase para listar los profesores segun la especialidad
    public static void listarProfesores() {

        String especialidad = Leer.pedirCadena("Elige entre una de las siguientes especialidades : \n" +
                "IF : Informática\n" +
                "IN : Inglés\n" +
                "FQ : Física y Química\n" +
                "GH : Geografía e Historia\n" +
                "TG : Tecnología\n" +
                "LG : Lengua\n" +
                "DB : Dibujo\n" +
                "MT : Matemáticas");

        //Inicio de la conexion para realizar el listado
        try (Connection conexion = Conexion.conectar();) {
            //PreparedStatamennt para Buscar la especializacion introducida por el usuario
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM C1_PROFESORES p, C1_ESPECIALIDAD e  WHERE p.ESPECIALIDAD=e.ESPECIALIDAD AND e.ESPECIALIDAD=?");
            ps.setString(1, especialidad);
            //ResultSet para ejecutar la Query
            ResultSet rs = ps.executeQuery();

            //Bucle while para mostrar los datos
            while (rs.next()) {
                System.out.println("Nombre y Apellidos del profesor: " + rs.getString("NOMBRE_APE"));
                System.out.println("Especialidad: " + rs.getString("NOMBRE_ESPE"));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión. " + e.getMessage());
        }
    }
}
