package br.com.alura.lojavirtual.dao;

import br.com.alura.lojavirtual.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Connection connection;

    public CategoriaDao(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT ID, NOME FROM CATEGORIA";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();
            try (ResultSet rs = pstm.getResultSet()) {
                while (rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
                    categorias.add(categoria);
                }
            }
        }
        return categorias;
    }

}

