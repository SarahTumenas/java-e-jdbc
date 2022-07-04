package br.com.alura.lojavirtual;

import br.com.alura.lojavirtual.dao.ProdutoDAO;
import br.com.alura.lojavirtual.modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {

            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
           //Lista = produtoDAO.listar();

        }

    }

}

