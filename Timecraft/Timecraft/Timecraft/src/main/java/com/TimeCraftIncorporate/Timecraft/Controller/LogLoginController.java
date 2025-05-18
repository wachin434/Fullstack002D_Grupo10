package com.TimeCraftIncorporate.Timecraft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TimeCraftIncorporate.Timecraft.Model.LogLogin;
import com.TimeCraftIncorporate.Timecraft.Service.LogLoginService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/LogLogin")
public class LogLoginController {

    @Autowired
    private LogLoginService logLoginService;

    @GetMapping
        public ResponseEntity<List<LogLogin>> listar() {
        List<LogLogin> logLogins = logLoginService.findAll();
        if (logLogins.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(logLogins);
    }

    @PostMapping
     public ResponseEntity<LogLogin> guardar(@RequestBody LogLogin logLogin) {
        LogLogin logLoginNuevo = logLoginService.save(logLogin);
        return ResponseEntity.status(HttpStatus.CREATED).body(logLoginNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogLogin> buscar(@PathVariable Integer id) {
        try {
            LogLogin logLogin = logLoginService.findById(id);
            return ResponseEntity.ok(logLogin);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogLogin> actualizar(@PathVariable Integer id, @RequestBody LogLogin logLogin) {
        try {
            logLoginService.save(logLogin);
            return ResponseEntity.ok(logLogin);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/{id}")
       public ResponseEntity<LogLogin> patchLogLogin(@PathVariable Long id, @RequestBody LogLogin partialLogLogin) {
        try {
            LogLogin updateLogLogin = logLoginService.patchLogLogin(id, partialLogLogin);
            return ResponseEntity.ok(updateLogLogin);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            logLoginService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /*
    post de LogLogin ouyea

    {
    "fecha": "2025-05-18",
    "hora": "15:30:00",
    "usuario": {
        "idUsuario": 1
    }
    }
     
*/



}
