package br.com.luiz.library.service;

import br.com.luiz.library.dao.Conexao;
import br.com.luiz.library.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                System.out.printf("ID      Título                               Preço     Ano     Edição     Páginas%n");
                System.out.printf("-----------------------------------------------------------------------------------%n");
                System.out.printf("%-6d  %-35s  R$%-6.2f  %-6d  %-9d  %-9d%n",
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
                " FROM livros WHERE id_livro = ?";

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
                System.out.printf("ID      Título                               Preço     Ano     Edição     Páginas%n");
                System.out.printf("---------------------------------------------------------------------------------%n");
                System.out.printf("%-6d  %-35s  R$%-6.2f  %-6d  %-9d  %-9d%n",
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

    public void listarLivros() {
        List<Livro> listaLivros = new ArrayList<>();
        String selectTodosLivros = "SELECT id_livro, titulo, preco, ano_publicacao, edicao, numero_paginas FROM livros order by id_livro";

        try (PreparedStatement stmt = conexao.prepareStatement(selectTodosLivros)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livroConsulta = new Livro();

                livroConsulta.setIdLivro(rs.getInt("id_livro"));
                livroConsulta.setTitulo(rs.getString("titulo"));
                livroConsulta.setPreco(rs.getDouble("preco"));
                livroConsulta.setAnoPublicacao(rs.getInt("ano_publicacao"));
                livroConsulta.setEdicao(rs.getInt("edicao"));
                livroConsulta.setNumeroPaginas(rs.getInt("numero_paginas"));

                listaLivros.add(livroConsulta);
            }

            System.out.printf("%nLivro:%n");
            System.out.printf("ID      Título                               Preço     Ano     Edição     Páginas%n");
            System.out.printf("---------------------------------------------------------------------------------%n");

            for (Livro livroConsulta : listaLivros) {
                System.out.printf("%-6d  %-35s  R$%-6.2f  %-6d  %-9d  %-9d%n",
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

    public void consultaExemplares(String id_livro) {
        /*List<Exemplares> listaExemplares = new ArrayList<>();

        String consultaExemplar = "SELECT l.titulo, ex.id_exemplar, ec.id_estado, ex.codigo_barras, ex.observacoes" +
                                    "FROM exemplares ex" +
                                        "JOIN livros l ON ex.id_livro = l.id_livro" +
                                        "JOIN estados_conservacao ec ON ex.id_estado_conservacao = ec.id_estado" +
                                    "WHERE l.id_livro = ?;";

        try (PreparedStatement stmt = conexao.prepareStatement(consultaExemplar)) {
            stmt.setString(1, id_livro);
            ResultSet rs = stmt.executeQuery();
            Exemplares exemplarConsulta = new Exemplares();

            while (rs.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void consultaEmprestimos() {

    }

    public void consultaUsuarios(String id_usuario) {
        Usuario usuarioConsulta = new Usuario();
        String consultaUsuarios = "SELECT id_usuario, nome, cpf, email, telefone FROM usuarios WHERE upper(nome) = upper(?);";

        try (PreparedStatement stmt = conexao.prepareStatement(consultaUsuarios)) {
            stmt.setString(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuarioConsulta.setIdUsuario(rs.getInt("id_usuario"));
                usuarioConsulta.setNome(rs.getString("nome"));
                usuarioConsulta.setCpf(rs.getString("cpf"));
                usuarioConsulta.setEmail(rs.getString("email"));
                usuarioConsulta.setTelefone(rs.getString("telefone"));

                System.out.printf("%Usuário:%n");
                System.out.print("ID      Nome                               CPF              E-mail                      Telefone\n");
                System.out.printf("-------------------------------------------------------------------------------------------------------%n");
                System.out.printf("%-6d  %-33s  %-15s  %-26s  %-9s",
                        usuarioConsulta.getIdUsuario(),
                        usuarioConsulta.getNome(),
                        usuarioConsulta.getCpf(),
                        usuarioConsulta.getEmail(),
                        usuarioConsulta.getTelefone());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultaUsuarios(int idUsuario) {
        Usuario usuarioConsulta = new Usuario();
        String consultaUsuarios = "SELECT id_usuario, nome, cpf, email, telefone FROM usuarios WHERE id_usuario = ?;";

        try (PreparedStatement stmt = conexao.prepareStatement(consultaUsuarios)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuarioConsulta.setIdUsuario(rs.getInt("id_usuario"));
                usuarioConsulta.setNome(rs.getString("nome"));
                usuarioConsulta.setCpf(rs.getString("cpf"));
                usuarioConsulta.setEmail(rs.getString("email"));
                usuarioConsulta.setTelefone(rs.getString("telefone"));

                System.out.printf("%nUsuário:%n");
                System.out.print("ID      Nome                               CPF              E-mail                      Telefone\n");
                System.out.printf("-------------------------------------------------------------------------------------------------------%n");
                System.out.printf("%-6d  %-33s  %-15s  %-26s  %-9s",
                        usuarioConsulta.getIdUsuario(),
                        usuarioConsulta.getNome(),
                        usuarioConsulta.getCpf(),
                        usuarioConsulta.getEmail(),
                        usuarioConsulta.getTelefone());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String selectTodosLivros = "SELECT id_usuario, nome, cpf, email, telefone FROM usuarios order by id_usuario";

        try (PreparedStatement stmt = conexao.prepareStatement(selectTodosLivros)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuarioConsulta = new Usuario();

                usuarioConsulta.setIdUsuario(rs.getInt("id_usuario"));
                usuarioConsulta.setNome(rs.getString("nome"));
                usuarioConsulta.setCpf(rs.getString("cpf"));
                usuarioConsulta.setEmail(rs.getString("email"));
                usuarioConsulta.setTelefone(rs.getString("telefone"));

                listaUsuarios.add(usuarioConsulta);
            }

            System.out.printf("%nUsuários:%n");
            System.out.print("ID      Nome                               CPF              E-mail                      Telefone\n");
            System.out.printf("-------------------------------------------------------------------------------------------------------%n");

            for (Usuario usuarioConsulta : listaUsuarios) {
                System.out.printf("%-6d  %-33s  %-15s  %-26s  %-9s \n",
                        usuarioConsulta.getIdUsuario(),
                        usuarioConsulta.getNome(),
                        usuarioConsulta.getCpf(),
                        usuarioConsulta.getEmail(),
                        usuarioConsulta.getTelefone());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}