ALTER TABLE Produto
    CHANGE COLUMN quant quantEst INT NOT NULL,
    ADD COLUMN quantPed INT NOT NULL;