package com.TimeCraftIncorporate.Timecraft.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TimeCraftIncorporate.Timecraft.Model.Estado;
import com.TimeCraftIncorporate.Timecraft.Model.Evento;
import com.TimeCraftIncorporate.Timecraft.Model.Eventos;
import com.TimeCraftIncorporate.Timecraft.Model.Usuario;


@Repository
public interface RepositoryEventos extends JpaRepository<Eventos, Long> {

    //esto lo que hace es listar todas los eventos a los que fue invitado un usuario con el nombre del evento y su estado

    @Query("""
        SELECT  e.evento.titulo, e.usuario.nombre, e.estado.tipo FROM Eventos e 
         """)
    List<Object[]> findEventoConUsuarioYEstado();

    @Query("SELECT e FROM Eventos e")
    List<Eventos> findAllEventos();

    List<Eventos> findByIdEventos(Integer idEventos);

    List<Eventos> findByUsuario(Usuario idUsuario);

    List<Eventos> findByEstado(Estado idEstado);

    List<Eventos> findByEvento(Evento idEvento);
 
}
