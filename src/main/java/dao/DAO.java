/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

    void insertar(T objeto);

    void actualizar(T objeto);

    void eliminar(ID id);

    Optional<T> buscarPorId(ID id);
Optional<T> buscarPorIdentidad(String identidad);
    List<T> listar();
}
