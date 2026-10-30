/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Persona {

    private int id;
    private String identidad;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String fechaNacimiento;

   
    public Persona() {
    }

    // Constructor completo
    public Persona(int id, String identidad,
            String nombre, String apellido,
            String telefono, String correo,
            String fechaNacimiento) {

        this.id = id;
        setIdentidad(identidad);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setCorreo(correo);
        setFechaNacimiento(fechaNacimiento);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        this.id = id;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        if (identidad == null ||
                !identidad.matches("[0-9]{13}")) {
            throw new IllegalArgumentException(
                "La identidad debe tener 13 digitos");
        }
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre es obligatorio");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException(
                "El apellido es obligatorio");
        }
        this.apellido = apellido.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && !correo.isBlank()
                && !correo.contains("@")) {
            throw new IllegalArgumentException(
                "El correo debe contener @");
        }
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", identidad='" + identidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}

