package br.com.alura.lojavirtual;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

import java.sql.*;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {

        String nome = "SMARTTV";
        String descricao = "Smart TV 55NANO75 55 Polegadas 4K NanoCell HDMI 2.0 LG";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection con = connectionFactory.recuperarConexao()) {

            try(PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)"
                    , Statement.RETURN_GENERATED_KEYS)) {

                stm.setString(1, nome);
                stm.setString(2, descricao);

                stm.execute();

                 try(ResultSet rst = stm.getGeneratedKeys()) {

                     while (rst.next()) {
                         Integer id = rst.getInt(1);
                         System.out.println("Novo ID: " + id);
                     }
                 }
            }
        }
    }
}
