package com.TimeCraftIncorporate.Timecraft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.TimeCraftIncorporate.Timecraft.Model.Rol;

import com.TimeCraftIncorporate.Timecraft.Service.RolService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/Rol")//http://localhost:8080/api/v1/Rol
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        List<Rol> rol = rolService.findAll();
        if(rol.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
        Rol rolNuevo = rolService.save(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscar(@PathVariable Integer id) {
        try {
            Rol rol = rolService.findById(id);
            return ResponseEntity.ok(rol);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        try {
            rolService.save(rol);
            return ResponseEntity.ok(rol);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Rol> patchRol(@PathVariable Long id,@RequestBody Rol patchRol) {
        try {
            Rol uptdateRol = rolService.patchRol(id, patchRol);
            return ResponseEntity.ok(uptdateRol);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            rolService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

/*

Ejemplo de post (pq soy entero bkn)  

{
"nombre":"CEO",
"descripcion": "El dueño de la empresa"
}

*/
    
}
