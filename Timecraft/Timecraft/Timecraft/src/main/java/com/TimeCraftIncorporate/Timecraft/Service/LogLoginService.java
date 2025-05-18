package com.TimeCraftIncorporate.Timecraft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeCraftIncorporate.Timecraft.Model.LogLogin;
import com.TimeCraftIncorporate.Timecraft.Repository.RepositoryLogLogin;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LogLoginService {

    @Autowired
    private RepositoryLogLogin repositoryLogLogin;

    public List<LogLogin> findAll(){
        return repositoryLogLogin.findAll();
    }

    public LogLogin findById(long idLogLogin){
        return repositoryLogLogin.findById(idLogLogin).orElse(null);
    }

    public LogLogin save(LogLogin logLogin){
        return repositoryLogLogin.save(logLogin);
    }

    public void delete(long idLogLogin){
        repositoryLogLogin.deleteById(idLogLogin);
    }

    public LogLogin patchLogLogin(Long idLogLogin, LogLogin parcialLogLogin){
        Optional<LogLogin> logLoginOptional = repositoryLogLogin.findById(idLogLogin);
        if (logLoginOptional.isPresent()) {
            
            LogLogin logLoginToUpdate = logLoginOptional.get();
            
            if (parcialLogLogin.getFecha() != null) {
                logLoginToUpdate.setFecha(parcialLogLogin.getFecha());   
            }

            if (parcialLogLogin.getHora() != null) {
                logLoginToUpdate.setHora(parcialLogLogin.getHora());   
            }

            if (parcialLogLogin.getUsuario() != null) {
                logLoginToUpdate.setUsuario(parcialLogLogin.getUsuario());   
            }

            return repositoryLogLogin.save(logLoginToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}
