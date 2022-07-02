package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        Statement stm = con.createStatement();
        stm.execute("DELETE FROM PRODUTO WHERE ID > 3");

        Integer linhasModificadas = stm.getUpdateCount();

        System.out.println(" Quantidade de linhas Modificadas: " + linhasModificadas);
        con.close();
    }
}
