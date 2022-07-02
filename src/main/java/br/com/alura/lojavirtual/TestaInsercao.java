package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        Statement stm = con.createStatement();
        stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO)" +
                " VALUES ('SMATTV', 'Smart TV 55NANO75 55 Polegadas 4K NanoCell HDMI 2.0 LG')", Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("Novo ID: " + id);
        }
        con.close();
    }
}
