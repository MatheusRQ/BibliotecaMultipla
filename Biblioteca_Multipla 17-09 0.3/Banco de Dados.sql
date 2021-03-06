CREATE DATABASE IF NOT EXISTS BIBLIOTECA_MULTIPLA;

USE BIBLIOTECA_MULTIPLA;

CREATE TABLE IF NOT EXISTS CATEGORIA(
ID INT AUTO_INCREMENT,
NOME VARCHAR(30) NOT NULL,
PRIMARY KEY(ID)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS ANIMACAO(
ID INT AUTO_INCREMENT,
NOME VARCHAR(100) NOT NULL,
ANO_DE_LANCAMENTO INT,
GENERO VARCHAR(300),
NUMERO_EPISODIOS INT UNSIGNED,
CATEGORIA_ID INT,
DATA_DE_REGISTRO TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ASSISTIDO BIT DEFAULT 0,
PRIMARY KEY (ID),
CONSTRAINT CATEGORIA_FK FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID)
);

CREATE TABLE IF NOT EXISTS ANIMACAO_N_ASSISTIDO (
ANIMACAO_ID INT NOT NULL,
RELEVANCIA ENUM('S', 'A', 'B', 'C', 'D'),
PRIORIDADE ENUM('--', '-', '=', '+', '++'),
CONSTRAINT FK_ANIMACAO_0 FOREIGN KEY (ANIMACAO_ID) REFERENCES ANIMACAO (ID)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS ANIMACAO_ASSISTIDO (
ANIMACAO_ID INT NOT NULL,
DATA_DE_FINALIZACAO TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
NOTA DECIMAL (5,3),
CONSTRAINT FK_ANIMACAO_1 FOREIGN KEY (ANIMACAO_ID) REFERENCES ANIMACAO (ID)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS DUBLADOR (
ID INT AUTO_INCREMENT,
NOME VARCHAR(50),
NASCIMENTO DATE,
PRIMARY KEY (ID)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS PERSONAGEM (
ID INT AUTO_INCREMENT,
NOME VARCHAR(50),
PRIMARY KEY (ID)
) ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS DUBLAGENS (
DUBLADOR_ID INT,
PERSONAGEM_ID INT,
ANIMACAO_ID INT,
CONSTRAINT FK_DUBLADOR
FOREIGN KEY (DUBLADOR_ID) REFERENCES DUBLADOR (ID),
CONSTRAINT FK_PERSONAGEM FOREIGN KEY (PERSONAGEM_ID) REFERENCES DUBLADOR (ID),
CONSTRAINT FK_ANIMACAO
FOREIGN KEY (ANIMACAO_ID) REFERENCES ANIMACAO (ID)
);

INSERT INTO `biblioteca_multipla`.`categoria`
(`NOME`)
VALUES
('ANIMACAO ORIENTAL');

INSERT INTO `biblioteca_multipla`.`animacao`
(`ID`,
`NOME`,
`ANO_DE_LANCAMENTO`,
`GENERO`,
`NUMERO_EPISODIOS`,
`CATEGORIA_ID`,
`DATA_DE_REGISTRO`,
`ASSISTIDO`)
VALUES
(DEFAULT,
'Nome de teste',
2020,
'Acao e fantasia',
12,
'1',
DEFAULT,
DEFAULT);

INSERT INTO `biblioteca_multipla`.`animacao_n_assistido`
(`ANIMACAO_ID`,
`RELEVANCIA`,
`PRIORIDADE`)
VALUES
(2,
'A',
'++');