package com.fiap.br.dao;

import com.fiap.br.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.fiap.br.utils.InitSQLString.initSQLString;

public class InitSQL {

    private Connection conection;

    public InitSQL() throws SQLException {
        conection = ConnectionFactory.getConnection();
    }

    public void initSQL() throws SQLException {
        PreparedStatement stm = conection.prepareStatement(initSQLString());
    }

    public void closeConection() throws SQLException {
        conection.close();
    }


}
