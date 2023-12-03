package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BorrarBD {
    public static void borrarBD(){
        Path archivo = Path.of(("target/ProfesCentro.dat"));

        try {
            //sentencia delete para borrar la base de datos que se encuentra en un archivo
            Files.delete(archivo);
            System.out.println("BASE DE DATOS BORRADA");
        } catch (IOException e) {
            System.out.println("Error al intentar Borrar el archivo: "+ e.getMessage());
        }
    }


}
