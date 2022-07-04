package br.com.alura.lojavirtual;

import br.com.alura.lojavirtual.dao.CategoriaDao;
import br.com.alura.lojavirtual.dao.ProdutoDAO;
import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Categoria;
import br.com.alura.lojavirtual.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDao categoriaDao = new CategoriaDao(connection);
            List<Categoria> listaDeCategorias = categoriaDao.listar();
            listaDeCategorias.stream().forEach(categoria -> {
                    System.out.println(categoria.getNome());

                try {
                    for (Produto produto: new ProdutoDAO(connection).buscar(categoria)) {
                        System.out.println(categoria.getNome()+" - "+produto.getNome());

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
