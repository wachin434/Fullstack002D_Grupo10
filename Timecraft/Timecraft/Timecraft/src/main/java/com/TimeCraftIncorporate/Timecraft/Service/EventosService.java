package com.TimeCraftIncorporate.Timecraft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeCraftIncorporate.Timecraft.Model.Eventos;
import com.TimeCraftIncorporate.Timecraft.Repository.RepositoryEventos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventosService {

    @Autowired
    private RepositoryEventos repositoryEventos;

    public List<Eventos> findAll(){
        return repositoryEventos.findAll();
    }

    public Eventos findById(long idEventos){
        return repositoryEventos.findById(idEventos).orElse(null);
    }

    public Eventos save(Eventos eventos){
        return repositoryEventos.save(eventos);
    }

    public void delete(long idEventos){
        repositoryEventos.deleteById(idEventos);
    }

    public Eventos patchEventos(Long idEventos, Eventos parcialEventos){
        Optional<Eventos> eventosOptional = repositoryEventos.findById(idEventos);
        if (eventosOptional.isPresent()) {
            
            Eventos eventosToUpdate = eventosOptional.get();
            
            if (parcialEventos.getUsuario() != null) {
                eventosToUpdate.setUsuario(parcialEventos.getUsuario());   
            }

            if (parcialEventos.getEvento() != null) {
                eventosToUpdate.setEvento(parcialEventos.getEvento());   
            }

            if (parcialEventos.getEstado() != null) {
                eventosToUpdate.setEstado(parcialEventos.getEstado());   
            }

            return repositoryEventos.save(eventosToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}
