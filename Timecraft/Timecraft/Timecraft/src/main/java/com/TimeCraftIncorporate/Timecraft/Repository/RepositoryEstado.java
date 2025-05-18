package com.TimeCraftIncorporate.Timecraft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeCraftIncorporate.Timecraft.Model.Estado;

import java.util.List;

@Repository
public interface RepositoryEstado extends JpaRepository<Estado, Long> {

    List<Estado> findByIdEstado(Integer idEstado);

    //tipo se refiere Aceptado, Rechazado, pendiante.
    List<Estado> findByTipo(String tipo);




}
