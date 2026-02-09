package br.com.luiz.library.service;

import br.com.luiz.library.dao.Conexao;
import br.com.luiz.library.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {

    private final Connection conexao = Conexao.getConexao();

    public void consultaLivros(String titulo) {
        Livro livroConsulta = new Livro();

        String consultaLivroTitulo = "SELECT id_livro, titulo, preco, ano_publicacao, edicao, numero_paginas" +
                                        " FROM livros WHERE upper(titulo) = upper(?);";

        try (PreparedStatement stmt = conexao.prepareStatement(consultaLivroTitulo)) {
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                livroConsulta.setIdLivro(rs.getInt("id_livro"));
                livroConsulta.setTitulo(rs.getString("titulo"));
                livroConsulta.setPreco(rs.getDouble("preco"));
                livroConsulta.setAnoPublicacao(rs.getInt("ano_publicacao"));
                livroConsulta.setEdicao(rs.getInt("edicao"));
                livroConsulta.setNumeroPaginas(rs.getInt("numero_paginas"));

                System.out.printf("%nLivro:%n");
                System.out.printf("ID      Título                     Preço     Ano     Edição     Páginas%n");
                System.out.printf("-----------------------------------------------------------------------%n");
                System.out.printf("%-6d  %-25s  R$%-8.2f  %-6d  %-9d  %-9d%n",
                        livroConsulta.getIdLivro(),
                        livroConsulta.getTitulo(),
                        livroConsulta.getPreco(),
                        livroConsulta.getAnoPublicacao(),
                        livroConsulta.getEdicao(),
                        livroConsulta.getNumeroPaginas());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultaLivros(int id) {
        Livro livroConsulta = new Livro();

        String consultaLivroId = "SELECT id_livro, titulo, preco, ano_publicacao, edicao, numero_paginas" +
                " FROM livros WHERE upper(titulo) = upper(?);";

        try (PreparedStatement stmt = conexao.prepareStatement(consultaLivroId)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                livroConsulta.setIdLivro(rs.getInt("id_livro"));
                livroConsulta.setTitulo(rs.getString("titulo"));
                livroConsulta.setPreco(rs.getDouble("preco"));
                livroConsulta.setAnoPublicacao(rs.getInt("ano_publicacao"));
                livroConsulta.setEdicao(rs.getInt("edicao"));
                livroConsulta.setNumeroPaginas(rs.getInt("numero_paginas"));

                System.out.printf("%nLivro:%n");
                System.out.printf("ID      Título                     Preço     Ano     Edição     Páginas%n");
                System.out.printf("-----------------------------------------------------------------------%n");
                System.out.printf("%-6d  %-25s  R$%-8.2f  %-6d  %-9d  %-9d%n",
                        livroConsulta.getIdLivro(),
                        livroConsulta.getTitulo(),
                        livroConsulta.getPreco(),
                        livroConsulta.getAnoPublicacao(),
                        livroConsulta.getEdicao(),
                        livroConsulta.getNumeroPaginas());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void consultaEmprestimos() {

    }

    public void consultaUsuarios() {

    }

    public void consultaExemplares() {

    }
}
