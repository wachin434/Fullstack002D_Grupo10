package com.TimeCraftIncorporate.Timecraft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TimeCraftIncorporate.Timecraft.Model.Estado;
import com.TimeCraftIncorporate.Timecraft.Service.EstadoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/Estado")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity <List<Estado>> listar() {
        List<Estado> estado = estadoService.findAll();
        if (estado.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado) {
        Estado estadoNuevo = estadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscar(@PathVariable Integer id) {
        try {
            Estado estado = estadoService.findById(id);
            return ResponseEntity.ok(estado);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizar(@PathVariable Integer id, @RequestBody Estado estado) {
        try {
            estadoService.save(estado);
            return ResponseEntity.ok(estado);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

        @PatchMapping("/{id}")
    public ResponseEntity<Estado> patchEstado(@PathVariable Long id,@RequestBody Estado patchEstado) {
        try {
            Estado uptdateEstado = estadoService.patchEstado(id, patchEstado);
            return ResponseEntity.ok(uptdateEstado);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            estadoService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

/*
    su post para el estado 

    {
  "tipo": "aceptado"
    }
  
 */
}
