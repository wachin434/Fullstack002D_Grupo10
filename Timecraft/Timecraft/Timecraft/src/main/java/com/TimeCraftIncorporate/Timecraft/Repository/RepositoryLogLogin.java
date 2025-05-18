package com.TimeCraftIncorporate.Timecraft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeCraftIncorporate.Timecraft.Model.LogLogin;
import com.TimeCraftIncorporate.Timecraft.Model.Usuario;

import java.sql.Date;
import java.util.List;

@Repository
public interface RepositoryLogLogin extends JpaRepository<LogLogin, Long> {

    List<LogLogin> findByFecha(Date fecha);
    List<LogLogin> findByIdLog(Integer idLog);
    List<Usuario> findByUsuario(Usuario usuario);

}
