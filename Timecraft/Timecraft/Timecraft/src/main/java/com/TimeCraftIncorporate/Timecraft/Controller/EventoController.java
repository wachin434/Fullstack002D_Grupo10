package com.TimeCraftIncorporate.Timecraft.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TimeCraftIncorporate.Timecraft.Model.Evento;
import com.TimeCraftIncorporate.Timecraft.Service.EventoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/Evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> listar() {
        List<Evento> evento = eventoService.findAll();
        if(evento.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(evento);

    }

    @PostMapping
    public ResponseEntity<Evento> guardar(@RequestBody Evento evento) {
        Evento eventoNuevo = eventoService.save(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscar(@PathVariable Integer id) {
        try {
            Evento evento = eventoService.findById(id);
            return ResponseEntity.ok(evento);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizar(@PathVariable Integer id, @RequestBody Evento evento) {
        try {
            eventoService.save(evento);
            return ResponseEntity.ok(evento);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Evento> patchEvento(@PathVariable Long id,@RequestBody Evento patchEvento) {
        try {
            Evento uptdateEvento = eventoService.patchEvento(id, patchEvento);
            return ResponseEntity.ok(uptdateEvento);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            eventoService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    /* su post para evento
    {
    "titulo": "reunion de equipo",
    "descripcion": "se reune el equipo",
    "fecha": "2025-04-01",
    "hora": "10:30:00",
    "duracionMin": 60
    }
*/
}
