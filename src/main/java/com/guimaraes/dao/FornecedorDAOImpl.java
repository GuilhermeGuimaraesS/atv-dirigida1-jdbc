package com.guimaraes.dao;

import com.guimaraes.config.ConnectionFactory;
import com.guimaraes.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FornecedorDAOImpl implements FornecedorDAO{

    private final ConnectionFactory connectionFactory;

    public FornecedorDAOImpl() {
        this.connectionFactory = ConnectionFactory.getInstance();
    }

    @Override
    public void salvar(Fornecedor fornecedor){
        // As interrogações serão subsituídas pelos parâmetros passados no preparedStatement
        String sql = """
                INSERT INTO fornecedor
                    (nome, CNPJ)
                VALUES
                    (?, ?)
                """;
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setObject(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getCNPJ());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Fornecedor> listarTodos(){
        String sql = """
                SELECT 
                    id, 
                    nome,
                    cnpj,
                    registrado_em
                FROM fornecedor
                ORDER BY id
                """;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

        ){
            while(resultSet.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setID(resultSet.getObject("id", UUID.class));
                fornecedor.setNome(resultSet.getString("nome"));
                fornecedor.setCNPJ(resultSet.getString("cnpj"));
                fornecedor.setRegistradoEm(resultSet.getObject("registrado_em", LocalDateTime.class));
                fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public Fornecedor buscarPorId(UUID id) {

        String sql = """
            SELECT
                id,
                nome,
                cnpj,
                registrado_em
            FROM fornecedor
            WHERE id = ?
            """;

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setObject(1, id);
            try (
                    ResultSet resultSet = statement.executeQuery();
            ) {
                if (resultSet.next()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setID(resultSet.getObject("id", UUID.class));
                    fornecedor.setNome(resultSet.getString("nome"));
                    fornecedor.setCNPJ(resultSet.getString("cnpj"));
                    fornecedor.setRegistradoEm(resultSet.getObject("registrado_em", LocalDateTime.class));
                    return fornecedor;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Fornecedor buscarPorCNPJ(String CNPJ) {

        String sql = """
            SELECT
                id,
                nome,
                cnpj,
                registrado_em
            FROM fornecedor
            WHERE cnpj = ?
            """;
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setObject(1, CNPJ);
            try (
                    ResultSet resultSet = statement.executeQuery();
            ) {
                if (resultSet.next()){
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setID(resultSet.getObject("id", UUID.class));
                    fornecedor.setNome(resultSet.getString("nome"));
                    fornecedor.setCNPJ(resultSet.getString("cnpj"));
                    fornecedor.setRegistradoEm(resultSet.getObject("registrado_em", LocalDateTime.class));
                    return fornecedor;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor){
        String sql = """
                UPDATE fornecedor
                SET
                    nome = ?
                WHERE cnpj = ?
                """;

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
                statement.setString(1, fornecedor.getNome());
                statement.setObject(2, fornecedor.getCNPJ());
                statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(UUID id) {
        String sql = """
                DELETE FROM fornecedor 
                WHERE id = ?
                """;
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
