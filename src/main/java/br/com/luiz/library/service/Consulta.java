package br.com.luiz.library.service;

import br.com.luiz.library.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {

    public void consultaLivros(String titulo) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT id_livro, titulo FROM livros WHERE upper(titulo) = upper(?);";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_livro");
                String tituloLivro = rs.getString("titulo");
                System.out.println("Livro:\n" +
                                    "Id\t\tTitulo\n" +
                                    id + "\t\t" + tituloLivro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultaLivros(int id) {

    }

    public void consultaEmprestimos() {

    }

    public void consultaUsuarios() {

    }

    public void consultaExemplares() {

    }
}
