package br.com.alura.lojavirtual;

import java.sql.*;


public class TestaListagem  {

    public static void main(String[] args) throws SQLException {

       ConnectionFactory connectionFactory = new ConnectionFactory();
       Connection con = connectionFactory.recuperarConexao();

        Statement stm = con.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        ResultSet rst =  stm.getResultSet();

        while (rst.next()) {
            System.out.println(rst.getInt("ID") + " - " + rst.getString("NOME")
                    + " - " + rst.getString("DESCRICAO"));
        }
        con.close();

    }



}
