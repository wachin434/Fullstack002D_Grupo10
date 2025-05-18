package com.TimeCraftIncorporate.Timecraft.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeCraftIncorporate.Timecraft.Repository.RepositoryUsuario;
import com.TimeCraftIncorporate.Timecraft.Model.Usuario;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public List<Usuario> findAll(){
        return repositoryUsuario.findAll();
    }

    public Usuario findById(long idUsuario){
        return repositoryUsuario.findById(idUsuario).orElse(null);
    }

    public Usuario save(Usuario usuario){
        return repositoryUsuario.save(usuario);
    }

    public void delete(long idUsuario){
        repositoryUsuario.deleteById(idUsuario);
    }

    public Usuario patchUsuario(Long idUsuario, Usuario parcialUsuario){
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            
            Usuario usuarioToUpdate = usuarioOptional.get();
            
            if (parcialUsuario.getNombre() != null) {
                usuarioToUpdate.setNombre(parcialUsuario.getNombre());   
            }

            if (parcialUsuario.getSegundoNombre() != null) {
                usuarioToUpdate.setSegundoNombre(parcialUsuario.getSegundoNombre());   
            }

            if(parcialUsuario.getApellido() != null) {
                usuarioToUpdate.setApellido(parcialUsuario.getApellido());
            }

            if (parcialUsuario.getSegundoApellido() != null) {
                usuarioToUpdate.setSegundoApellido(parcialUsuario.getSegundoApellido());   
            }

            if(parcialUsuario.getCorreo() != null) {
                usuarioToUpdate.setCorreo(parcialUsuario.getCorreo());
            }

            if(parcialUsuario.getContrasenia() != null) {
                usuarioToUpdate.setContrasenia(parcialUsuario.getContrasenia());
            }

            if(parcialUsuario.getZonaHoraria() != null) {
                usuarioToUpdate.setZonaHoraria(parcialUsuario.getZonaHoraria());
            }

            if(parcialUsuario.getIdioma() != null) {
                usuarioToUpdate.setIdioma(parcialUsuario.getIdioma());
            }
            if(parcialUsuario.getRol() != null) {
                usuarioToUpdate.setRol(parcialUsuario.getRol());
            }

            return repositoryUsuario.save(usuarioToUpdate);
        } else {
            return null; // or throw an exception
        }
    }


}
