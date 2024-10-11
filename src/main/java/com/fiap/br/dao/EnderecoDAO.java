package com.fiap.br.dao;

import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.register.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
public class EnderecoDAO {
    private Connection connection;

    public EnderecoDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    public void registerEndereco(Endereco endereco) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("insert into endereco values(?,?,?,?,?,?,?,?,?)");
        stm.setString(1, endereco.getIdEndereco().toString());
        stm.setString(2, endereco.getRua());
        stm.setInt(3, endereco.getNumero());
        stm.setString(4, endereco.getComplemento());
        stm.setString(5, endereco.getBairro());
        stm.setString(6, endereco.getCidade());
        stm.setString(7, endereco.getCdEstado());
        stm.setString(8, endereco.getCep());
        stm.setString(9, endereco.getPais());
        stm.executeUpdate();
    }
    public void listAllEndereco() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from endereco");
    }
    public void getEndereco(String id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from endereco where id = ?");
        stm.setString(1, id);
    }
}