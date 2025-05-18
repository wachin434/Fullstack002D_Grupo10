package com.TimeCraftIncorporate.Timecraft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeCraftIncorporate.Timecraft.Model.Evento;

import java.util.List;
import java.sql.Date;

@Repository
public interface RepositoryEvento extends JpaRepository<Evento, Long> {

    List<Evento> findByIdEvento(Integer idEvento);

    List<Evento> findByFecha(Date fecha);
    



}
