package com.TimeCraftIncorporate.Timecraft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeCraftIncorporate.Timecraft.Model.Rol;
import com.TimeCraftIncorporate.Timecraft.Repository.RepositoryRol;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    private RepositoryRol repositoryRol;

    public List<Rol> findAll(){
        return repositoryRol.findAll();
    }

    public Rol findById(long idRol){
        return repositoryRol.findById(idRol).orElse(null);
    }

    public Rol save(Rol rol){
        return repositoryRol.save(rol);
    }

    public void delete(long idRol){
        repositoryRol.deleteById(idRol);
    }

    public Rol patchRol(Long idRol, Rol parcialRol){
        Optional<Rol> rolOptional = repositoryRol.findById(idRol);
        if (rolOptional.isPresent()) {
            
            Rol rolToUpdate = rolOptional.get();
            
            if (parcialRol.getNombre() != null) {
                rolToUpdate.setNombre(parcialRol.getNombre());   
            }

            if (parcialRol.getDescripcion() != null) {
                rolToUpdate.setDescripcion(parcialRol.getDescripcion());   
            }

            return repositoryRol.save(rolToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}
