package com.dev.DevWork.service;

import com.dev.DevWork.model.Persona;
import com.dev.DevWork.persistance.repoDw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDw {
    private final repoDw repoDw;
    @Autowired
    public ServiceDw(repoDw repoDw) {
        this.repoDw = repoDw;
    }

    public List<Persona> getAll() {
        return repoDw.findAll();
    }

    public ResponseEntity<?> getOne(Long id) {
        Optional<Persona> persona = repoDw.findById(id);
        if(persona.isPresent()) {
            return new ResponseEntity<>(persona.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Persona non trovata per l'id: "+ id,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Persona> addPersona(Persona persona) {
        repoDw.save(persona);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


    public ResponseEntity<String> updatePersona(Persona persona, Long id) {
        Optional<Persona> existingPersona = repoDw.findById(id);
        if(existingPersona.isPresent()) {
           persona.setId(id);
           repoDw.save(persona);
           return new ResponseEntity<>("Persona aggiornata correttamente con id: "+ id,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Persona non trovata per l'id: "+ id,HttpStatus.NOT_FOUND);

    }
}


    public ResponseEntity<String> deletePersona(Long id) {
        Optional<Persona> persona = repoDw.findById(id);
        if(persona.isPresent()) {
            repoDw.deleteById(id);
            return new ResponseEntity<>("Persona eliminata correttamente con id: "+ id,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Persona non trovata per l'id: "+ id,HttpStatus.NOT_FOUND);
        }
    }
}
