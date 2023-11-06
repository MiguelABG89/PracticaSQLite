package code;

import Clases.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class crearBD {
    private static List<Asignaturas> listaAsignaturas = new ArrayList<>();
    private static List<AsigProf> listaAsigProf = new ArrayList<>();
    private static List<Centros> listaCentros = new ArrayList<>();
    private static List<Especialidad> listaEspecialidad = new ArrayList<>();
    private static List<Profesores> listaProfesores = new ArrayList<>();
    private static final String URL = "jdbc:sqlite:src/main/resources/ProfesCentro.dat";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void crearBBDD(){

    }

    public static void cargarDatos(){
        //DATOS ASIGNATURAS
        List<String> cod = Arrays.asList("IF0001","IF0002","IF0003","IF0004","IF0006","IF0007");
        List<String> nombre = Arrays.asList("DAHC","RAL","IMSI","DPEG","PLE","FPE");


        for (int i=0; i<cod.size(); i++){
            Asignaturas asig = new Asignaturas(cod.get(i),nombre.get(i));
            listaAsignaturas.add(asig);
        }

        //DATOS ASIGPROF
        List<String> cod2 = Arrays.asList("IF0002","IF0003","IF0001","LG0001","LG0002","LG0003","LG0004","DB0001","DB0002","DB0003","MT0001","MT0001","MT0001","MT0002");
        List<Integer> codProf = Arrays.asList(1001,1001,1000,2000,2000,2003,2003,2002,2002,3000,1010,1011,1022,1010);

        for(int i=0; i<cod2.size(); i++){
            AsigProf ap = new AsigProf(cod2.get(i),codProf.get(i));
            listaAsigProf.add(ap);
        }

        //DATOS CENTROS
        List<Integer> codCentro = Arrays.asList(1000,1015,1022,1045,1050);
        List<String> nombreCentro = Arrays.asList("IES El Quijote","Los Danzantes","IES Planeta Tierra","CP Manuel Hidalgo","IES Antoñete");
        List<Integer> director = Arrays.asList(1000,1010,2000,null,null);
        List<String> direccion = Arrays.asList("Avda. Los Molinos 25","C/Las Musas s/n","C/Mina 45","C/Granada 5","C/Los Toreros 21");
        List<String> localidad = Arrays.asList("GUADALAJARA","PASTRANA","AZUQUECA","GUADALAJARA","SIGUENZA");
        List<String> provincia = Arrays.asList("GUADALAJARA","GUADALAJARA","GUADALAJARA","GUADALAJARA","GUADALAJARA");

        for(int i=0;i<cod.size();i++){
            Centros c = new Centros(codCentro.get(i),nombreCentro.get(i),director.get(i),direccion.get(i),localidad.get(i),provincia.get(i));
            listaCentros.add(c);
        }

        //DATOS ESPECIALIDAD
        List<String> especialidad = Arrays.asList("IF","IN","FQ","GH","TG","LG","DB","MT");
        List<String> nombreEspe = Arrays.asList("Informática","Inglés","Física y Química","Geografía e Historia","Tecnología","Lengua","Dibujo","Matemáticas");

        for(int i=0;i<especialidad.size();i++){
            Especialidad e = new Especialidad(especialidad.get(i),nombreEspe.get(i));
            listaEspecialidad.add(e);
        }

        //DATOS PROFESORES
        List<Integer> codProf2 = Arrays.asList(1000,1001,2002,3000,1010,1011,1022,2000,2003,1045);
        List<String> nom_Ape = Arrays.asList("Martínez Salas, Fernando","Bueno Zarco, Elisa","Rivera Silvestre, Ana","De Lucas Fdez, M.Angel","Montes García, M.Pilar","Arroba Conde, Manuel","Ruiz Lafuente, Manuel","Ramos Ruiz, Luis","Segura Molina, Irene","Serrano Laguía, María");
        List<String> especialidadProf = Arrays.asList("IF","IF","DB","DB","DB","MT","MT","MT","LG","IF");
        List<Integer> jefe = Arrays.asList(1001,null,3000,null,1011,null,1011,2003,null,null);
        List<String> f_Nac = Arrays.asList("1961-09-07","1960-02-17","1950-10-10","1980-09-09","1970-10-10","1970-10-12","1966-11-11","1963-08-08","1963-07-08","1976-01-02");
        List<String> sexo = Arrays.asList("H","M","M","M","M","H","H","H","M","M");
        List<Integer> cod_Centro = Arrays.asList(1000,1000,1000,1000,1015,1015,1015,1022,1022,1022);

        for(int i=0;i<cod.size();i++){
            Profesores p = new Profesores(codProf2.get(i),nom_Ape.get(i),especialidadProf.get(i),jefe.get(i),f_Nac.get(i),sexo.get(i),cod_Centro.get(i));
            listaProfesores.add(p);
        }

        //PreparedStatament para Asignaturas
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);){

            PreparedStatement psAsig = conexion.prepareStatement("INSERT INTO C1_ASIGNATURAS VALUES (?,?)");

            for(Asignaturas a : listaAsignaturas){

                psAsig.setString(1,a.getCod());
                psAsig.setString(2,a.getNombre());

                psAsig.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //PreparedStatament para AsigProf
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);){

            PreparedStatement psAsigProf = conexion.prepareStatement("INSERT INTO C1_ASIGPROF VALUES (?,?)");

            for(AsigProf ap : listaAsigProf){

                psAsigProf.setString(1,ap.getCod_Asig());
                psAsigProf.setInt(2,ap.getCod_Prof());

                psAsigProf.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //PreparedStatament para Centros
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);){

            PreparedStatement psCentros = conexion.prepareStatement("INSERT INTO C1_CENTROS VALUES (?,?,?,?,?,?)");

            for(Centros c : listaCentros){

                if(c.getCod()==null) psCentros.setString(1,null);
                else psCentros.setInt(1,c.getCod());

                psCentros.setString(2,c.getNombre());

                if(c.getDirector()==null) psCentros.setString(3,null);
                else psCentros.setInt(3,c.getDirector());

                psCentros.setString(4,c.getDireccion());
                psCentros.setString(5,c.getLocalidad());
                psCentros.setString(6,c.getProvincia());

                psCentros.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //PreparedStatament para Especialidad
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);){

            PreparedStatement psEsp = conexion.prepareStatement("INSERT INTO C1_ESPECIALIDAD VALUES (?,?)");

            for(Especialidad e : listaEspecialidad){

                psEsp.setString(1,e.getEspecialidad());
                psEsp.setString(2,e.getNombre());

                psEsp.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //PreparedStatament para Profesores
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);){

            PreparedStatement psProf = conexion.prepareStatement("INSERT INTO C1_PROFESORES VALUES (?,?,?,?,?,?,?)");

            for(Profesores p : listaProfesores){

                if(p.getCod_Prof()==null) psProf.setString(1,null);
                else psProf.setInt(1,p.getCod_Prof());

                psProf.setString(2,p.getNombre_Ape());
                psProf.setString(3,p.getEspecialidad());

                if(p.getJefe_Dep()==null) psProf.setString(4,null);
                else psProf.setInt(4,p.getJefe_Dep());

                psProf.setString(5,p.getF_Nac());
                psProf.setString(6,p.getSexo());

                if(p.getCod_Centro()==null) psProf.setString(7,null);
                else psProf.setInt(7,p.getCod_Centro());

                psProf.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
