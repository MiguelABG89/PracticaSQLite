package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BorrarBD {
    public static void borrarBD(){
        Path archivo = Path.of(("target/ProfesCentro.dat"));
        System.out.println("BASE DE DATOS BORRADA");
        try {
            Files.delete(archivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
