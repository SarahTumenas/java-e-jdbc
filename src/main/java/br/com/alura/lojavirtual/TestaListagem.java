package br.com.alura.lojavirtual;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

import java.sql.*;


public class TestaListagem  {

    public static void main(String[] args) throws SQLException {

       ConnectionFactory connectionFactory = new ConnectionFactory();
       try (Connection con = connectionFactory.recuperarConexao()) {

           try (PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO ")) {
               stm.execute();

               try(ResultSet rst = stm.getResultSet()) {

                   while (rst.next()) {
                       System.out.println(rst.getInt("ID") + " - " + rst.getString("NOME")
                               + " - " + rst.getString("DESCRICAO"));
                   }
               }

           }
       }
    }
}
