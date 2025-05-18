package com.TimeCraftIncorporate.Timecraft.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TimeCraftIncorporate.Timecraft.Model.Eventos;
import com.TimeCraftIncorporate.Timecraft.Service.EventosService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/Eventos")
public class EventosController {

    @Autowired
    public EventosService eventosService;

    @GetMapping
    public ResponseEntity <List<Eventos>> listar(){
        List<Eventos> eventos = eventosService.findAll();
        if (eventos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(eventos);
    }

    @PostMapping
    public ResponseEntity<Eventos> guardar(@RequestBody Eventos eventos) {
        Eventos eventosNuevo = eventosService.save(eventos);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventosNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eventos> buscar(@PathVariable Integer id) {
        try {
            Eventos eventos = eventosService.findById(id);
            return ResponseEntity.ok(eventos);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eventos> actualizar(@PathVariable Integer id, @RequestBody Eventos eventos) {
        try {
            eventosService.save(eventos);
            return ResponseEntity.ok(eventos);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Eventos> patchEventos(@PathVariable Long id,@RequestBody Eventos patchEventos) {
        try {
            Eventos uptdateEventos = eventosService.patchEventos(id, patchEventos);
            return ResponseEntity.ok(uptdateEventos);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

          @DeleteMapping("/{id}")   
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            eventosService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

/* 

por ultimo post pa Eventos
    {
    "usuario": {
        "idUsuario":1
    },
    "evento":{
        "idEvento":1
    },
    "estado":{
        "idEstado":1
    }
    }
*/
}

