package exercicio_livro;

import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*System.out.println("\n---- Primeiro cadstre um livro! ----");
        System.out.print("Digite o título do livro: ");
        String titulo = input.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autor = input.nextLine();
        System.out.print("Digite o ano: ");
        int ano = input.nextInt();
        System.out.println("---- Livro cadastrado com sucesso! ----");
        input.nextLine();*/


        Livro meuLivro = (Livro.cadastrarLivro(input));

        String opcao;

        do {
            System.out.print("\n\n==== Menu Biblioteca ====" +
                    "\n[I] - Mostrar informação do livro" +
                    "\n[E] - Emprestar livro" +
                    "\n[D] - Devolver livro" +
                    "\n[S] - Sair" +
                    "\n\nEscolha uma opção: ");
            opcao = input.nextLine().toUpperCase();

            switch (opcao) {
                case "I":
                    System.out.println();
                    meuLivro.mostrarInfo();
                    break;

                case "E":
                    System.out.println("--- Emprestar livro ---");
                    meuLivro.emprestar();
                    break;

                case "D":
                    System.out.println("--- Devolver livro ---");
                    meuLivro.devolver();
                    break;

                case "S":
                    System.out.println("--- Saindo... Até logo! ---");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (!opcao.equals("S"));
    }
}
