CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    senha VARCHAR(400) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf INT NOT NULL,
    telefone INT NOT NULL
);

CREATE TABLE Endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(9) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numeroDaCasa INT NOT NULL,
    complemento VARCHAR(255),
    cep INT NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

CREATE TABLE Produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    precoVenda DECIMAL(10, 2) NOT NULL,
    precoCompra DECIMAL(10, 2) NOT NULL,
    dataValidade DATE,
    avaliacao DECIMAL(2, 1)
);

CREATE TABLE Comentarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    autor_id BIGINT,
    produto_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);

CREATE TABLE Pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    endereco_entrega_id BIGINT,
    endereco_faturacao_id BIGINT,
    valorTotal DECIMAL(10, 2) NOT NULL,
    valorEntrega DECIMAL(5, 2) NOT NULL,
    valorProdutos DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Usuario(id),
    FOREIGN KEY (endereco_entrega_id) REFERENCES Endereco(id),
    FOREIGN KEY (endereco_faturacao_id) REFERENCES Endereco(id)
);

CREATE TABLE Pedido_Produto (
    pedido_id BIGINT,
    produto_id BIGINT,
    PRIMARY KEY (pedido_id, produto_id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);