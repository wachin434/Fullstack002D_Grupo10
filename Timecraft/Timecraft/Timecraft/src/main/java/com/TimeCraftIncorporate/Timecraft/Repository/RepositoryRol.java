package com.TimeCraftIncorporate.Timecraft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeCraftIncorporate.Timecraft.Model.Rol;

import java.util.List;

@Repository
public interface RepositoryRol extends JpaRepository<Rol, Long> {

    List<Rol> findByIdRol(Integer idRol);

    List<Rol> findByNombre(String nombre);

    

}
