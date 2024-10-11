package com.fiap.br.dao;

import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.register.Corretora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CorretoraDAO {
    private Connection connection;

    public CorretoraDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    public void registerCorretora(Corretora corretora) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("insert into corretora values(?,?,?,?,?,?,?)");
        stm.setString(1, corretora.getIdCorretora().toString());
        stm.setString(2, corretora.getNomeCorretora());
        stm.setString(3, corretora.getCnpj());
        stm.setString(4, corretora.getEmail());
        stm.setString(5, corretora.getTelefone());
        stm.setString(6, corretora.getTiposCriptoativosSuportados().toString());
        stm.setString(7, corretora.getEnderecoCarteiraCorretora());
        stm.executeUpdate();
    }
    public void listAllCorretora() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from corretora");
    }
    public void getCorretora(String id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from corretora where id = ?");
        stm.setString(1, id);
    }
}