package com.TimeCraftIncorporate.Timecraft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TimeCraftIncorporate.Timecraft.Model.Usuario;

import java.util.List;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    //esto es para consultas mas especificas sobre el usuario y su rol
    @Query("""
         SELECT u.nombre, u.rol.nombre FROM Usuario u
        """)
    List<Object[]> findUsuarioYRol();
    
    // con esto se busca por todas sus clases
    List<Usuario> findByIdUsuario(Integer idUsuario);

    List<Usuario> findByNombre(String nombre);
    
    List<Usuario> findByApellido(String apellido);

    List<Usuario> findByCorreo(String correo);







}  



