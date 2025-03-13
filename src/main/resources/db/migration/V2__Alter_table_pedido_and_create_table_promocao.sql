CREATE TABLE Promocao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    porcentagem_desconto DOUBLE NOT NULL,
    expira_em DATE NOT NULL,
    criado_em DATE NOT NULL
);

ALTER TABLE Pedido
ADD COLUMN promocao_id BIGINT,
ADD CONSTRAINT fk_pedido_promocao
FOREIGN KEY (promocao_id) REFERENCES Promocao(id);