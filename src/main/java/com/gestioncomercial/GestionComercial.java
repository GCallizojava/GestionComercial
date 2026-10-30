/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gestioncomercial;
import dao.PersonaDAOImpl;
import modelo.Persona;
import conexion.ConexionBD;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Optional;
/**
 *
 * @author Geovanny_Callizo
 */
public class GestionComercial {

    public static void main(String[] args) {
        PersonaDAOImpl dao = new PersonaDAOImpl();
        try {
    ConexionBD.inicializar();
    System.out.println("Base de datos inicializada.");
} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
    return;
}


Scanner sc = new Scanner(System.in);
int opcion;
do {
    System.out.println("\n===== GESTION COMERCIAL =====");
    System.out.println("1. Registrar persona");
    System.out.println("2. Listar personas");
    System.out.println("3. Buscar persona por ID");
    System.out.println("4. Actualizar persona");
    System.out.println("5. Eliminar persona");
    System.out.println("0. Salir");
    System.out.print("Seleccione una opcion: ");

    opcion = Integer.parseInt(sc.nextLine());
switch (opcion) {
    case 1:{
        System.out.println("REGISTRAR PERSONA");
        System.out.println("=== REGISTRO DE PERSONAS ===");

Persona p = new Persona();

System.out.print("Ingrese identidad: ");
p.setIdentidad(sc.nextLine());

System.out.print("Ingrese nombre: ");
p.setNombre(sc.nextLine());

System.out.print("Ingrese apellido: ");
p.setApellido(sc.nextLine());

System.out.print("Ingrese telefono: ");
p.setTelefono(sc.nextLine());

System.out.print("Ingrese correo: ");
p.setCorreo(sc.nextLine());

System.out.print("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
p.setFechaNacimiento(sc.nextLine());

dao.insertar(p);

System.out.println("Persona registrada correctamente");

        break;
    }
    case 2:
        System.out.println("LISTAR PERSONAS");
        for (Persona persona : dao.listar()) {
    System.out.println(persona);
}
        break;

    case 3: { System.out.println("BUSCAR PERSONA POR IDENTIDAD");

    System.out.print("Ingrese la identidad: ");
    String identidad = sc.nextLine().trim();

    Optional<Persona> resultado =
            dao.buscarPorIdentidad(identidad);

    if (resultado.isPresent()) {
        System.out.println("Persona encontrada:");
        System.out.println(resultado.get());
    } else {
        System.out.println("Persona no encontrada.");
    }

    break;
}

    case 4:
        System.out.println("ACTUALIZAR PERSONA");
        break;

    case 5:
        System.out.println("ELIMINAR PERSONA");
        break;

    case 0:
        System.out.println("Saliendo del sistema...");
        break;

    default:
        System.out.println("Opcion no valida");
}
} while (opcion != 0);



sc.close();
    }
}
