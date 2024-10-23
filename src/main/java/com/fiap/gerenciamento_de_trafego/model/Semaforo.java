package com.fiap.gerenciamento_de_trafego.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Semaforo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "A localização não pode ser vazia")
    private String localizacao;

    @NotEmpty(message = "O estado não pode ser vazio")
    private String estado;

    @NotNull(message = "O fluxo de veículos não pode ser nulo")
    private Integer fluxoVeiculos;
}
