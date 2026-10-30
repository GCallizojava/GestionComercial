/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import modelo.Persona;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonaDAOImpl implements DAO<Persona,Integer> {
@Override
public void insertar(Persona persona) {

    String sql = """
        INSERT INTO personas
        (identidad, nombre, apellido,
         telefono, correo, fecha_nacimiento)
        VALUES (?, ?, ?, ?, ?, ?)
        """;

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(
             sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, persona.getIdentidad());
        ps.setString(2, persona.getNombre());
        ps.setString(3, persona.getApellido());
        ps.setString(4, persona.getTelefono());
        ps.setString(5, persona.getCorreo());
        ps.setString(6, persona.getFechaNacimiento());

        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                persona.setId(rs.getInt(1));
            }
        }

        System.out.println("Persona registrada correctamente.");

    } catch (SQLException e) {
        throw new RuntimeException(
            "Error al insertar persona: " + e.getMessage(), e);
    }

}


   
       @Override
public List<Persona> listar() {
    List<Persona> personas = new ArrayList<>();
    String sql = "SELECT * FROM personas";
    try (Connection con = ConexionBD.getConnection();
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery())
    {
while (rs.next()) {
    Persona p = new Persona();

    p.setId(rs.getInt("id"));
    p.setIdentidad(rs.getString("identidad"));
    p.setNombre(rs.getString("nombre"));
    p.setApellido(rs.getString("apellido"));
    p.setTelefono(rs.getString("telefono"));
    p.setCorreo(rs.getString("correo"));
    p.setFechaNacimiento(rs.getString("fecha_nacimiento"));

    personas.add(p);
}
}
catch (SQLException e) {
    throw new RuntimeException(
        "Error al listar personas: " + e.getMessage(), e);
}
    return personas;
}

    

 
    @Override
public void actualizar(Persona objeto) {

    String sql = """
        UPDATE personas
        SET identidad = ?, nombre = ?, apellido = ?,
            telefono = ?, correo = ?, fecha_nacimiento = ?
        WHERE id = ?
        """;

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, objeto.getIdentidad());
        ps.setString(2, objeto.getNombre());
        ps.setString(3, objeto.getApellido());
        ps.setString(4, objeto.getTelefono());
        ps.setString(5, objeto.getCorreo());
        ps.setString(6, objeto.getFechaNacimiento());
        ps.setInt(7, objeto.getId());

        int filas = ps.executeUpdate();

        System.out.println("Personas actualizadas: " + filas);

    } catch (SQLException e) {
        throw new RuntimeException(
            "Error al actualizar persona: " + e.getMessage(), e);
    }
}

    
    @Override
public void eliminar(Integer id) {

  String sql = "SELECT * FROM personas WHERE id = ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1,id);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("No se encontró la persona.");
        }

    } catch (SQLException e) {
        throw new RuntimeException(
            "Error al eliminar persona: " + e.getMessage(), e);
    }
}
    
@Override
public Optional<Persona> buscarPorId(Integer id) {

    String sql = "SELECT * FROM personas WHERE id = ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                Persona p = new Persona();

                p.setId(rs.getInt("id"));
                p.setIdentidad(rs.getString("identidad"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                p.setFechaNacimiento(
                    rs.getString("fecha_nacimiento"));

                return Optional.of(p);
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException(
            "Error al buscar persona por ID: "
            + e.getMessage(), e);
    }

    return Optional.empty();
}
@Override
public Optional<Persona> buscarPorIdentidad(String identidad) {

    String sql = "SELECT * FROM personas WHERE identidad = ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, identidad);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                Persona p = new Persona();

                p.setId(rs.getInt("id"));
                p.setIdentidad(rs.getString("identidad"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                p.setFechaNacimiento(
                    rs.getString("fecha_nacimiento"));

                return Optional.of(p);
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException(
            "Error al buscar por identidad: "
            + e.getMessage(), e);
    }

    return Optional.empty();
}
}
