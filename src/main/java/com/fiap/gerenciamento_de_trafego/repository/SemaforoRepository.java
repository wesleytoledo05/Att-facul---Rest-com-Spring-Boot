package com.fiap.gerenciamento_de_trafego.repository;

import com.fiap.gerenciamento_de_trafego.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {

}
