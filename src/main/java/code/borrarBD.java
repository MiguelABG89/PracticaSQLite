package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class borrarBD {
    public static void borrarBD(){
        Path archivo = Path.of(("src/main/resources/ProfesCentro.dat"));

        try {
            Files.delete(archivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
