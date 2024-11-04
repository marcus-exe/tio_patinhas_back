package com.fiap.br.dao;

import com.fiap.br.exception.EntidadeNaoEcontradaException;
import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.register.Endereco;
import com.fiap.br.models.register.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
public class EnderecoDAO {
    private Connection connection;

    public EnderecoDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    public void registerEndereco(Endereco endereco) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("insert into endereco values(?,?,?)");
        stm.setString(1, endereco.getIdEndereco().toString());
        stm.setString(2, endereco.getRua());
        stm.setInt(3, endereco.getNumero());
        stm.executeUpdate();
    }

    public List<Endereco> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM endereco");
        ResultSet result = stm.executeQuery();
        List<Endereco> lista = new ArrayList<>();
        while (result.next()){

            lista.add(parseEndereco(result));
        }
        return lista;
    }

    public Endereco getEndereco(String id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = connection.prepareStatement("select * from endereco where id_endereco = ?");
        stm.setString(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Endereco não encontrado");
        return parseEndereco(result);
    }

    private Endereco parseEndereco(ResultSet result) throws SQLException {
        String id = result.getString("id_endereco");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        return new Endereco(id, rua, Integer.parseInt(numero));
    }

    public void updateEndereco(Endereco endereco) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("update endereco set id_endereco = ?, rua = ?, numero = ?");
        stm.setString(1, endereco.getIdEndereco().toString());
        stm.setString(2, endereco.getRua());
        stm.setInt(3, endereco.getNumero());
        stm.executeUpdate();
    }

    public void deleteEndereco(String id_endereco) throws SQLException{
        PreparedStatement stm = connection.prepareStatement("delete from endereco where id_endereco = ?");
        stm.setString(1, id_endereco);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new SQLException("Endereco não encontrado para ser removido");
    }
}
