package com.fiap.br.dao;

import com.fiap.br.exception.EntidadeNaoEcontradaException;
import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.register.Corretora;
import com.fiap.br.models.transaction.Transacao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransacaoDAO {
    private Connection connection;

    public TransacaoDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    public void registerTransacao(Transacao transacao) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("insert into transacao_cripto values(?,?,?,?,?,?,?,?,?,?,?)");
        stm.setString(1, transacao.getIdTransacao().toString());
        //stm.setDate(2, transacao.getData());
        stm.setBigDecimal(2, transacao.getMontante());
        stm.setString(3, transacao.getDescricao());
        stm.setString(4, transacao.getContaOrigem());
        stm.setString(5, transacao.getContaDestino());
        stm.setString(6, transacao.getHashTransacao());
        stm.setDouble(7, transacao.getTaxaTransacao());
        stm.setString(8, transacao.getNrConta());
        stm.setString(9, transacao.getTipoTransacao());
        stm.setString(10, transacao.getIdCliente().toString());
        stm.setString(11, transacao.getIdCorretora().toString());
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
        PreparedStatement stm = connection.prepareStatement("select * from transacao_cripto where id_transacao = ?");
        stm.setString(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Transação não encontrada");
        return parseTransacao(result);
    }

    private Transacao parseTransacao(ResultSet result) throws SQLException {
        String id = result.getString("id_transacao");
        //Date dataTransacao = result.getDate("data_hora");
        BigDecimal montate = result.getBigDecimal("valor");
        String descricao = result.getString("descricao");
        String enderecoOrigem = result.getString("endereco_origem");
        String enderecoDestino = result.getString("endereco_destino");
        String hashTransacao = result.getString("hash_transacao");
        double taxaTransacao = result.getDouble("taxa_transacao");
        String nrConta = result.getString("nr_conta");
        String tipoTransacao = result.getString("tipo_transacao");
        String idCliente = result.getString("id_cliente");
        String idCorretora = result.getString("id_corretora");
        return new Transacao(id, /*dataTransacao,*/ montate, descricao, enderecoOrigem, enderecoDestino, hashTransacao, taxaTransacao, nrConta, tipoTransacao, idCliente, idCorretora);
    }

    public void updateTransacao(Transacao transacao) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("update transacao_cripto set" /*data_hora = ?,*/ + " valor = ?, descricao = ?, endereco_origem = ?, endereco_destino = ?, hash_transacao = ?, taxa_transacao = ?, nr_conta = ?, tipo_transacao = ?, id_cliente = ?, id_corretora = ? where id_transacao = ?");
        //stm.setDate(1, transacao.getData());
        stm.setBigDecimal(1, transacao.getMontante());
        stm.setString(2, transacao.getDescricao());
        stm.setString(3, transacao.getContaOrigem());
        stm.setString(4, transacao.getContaDestino());
        stm.setString(5, transacao.getHashTransacao());
        stm.setDouble(6, transacao.getTaxaTransacao());
        stm.setString(7, transacao.getNrConta());
        stm.setString(8, transacao.getTipoTransacao());
        stm.setString(9, transacao.getIdCliente().toString());
        stm.setString(10, transacao.getIdCorretora().toString());
        stm.setString(11, transacao.getIdTransacao().toString());
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
