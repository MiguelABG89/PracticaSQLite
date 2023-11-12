package code;

import Clases.Profesores;
import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class InsertarProfesor {
    public static void insertarProfesor() {

        String especialidaComprobacion = "";
        Integer centroComprobacion = 0;

        Integer cod_Prof = Leer.pedirEntero("Código del profesor : ");
        String nombre_Ape = Leer.pedirCadena("Nombre y Apellidos del profesor : ");
        String especialidad = Leer.pedirCadena("Código de especialidad impartida por el profesor : ");
        Integer jefe_Dep = Leer.pedirEntero("Código del jefe de departamento : ");
        String f_Nac = Leer.pedirCadena("Fecha de nacimiento del profesor : ");
        String sexo = Leer.pedirCadena("Sexo del profesor : ");
        Integer cod_Centro = Leer.pedirEntero("Código del centro en el que trabaja el profesor : ");
        Profesores profe = new Profesores(cod_Prof, nombre_Ape, especialidad, jefe_Dep, f_Nac, sexo, cod_Centro);
        List<Profesores> listaProfes = Arrays.asList(profe);


        try (Connection conexion = Conexion.conectar();) {

            PreparedStatement psProfesor = conexion.prepareStatement("INSERT INTO C1_PROFESORES VALUES (?,?,?,?,?,?,?)");
            //PreparedStatement ps = conexion.prepareStatement("SELECT NOMBRE_ESPE FROM C1_ESPECIALIDAD e  WHERE e.NOMBRE_ESPE=?");
            PreparedStatement ps2 = conexion.prepareStatement("SELECT COD_CENTRO  FROM C1_CENTROS e  WHERE e.COD_CENTRO=?");

            //ps.setString(1, especialidad);
            ps2.setInt(1, cod_Centro);
            //ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();

            //while (rs.next()){
              //  especialidaComprobacion= rs.getString("NOMBRE_ESPE");
            //}
            while (rs2.next()){
                centroComprobacion= rs2.getInt("COD_CENTRO");
            }

            if (centroComprobacion == 0) {
                System.out.println("El centro seleccionado no existe");
            } /*else if (!especialidaComprobacion.equals("")) {
                System.out.println("La especialidad seleccionada no existe");
            } */else {
                psProfesor.setInt(1, profe.getCod_Prof());
                psProfesor.setString(2, profe.getNombre_Ape());
                psProfesor.setString(3, profe.getEspecialidad());
                psProfesor.setInt(4, profe.getJefe_Dep());
                psProfesor.setString(5, profe.getF_Nac());
                psProfesor.setString(6, profe.getSexo());
                psProfesor.setInt(7, profe.getCod_Centro());

                psProfesor.executeUpdate();
                System.out.println("Profesor nuevo insertado");
            }

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
