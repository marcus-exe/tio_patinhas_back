package com.fiap.br.dao;

import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.transaction.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransacaoDAO {
    private Connection connection;

    public TransacaoDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    public void registerTransacao(Transacao transacao) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("insert into transacao_cripto values(?,?,?,?,?,?,?,?,?,?,?,?)");
        stm.setString(1, transacao.getIdTransacao().toString());
        stm.setDate(2, transacao.getData());
        stm.setBigDecimal(3, transacao.getMontante());
        stm.setString(4, transacao.getDescricao());
        stm.setString(5, transacao.getContaOrigem());
        stm.setString(6, transacao.getContaDestino());
        stm.setString(7, transacao.getHashTransacao());
        stm.setDouble(8, transacao.getTaxaTransacao());
        stm.setString(9, transacao.getNrConta());
        stm.setString(10, transacao.getTipoTransacao());
        stm.setString(11, transacao.getIdCliente().toString());
        stm.setString(12, transacao.getIdCorretora().toString());
        stm.executeUpdate();
    }
    public void listAllTransacao() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from transacao_cripto");
    }
    public void getTransacao(String id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("select * from transacao_cripto where id = ?");
        stm.setString(1, id);
    }

    public void updateTransacao(Transacao transacao) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("update transacao_cripto set id_transacao = ?, data_hora = ?, tipo_transacao = ?, valor = ?, descricao = ?, endereco_origem = ?, endereco_destino = ?, hash_transacao = ?, taxa_transacao = ?, nr_conta = ?, id_cliente = ?, id_corretora = ? where id_transacao = ?");
        stm.setString(1, transacao.getIdTransacao().toString());
        stm.setDate(2, transacao.getData());
        stm.setBigDecimal(3, transacao.getMontante());
        stm.setString(4, transacao.getDescricao());
        stm.setString(5, transacao.getContaOrigem());
        stm.setString(6, transacao.getContaDestino());
        stm.setString(7, transacao.getHashTransacao());
        stm.setDouble(8, transacao.getTaxaTransacao());
        stm.setString(9, transacao.getNrConta());
        stm.setString(10, transacao.getTipoTransacao());
        stm.setString(11, transacao.getIdCliente().toString());
        stm.setString(12, transacao.getIdCorretora().toString());
        stm.executeUpdate();
    }

    public void deleteTransacao(String id_transacao) throws SQLException{
        PreparedStatement stm = connection.prepareStatement("delete from transacao_cripto where id_transacao = ?");
        stm.setString(1, id_transacao);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new SQLException("Transacao não encontrada para ser removida");
    }
}
