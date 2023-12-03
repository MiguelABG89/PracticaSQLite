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
    //Clase para insertar un nuevo profesor
    public static void insertarProfesor() {
        //generacion de variables para usar
        boolean CodProfValido = false;
        boolean EspecialidaValida = false;
        boolean CodCentroValida = false;
        Integer cod_Prof;
        String especialidad;
        Integer cod_Centro;

        //Inicio de la conexion
        try (Connection conexion = Conexion.conectar();) {
            //Do-while para hacer que el usuario introduzca un cod_prof que no exista para que no de error de integridad
            do{
                cod_Prof = Leer.pedirEntero("Código del profesor : ");
                PreparedStatement psCodProfe = conexion.prepareStatement("SELECT COD_PROF FROM C1_PROFESORES WHERE COD_PROF = ?");
                psCodProfe.setInt(1,cod_Prof);
                ResultSet rs = psCodProfe.executeQuery();
                if (rs.next()){
                    System.out.println("El codigo ya existe");
                }else {
                    CodProfValido=true;
                }
            }while (CodProfValido==false);

            String nombre_Ape = Leer.pedirCadena("Nombre y Apellidos del profesor : ");
            //Do-while para hacer que el usuario introduzca una especialidad que exista para que no de error de integridad
            do{
                especialidad = Leer.pedirCadena("Introduce la especialidad que imparte el profesor : \n" +
                        "IF : Informática\n" +
                        "IN : Inglés\n" +
                        "FQ : Física y Química\n" +
                        "GH : Geografía e Historia\n" +
                        "TG : Tecnología\n" +
                        "LG : Lengua\n" +
                        "DB : Dibujo\n" +
                        "MT : Matemáticas");
                PreparedStatement psEspe = conexion.prepareStatement("SELECT ESPECIALIDAD FROM C1_ESPECIALIDAD WHERE ESPECIALIDAD = ?;");
                psEspe.setString(1,especialidad);
                ResultSet rs = psEspe.executeQuery();
                if (!rs.next()){
                    System.out.println("La especialidad no existe");
                }else {
                    EspecialidaValida=true;
                }
            }while (EspecialidaValida==false);

            Integer jefe_Dep = Leer.pedirEntero("Código del jefe de departamento : ");
            String f_Nac = Leer.pedirCadena("Fecha de nacimiento del profesor : ");
            String sexo = Leer.pedirCadena("Sexo del profesor : ");

            //Do-while para hacer que el usuario introduzca un cod_centro que exista para que no de error de integridad
            do{
                cod_Centro = Leer.pedirEntero("Código del centro en el que trabaja el profesor : ");
                PreparedStatement psCodCentro = conexion.prepareStatement("SELECT COD_CENTRO FROM C1_CENTROS WHERE COD_CENTRO = ?;");
                psCodCentro.setInt(1,cod_Centro);
                ResultSet rs = psCodCentro.executeQuery();
                if (!rs.next()){
                    System.out.println("El codigo del centro no existe");
                }else {
                    CodCentroValida=true;
                }
            }while (CodCentroValida==false);

            //PreparedStatament para crear el profesor con los datos validados
            PreparedStatement psProfesor = conexion.prepareStatement("INSERT INTO C1_PROFESORES VALUES (?,?,?,?,?,?,?)");
            psProfesor.setInt(1, cod_Prof);
            psProfesor.setString(2,nombre_Ape);
            psProfesor.setString(3, especialidad);
            psProfesor.setInt(4, jefe_Dep);
            psProfesor.setString(5, f_Nac);
            psProfesor.setString(6, sexo);
            psProfesor.setInt(7, cod_Centro);
            psProfesor.execute();

        } catch (SQLException e) {
            System.out.println("Error en la conexión. " + e.getMessage());
        }
    }
}
