CREATE TABLE medico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    crm VARCHAR(20) NOT NULL UNIQUE,
    especialidade VARCHAR(50) NOT NULL
);

CREATE TABLE paciente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL
);

CREATE TABLE consulta (
    id SERIAL PRIMARY KEY,
    id_medico INTEGER NOT NULL,
    id_paciente INTEGER NOT NULL,
    data TIMESTAMP NOT NULL,
    observacoes TEXT,
    FOREIGN KEY (id_medico) REFERENCES medico(id),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id)
); 