/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlite:gestion.db";

    public static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void inicializar()
            throws SQLException {

        String sql = """
            CREATE TABLE IF NOT EXISTS personas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                identidad TEXT NOT NULL UNIQUE,
                nombre TEXT NOT NULL,
                apellido TEXT NOT NULL,
                telefono TEXT,
                correo TEXT,
                fecha_nacimiento TEXT
            )
            """;

        try (Connection con = getConnection();
             Statement stmt =
                     con.createStatement()) {

            stmt.execute(sql);
            System.out.println(
                "Base de datos inicializada correctamente"
            );
        }
    }
}
