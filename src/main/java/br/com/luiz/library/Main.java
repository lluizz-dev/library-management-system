package br.com.luiz.library;

import br.com.luiz.library.service.Consulta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao, consulta;

        System.out.println("------ Sistema de Biblioteca ------");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Consulta");
        opcao = input.nextInt();
        input.nextLine();

        switch (opcao) {
            case 1:
                Consulta consultas = new Consulta();

                System.out.println("\n--- Consulta ----");
                System.out.println("1. Consulta de livros");
                System.out.println("2. Consulta de exemplares");
                System.out.println("3. Consulta de empréstimos");
                System.out.println("4. Consulta de usuários");
                consulta = input.nextInt();
                input.nextLine();

                switch (consulta) {
                    case 1:
                        System.out.println("\n--- Consulta de Livros ---");
                        System.out.println("Como deseja pesquisar?");
                        System.out.println("1. Por ID do livro");
                        System.out.println("2. Por nome/título do livro");
                        System.out.println("3. Listar todos os livros");
                        System.out.print("Escolha: ");

                        int tipoConsulta = input.nextInt();
                        input.nextLine(); // Limpar buffer

                        switch (tipoConsulta) {
                            case 1:
                                System.out.print("Digite o ID do livro: ");
                                int idLivro = input.nextInt();
                                input.nextLine();
                                consultas.consultaLivros(idLivro);
                                break;

                            case 2:
                                System.out.print("Digite o nome do livro: ");
                                String nomeLivro = input.nextLine();
                                consultas.consultaLivros(nomeLivro);
                                break;

                            case 3:
                                //Função de listar todos os livros
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 2:
                        // Consulta de exemplares
                        break;

                    case 3:
                        // Consulta de empréstimos
                        break;

                    case 4:
                        // Consulta de usuários
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
                break;

            default:
                System.out.println("Opção inválida!");
        }

        input.close();
    }
}