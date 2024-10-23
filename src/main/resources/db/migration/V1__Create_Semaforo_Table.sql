CREATE TABLE semaforo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    localizacao VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fluxo_veiculos INTEGER NOT NULL
);