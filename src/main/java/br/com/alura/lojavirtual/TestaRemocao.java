package br.com.alura.lojavirtual;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.recuperarConexao()) {

            try (PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?")) {
                stm.setInt(1, 3);

                stm.execute();

                Integer linhasModificadas = stm.getUpdateCount();

                System.out.println(" Quantidade de linhas Modificadas: " + linhasModificadas);

            }
        }
    }
}
