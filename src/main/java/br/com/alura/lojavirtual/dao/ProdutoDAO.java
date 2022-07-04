package br.com.alura.lojavirtual.dao;

import br.com.alura.lojavirtual.modelo.Categoria;
import br.com.alura.lojavirtual.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar (Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());

            statement.execute();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    produto.setId(resultSet.getInt(1));
                }

            }
        }
    }

    public List <Produto> listar() throws SQLException {

        List <Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.execute();
            try (ResultSet rst= psmt.getResultSet()) {
                while (rst.next()) {
                    Produto produto =
                            new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(produto);

                }

                }
            }
        return produtos;
    }

    public List <Produto> buscar(Categoria categoria) throws SQLException {
        List <Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setInt(1, categoria.getId());
            psmt.execute();
            try (ResultSet rst= psmt.getResultSet()) {
                while (rst.next()) {
                    Produto produto =
                            new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(produto);

                }

            }
        }
        return produtos;
    }
}



