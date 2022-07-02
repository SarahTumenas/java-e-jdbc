package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection recuperarConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual", "root", "root");
    }
}

