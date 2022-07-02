package br.com.alura.lojavirtual;

import java.sql.*;


public class TestaListagem  {

    public static void main(String[] args) throws SQLException {

       ConnectionFactory connectionFactory = new ConnectionFactory();
       Connection con = connectionFactory.recuperarConexao();

        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO ");
        stm.execute();

        ResultSet rst =  stm.getResultSet();

        while (rst.next()) {
            System.out.println(rst.getInt("ID") + " - " + rst.getString("NOME")
                    + " - " + rst.getString("DESCRICAO"));
        }
        rst.close();

    }



}
