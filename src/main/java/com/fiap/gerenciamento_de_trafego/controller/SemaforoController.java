package com.fiap.gerenciamento_de_trafego.controller;

import com.fiap.gerenciamento_de_trafego.model.Semaforo;
import com.fiap.gerenciamento_de_trafego.service.SemaforoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semaforos")
public class SemaforoController {

    @Autowired
    private SemaforoService semaforoService;

    @GetMapping
    public List<Semaforo> getAllSemaforos() {
        return semaforoService.getAllSemaforos();
    }

    @PostMapping
    public Semaforo createSemaforo(@RequestBody Semaforo semaforo) {
        return semaforoService.createSemaforo(semaforo);
    }

    @PutMapping("/{id}")
    public Semaforo updateSemaforo(@PathVariable Long id, @RequestBody Semaforo semaforo) {
        return semaforoService.updateSemaforo(id, semaforo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSemaforo(@PathVariable Long id) {
        boolean isDeleted = semaforoService.deleteSemaforo(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Semáforo deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Semáforo não encontrado.");
        }
    }
}
