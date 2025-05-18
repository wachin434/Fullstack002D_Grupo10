package com.TimeCraftIncorporate.Timecraft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeCraftIncorporate.Timecraft.Model.Evento;
import com.TimeCraftIncorporate.Timecraft.Repository.RepositoryEvento;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventoService {
    @Autowired
    private RepositoryEvento repositoryEvento;

    public List<Evento> findAll(){
        return repositoryEvento.findAll();
    }

    public Evento findById(long idEvento){
        return repositoryEvento.findById(idEvento).orElse(null);
    }

    public Evento save(Evento evento){
        return repositoryEvento.save(evento);
    }

    public void delete(long idEvento){
        repositoryEvento.deleteById(idEvento);
    }

    public Evento patchEvento(Long idEvento, Evento parcialEvento){
        Optional<Evento> eventoOptional = repositoryEvento.findById(idEvento);
        if (eventoOptional.isPresent()) {
            
            Evento eventoToUpdate = eventoOptional.get();
            
            if (parcialEvento.getTitulo() != null) {
                eventoToUpdate.setTitulo(parcialEvento.getTitulo());   
            }

            if (parcialEvento.getDescripcion() != null) {
                eventoToUpdate.setDescripcion(parcialEvento.getDescripcion());   
            }

            if(parcialEvento.getFecha() != null) {
                eventoToUpdate.setFecha(parcialEvento.getFecha());
            }

            if(parcialEvento.getHora() != null) {
                eventoToUpdate.setHora(parcialEvento.getHora());
            }

            if (parcialEvento.getDuracionMin() != null) {
                eventoToUpdate.setDuracionMin(parcialEvento.getDuracionMin());   
            }

            return repositoryEvento.save(eventoToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}
