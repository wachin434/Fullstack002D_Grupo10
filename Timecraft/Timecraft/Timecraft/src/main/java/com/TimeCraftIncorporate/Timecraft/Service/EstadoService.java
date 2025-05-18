package com.TimeCraftIncorporate.Timecraft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeCraftIncorporate.Timecraft.Model.Estado;
import com.TimeCraftIncorporate.Timecraft.Repository.RepositoryEstado;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoService {

    @Autowired
    private RepositoryEstado repositoryEstado;

    public List<Estado> findAll(){
        return repositoryEstado.findAll();
    }

    public Estado findById(long idEstado){
        return repositoryEstado.findById(idEstado).orElse(null);
    }

    public Estado save(Estado estado){
        return repositoryEstado.save(estado);
    }

    public void delete(long idEstado){
        repositoryEstado.deleteById(idEstado);
    }

    public Estado patchEstado(Long idEstado, Estado parcialEstado){
        Optional<Estado> estadoOptional = repositoryEstado.findById(idEstado);
        if (estadoOptional.isPresent()) {
            
            Estado estadoToUpdate = estadoOptional.get();
            
            if (parcialEstado.getTipo() != null) {
                estadoToUpdate.setTipo(parcialEstado.getTipo());   
            }

            return repositoryEstado.save(estadoToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}
