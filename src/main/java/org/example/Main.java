package org.example;

import code.BorrarBD;
import code.CrearBD;
import code.InsertarProfesor;
import code.ListarProfesores;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir");
            System.out.println("1. Crear BD y cargar datos");
            System.out.println("2. Borrar BD");
            System.out.println("3. Listar profesores");
            System.out.println("4. Insertar Profesor");

            opcion = libs.Leer.pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> {salir = true;}
                case "1" -> {
                    CrearBD.crearBBDD();
                    CrearBD.cargarDatos();
                }
                case "2" -> {
                    BorrarBD.borrarBD();
                }
                case "3" -> {
                    ListarProfesores.listarProfesores();
                }
                case "4"->{
                    InsertarProfesor.insertarProfesor();
                }
                default -> {System.out.println("Opción incorrecta");}
            }
        }while (!salir);
    }
}