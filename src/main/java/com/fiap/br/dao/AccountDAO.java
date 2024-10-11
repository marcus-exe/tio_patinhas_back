package com.fiap.br.dao;

import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.account.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private Connection connection;

    public AccountDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    public void registerAccount(Conta conta) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("insert into contas_cripto values(?,?,?,?,?,?,?,?,?)");
        stm.setString(1, conta.getNrConta());
        stm.setString(2, conta.getSenhaConta());
        stm.setString(3, conta.getTipoConta());
        stm.setDouble(4, conta.getSaldo());
        stm.setDate(5, conta.getDataCriacao());
        stm.setString(6, conta.getStatusConta());
        stm.setString(7, conta.getEnderecoCarteira());
        stm.setString(8, conta.getIdCliente().toString());
        stm.setString(9, conta.getIdCorretora().toString());
        stm.executeUpdate();
    }
    public void listAllAccounts() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from contas_cripto");
    }
    public void getAccount(String id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from contas_cripto where id = ?");
        stm.setString(1, id);
    }
}
