package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection abrirConexao() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = "user_name";
            final String PASS = "user_password";
            con = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Conexao aberta");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: A classe de conexao nao foi encontrada" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            con.close();
            System.out.println("Conexao fechada");
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
    }

}
