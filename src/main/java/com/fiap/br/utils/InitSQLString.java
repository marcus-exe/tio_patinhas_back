package com.fiap.br.utils;

public class InitSQLString {
    public static String initSQLString(){
        return "CREATE TABLE ENDERECO\n" +
                "(\n" +
                "  id_endereco    VARCHAR2(50)     NOT NULL ,\n" +
                "  rua    VARCHAR2(50)  NOT NULL,\n" +
                "  numero NUMBER(5) NOT NULL,\n" +
                "  complemento VARCHAR2(50) NULL,\n" +
                "  bairro VARCHAR2(50) NOT NULL,\n" +
                "  cidade VARCHAR2(50) NOT NULL,\n" +
                "  cd_estado VARCHAR2(50) NOT NULL,\n" +
                "  cep VARCHAR2(50) NOT NULL,\n" +
                "  pais VARCHAR2(2) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE ENDERECO\n" +
                "      ADD CONSTRAINT PK_ENDERECO \n" +
                "      PRIMARY KEY (id_endereco);\n" +
                "\n" +
                "ALTER TABLE ENDERECO\n" +
                "      ADD CONSTRAINT FK_CLIENTES\n" +
                "      FOREIGN KEY (id_cliente)\n" +
                "      REFERENCES  CLIENTES (id_cliente)\n" +
                "      ON DELETE CASCADE;\n" +
                "\n" +
                "ALTER TABLE ENDERECO\n" +
                "      ADD CONSTRAINT FK_CORRETORA\n" +
                "      FOREIGN KEY (id_corretora)\n" +
                "      REFERENCES  CORRETORA (id_corretora)\n" +
                "      ON DELETE CASCADE;\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "CREATE TABLE CLIENTES\n" +
                "(\n" +
                "  id_cliente    VARCHAR2(50)     NOT NULL ,\n" +
                "  nome_completo    VARCHAR2(100)  NOT NULL,\n" +
                "  data_nascimento DATE NOT NULL,\n" +
                "  cpf_cnpj VARCHAR2(50) NOT NULL,\n" +
                "  email VARCHAR2(100) NOT NULL,\n" +
                "  telefone VARCHAR2(50) NOT NULL,\n" +
                "  data_criacao DATE NOT NULL,\n" +
                "  cep VARCHAR2(50) NOT NULL,\n" +
                "  pais VARCHAR2(2) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE CLIENTES\n" +
                "      ADD CONSTRAINT PK_CLIENTES \n" +
                "      PRIMARY KEY (id_cliente);\n" +
                "      \n" +
                "ALTER TABLE CLIENTES\n" +
                "      ADD CONSTRAINT FK_ENDERECO\n" +
                "      FOREIGN KEY (id_endereco)\n" +
                "      REFERENCES  ENDERECO (id_endereco)\n" +
                "      ON DELETE CASCADE;\n" +
                "      \n" +
                " ALTER TABLE CLIENTES \n" +
                "ADD CONSTRAINT UN_CLIETNES \n" +
                "        UNIQUE (id_cliente);\n" +
                "      \n" +
                "      \n" +
                "\n" +
                "\n" +
                "CREATE TABLE CORRETORA\n" +
                "(\n" +
                "  id_corretora    VARCHAR2(50)     NOT NULL ,\n" +
                "  nome_corretora    VARCHAR2(100)  NOT NULL,\n" +
                "  cnpj VARCHAR2(50) NOT NULL,\n" +
                "  email VARCHAR2(100) NOT NULL,\n" +
                "  telefone VARCHAR2(50) NOT NULL,\n" +
                "  tipos_criptoativos_suportados BLOB NOT NULL,\n" +
                "  endereco_carteira_corretora VARCHAR2(2) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE CORRETORA\n" +
                "      ADD CONSTRAINT PK_CORRETORA \n" +
                "      PRIMARY KEY (id_corretora);\n" +
                "      \n" +
                "ALTER TABLE CORRETORA\n" +
                "      ADD CONSTRAINT FK_ENDERECO\n" +
                "      FOREIGN KEY (id_endereco)\n" +
                "      REFERENCES  ENDERECO (id_endereco)\n" +
                "      ON DELETE CASCADE;\n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "CREATE TABLE CONTAS_CRIPTO\n" +
                "(\n" +
                "  nr_conta    NUMBER(10)     NOT NULL ,\n" +
                "  tipo_conta    VARCHAR2(100)  NOT NULL,\n" +
                "  saldo NUMBER(10,2) NOT NULL,\n" +
                "  data_abertura DATE NOT NULL,\n" +
                "  status_conta VARCHAR2(20) NOT NULL,\n" +
                "  endereco_carteira VARCHAR2(100) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE CONTAS_CRIPTO\n" +
                "      ADD CONSTRAINT PK_CONTAS_CRIPTO \n" +
                "      PRIMARY KEY (nr_conta);\n" +
                "\n" +
                "ALTER TABLE CONTAS_CRIPTO\n" +
                "      ADD CONSTRAINT FK_CLIENTE\n" +
                "      FOREIGN KEY (id_cliente)\n" +
                "      REFERENCES  CLIENTES (id_cliente)\n" +
                "      ON DELETE CASCADE;\n" +
                "\n" +
                "ALTER TABLE CONTAS_CRIPTO\n" +
                "      ADD CONSTRAINT FK_CORRETORA\n" +
                "      FOREIGN KEY (id_corretora)\n" +
                "      REFERENCES  CORRETORA (id_corretora)\n" +
                "      ON DELETE CASCADE;\n" +
                "      \n" +
                "ALTER TABLE CONTAS_CRIPTO\n" +
                "      ADD CONSTRAINT FK_TRANSACAO_CRIPTO\n" +
                "      FOREIGN KEY (id_transacao)\n" +
                "      REFERENCES  TRANSACAO (id_transacao)\n" +
                "      ON DELETE CASCADE;\n" +
                "\n" +
                "\n" +
                "\n" +
                "CREATE TABLE TRANSACAO_CRIPTO\n" +
                "(\n" +
                "  id_transacao    VARCHAR2(50)     NOT NULL ,\n" +
                "  data_hora    TIMESTAMP NOT NULL,\n" +
                "  tipo_transacao VARCHAR(50) NOT NULL,\n" +
                "  valor NUMBER(10,2) NOT NULL,\n" +
                "  descricao VARCHAR2(255) NOT NULL,\n" +
                "  endereco_origem VARCHAR2(50) NOT NULL,\n" +
                "  endereco_destino VARCHAR2(50) NOT NULL,\n" +
                "  hash_transacao VARCHAR2(50) NOT NULL,\n" +
                "  taxa_transacao NUMBER(5) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE TRANSACAO_CRIPTO\n" +
                "      ADD CONSTRAINT PK_TRANSACAO_CRIPTO \n" +
                "      PRIMARY KEY (id_transacao);\n" +
                "\n" +
                "ALTER TABLE TRANSACAO_CRIPTO\n" +
                "      ADD CONSTRAINT FK_CORRETORA\n" +
                "      FOREIGN KEY (id_corretora)\n" +
                "      REFERENCES  CORRETORA (id_corretora)\n" +
                "      ON DELETE CASCADE;\n" +
                "    \n" +
                "ALTER TABLE TRANSACAO_CRIPTO\n" +
                "      ADD CONSTRAINT FK_CONTAS_CRIPTO\n" +
                "      FOREIGN KEY (nr_conta)\n" +
                "      REFERENCES  CONTAS_CRIPTO (nr_conta)\n" +
                "      ON DELETE CASCADE;\n" +
                "      \n" +
                "ALTER TABLE TRANSACAO_CRIPTO\n" +
                "      ADD CONSTRAINT FK_CLIENTE\n" +
                "      FOREIGN KEY (id_cliente)\n" +
                "      REFERENCES  CLIENTE (id_cliente)\n" +
                "      ON DELETE CASCADE;\n" +
                "\n" +
                "ALTER TABLE TRANSACAO_CRIPTO\n" +
                "      ADD CONSTRAINT FK_CRIPTOMOEDAS\n" +
                "      FOREIGN KEY (id_criptomoeda)\n" +
                "      REFERENCES  CRIPTOMOEDAS (id_criptomoeda)\n" +
                "      ON DELETE CASCADE;\n" +
                "      \n" +
                "      \n" +
                "\n" +
                "CREATE TABLE CRIPTOMOEDAS\n" +
                "(\n" +
                "  id_criptomoeda    VARCHAR2(50)     NOT NULL ,\n" +
                "  nome VARCHAR2(50) NOT NULL,\n" +
                "  simbolo VARCHAR(50) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE CRIPTOMOEDAS\n" +
                "      ADD CONSTRAINT PK_CRIPTOMOEDAS \n" +
                "      PRIMARY KEY (id_criptomoeda);\n" +
                "\n" +
                "ALTER TABLE CRIPTOMOEDAS\n" +
                "      ADD CONSTRAINT FK_HISTORICO\n" +
                "      FOREIGN KEY (id_registro)\n" +
                "      REFERENCES  HISTORICO_PRECOS (id_registro)\n" +
                "      ON DELETE CASCADE;\n" +
                "      \n" +
                "      \n" +
                "\n" +
                "\n" +
                "\n" +
                "CREATE TABLE HISTORICO_PRECOS\n" +
                "(\n" +
                "  id_registro    VARCHAR2(50)     NOT NULL ,\n" +
                "  data_hora  TIMESTAMP NOT NULL,\n" +
                "  preco_abertura NUMBER(10,2) NOT NULL,\n" +
                "  preco_fechamento NUMBER(10,2) NOT NULL,\n" +
                "  preco_max NUMBER(10,2) NOT NULL,\n" +
                "  preco_min NUMBER(10,2) NOT NULL,\n" +
                "  volume_negociacao NUMBER(5,2) NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE HISTORICO_PRECOS\n" +
                "      ADD CONSTRAINT PK_HISTORICO_PRECOS \n" +
                "      PRIMARY KEY (id_registro);\n" +
                "      \n" +
                "ALTER TABLE HISTORICO_PRECOS\n" +
                "      ADD CONSTRAINT FK_CRIPTOMOEDA\n" +
                "      FOREIGN KEY (id_criptomoeda)\n" +
                "      REFERENCES  CRIPTOMOEDAS (id_criptomoeda)\n" +
                "      ON DELETE CASCADE;";
    }
}
