package com.fiap.br.dao;

import com.fiap.br.exception.EntidadeNaoEcontradaException;
import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.register.Corretora;
import com.fiap.br.models.transaction.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Transacao> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM transacao_cripto");
        ResultSet result = stm.executeQuery();
        List<Transacao> lista = new ArrayList<>();
        while (result.next()){

            lista.add(parseTransacao(result));
        }
        return lista;
    }

    public Transacao getTransacao(String id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = connection.prepareStatement("select * from transacao-cripto where id = ?");
        stm.setString(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Transacao não encontrada");
        return parseTransacao(result);
    }

    private Transacao parseTransacao(ResultSet result) throws SQLException {
        String id = result.getString("id_transacao");
        return new Transacao(id);
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
