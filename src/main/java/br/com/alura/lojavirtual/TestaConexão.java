package br.com.alura.lojavirtual;

import java.sql.Connection;

import java.sql.SQLException;

public class TestaConexão {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.recuperarConexao()) {
            System.out.println("Fechando Conexão!");
        }
    }
}

