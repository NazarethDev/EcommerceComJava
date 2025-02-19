CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf INT NOT NULL,
    telefone INT NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    preco_para_venda DOUBLE NOT NULL,
    preco_compra DOUBLE NOT NULL,
    data_validade DATE NOT NULL,
    avaliacao DOUBLE NOT NULL,
    tipo_alimento VARCHAR(255) NOT NULL,
    categoria_produto VARCHAR(255) NOT NULL,
    quant INT NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    alimento BOOLEAN DEFAULT FALSE,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL
);

CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero_da_casa INT NOT NULL,
    complemento VARCHAR(255),
    cep INT NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    telefone INT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    endereco_entrega_id BIGINT NOT NULL,
    endereco_faturacao_id BIGINT NOT NULL,
    valor_total DOUBLE NOT NULL,
    valor_entrega DOUBLE NOT NULL,
    valor_produtos DOUBLE NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES usuario(id),
    FOREIGN KEY (endereco_entrega_id) REFERENCES endereco(id),
    FOREIGN KEY (endereco_faturacao_id) REFERENCES endereco(id)
);

CREATE TABLE comentarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    autor_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE produto_pedido (
    produto_id BIGINT NOT NULL,
    pedido_id BIGINT NOT NULL,
    PRIMARY KEY (produto_id, pedido_id),
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
