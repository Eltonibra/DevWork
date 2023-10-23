package com.dev.DevWork.presentation;

import com.dev.DevWork.model.Persona;
import com.dev.DevWork.service.ServiceDw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerDw {
    private final ServiceDw serviceDw;
    @Autowired
    public ControllerDw(ServiceDw serviceDw) {
        this.serviceDw = serviceDw;
    }
    @GetMapping("/persona")
    public List<Persona> getAll() {
        return serviceDw.getAll();
    }
    @GetMapping("/persona/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return serviceDw.getOne(id);
    }
    @PostMapping("/persona")
    public ResponseEntity<Persona> addPersone(@RequestBody Persona persona) {
        return serviceDw.addPersona(persona);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<String> updatePersone(@RequestBody Persona persona, @PathVariable Long id) {
        return serviceDw.updatePersona(persona,id);
    }
    @DeleteMapping("/persona/{id}")
    public ResponseEntity<String> deletePersone(@PathVariable Long id) {
        return serviceDw.deletePersona(id);
    }
}
