package com.fiap.gerenciamento_de_trafego.service;

import com.fiap.gerenciamento_de_trafego.model.Semaforo;
import com.fiap.gerenciamento_de_trafego.repository.SemaforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    public List<Semaforo> getAllSemaforos() {
        return semaforoRepository.findAll();
    }

    public Semaforo createSemaforo(Semaforo semaforo) {
        return semaforoRepository.save(semaforo);
    }

    public Semaforo updateSemaforo(Long id, Semaforo semaforoAtualizado) {
        Semaforo semaforo = semaforoRepository.findById(id).orElseThrow();
        semaforo.setLocalizacao(semaforoAtualizado.getLocalizacao());
        semaforo.setEstado(semaforoAtualizado.getEstado());
        semaforo.setFluxoVeiculos(semaforoAtualizado.getFluxoVeiculos());
        return semaforoRepository.save(semaforo);
    }

    public boolean deleteSemaforo(Long id) {
        if (semaforoRepository.existsById(id)) {
            semaforoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
