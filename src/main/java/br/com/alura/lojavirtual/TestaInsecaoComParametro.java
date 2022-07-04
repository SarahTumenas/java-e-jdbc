package br.com.alura.lojavirtual;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

import java.sql.*;

public class TestaInsecaoComParametro {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.recuperarConexao()) {
            con.setAutoCommit(false);

            try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)"
                    , Statement.RETURN_GENERATED_KEYS)) {

                adicionarVariavel("apple watch ", "smart watch", stm);
                adicionarVariavel("Alexa ", "Smart Speaker ", stm);

                con.commit();

            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("Rollback executado");
                con.rollback();

            }
        }

    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {

        stm.setString(1, nome);
        stm.setString(2, descricao);

        /*if(nome.equals("apple watch")){
           throw new SQLException("não foi possível adicionar o produto");
        }*/
        stm.execute();
        try (ResultSet rst = stm.getGeneratedKeys()) {

            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("Novo ID: " + id);
            }
        }
   }
}
