package code;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarProfesores {
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

        try (Connection conexion = Conexion.conectar();) {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM C1_PROFESORES p, C1_ESPECIALIDAD e  WHERE p.ESPECIALIDAD=e.ESPECIALIDAD AND e.ESPECIALIDAD=?");
            ps.setString(1, especialidad);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Nombre y Apellidos del profesor: " + rs.getString("NOMBRE_APE"));
                System.out.println("Especialidad: " + rs.getString("NOMBRE_ESPE"));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
