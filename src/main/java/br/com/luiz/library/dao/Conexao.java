package br.com.luiz.library.dao;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao  {
        private static Connection conexao;

        // Objeto para conectar com o .env
        private static final Dotenv dotenv = Dotenv.load();

        // Parâmetros de conexão
        private static final String URL = dotenv.get("DB_URL");
        private static final String USUARIO = dotenv.get("DB_USER");
        private static final String SENHA = dotenv.get("DB_PASSWORD");

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (SQLException e) {
                System.out.println("Erro ao conectar: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
                System.out.println("Conexão fechada!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
