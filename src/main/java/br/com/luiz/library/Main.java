package br.com.luiz.library;

import br.com.luiz.library.service.Consulta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao, consulta;

        System.out.println("------ Sistema de biblioteca ------");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Consulta");
        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                Consulta consultas = new Consulta();

                System.out.println("Escolha uma consulta: ");
                System.out.println("1. Consulta de livros");
                System.out.println("2. Consulta de exemplares");
                System.out.println("3. Consulta de empréstimos");
                System.out.println("4. Consulta de usuários");
                consulta = sc.nextInt();
                sc.nextLine();

                switch (consulta) {
                    case 1:
                        System.out.print("Digite o nome do livro: ");
                        String nomeLivro = sc.nextLine();
                        consultas.consultaLivros(nomeLivro);
                }
            default:

        }
    }
}