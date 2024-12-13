package com.example.mgr_server.controller;


import com.example.mgr_server.dto.OsobaDTO;
import com.example.mgr_server.service.OsobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/osoby")
public class OsobaController {

    @Autowired
    private OsobaService osobaService;

    @GetMapping
    public ResponseEntity<List<OsobaDTO>> getAllOsoby() {
        List<OsobaDTO> osoby = osobaService.findAll();
        return new ResponseEntity<>(osoby, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OsobaDTO> getOsobaById(@PathVariable Long id) {
        Optional<OsobaDTO> osoba = osobaService.findById(id);
        return osoba.map(osobaDTO -> new ResponseEntity<>(osobaDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OsobaDTO> createOsoba(@RequestBody OsobaDTO osobaDTO) {
        OsobaDTO createdOsoba = osobaService.save(osobaDTO);
        return new ResponseEntity<>(createdOsoba, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OsobaDTO> updateOsoba(@PathVariable Long id, @RequestBody OsobaDTO osobaDTO) {
        Optional<OsobaDTO> updatedOsoba = osobaService.update(id, osobaDTO);
        return updatedOsoba.map(osobaDTO1 -> new ResponseEntity<>(osobaDTO1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOsoba(@PathVariable Long id) {
        osobaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
