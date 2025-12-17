package exercicio_livro;

import java.util.Scanner;

public class Livro {

    private String titulo;
    private String autor;
    private int ano;
    private boolean emprestado = false;

    //Construtores
    public Livro() {
    }

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
    }

    //Métodos
    public static Livro cadastrarLivro (Scanner input) {
        System.out.println("\n---- Primeiro cadstre um livro! ----");
        System.out.print("Digite o título do livro: ");
        String tituloTemp = input.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autorTemp = input.nextLine();
        System.out.print("Digite o ano: ");
        int anoTemp = input.nextInt();
        input.nextLine();
        System.out.println("---- Livro cadastrado com sucesso! ----");
        return new Livro(tituloTemp, autorTemp, anoTemp);
    }

    public void emprestar() {
        if (!this.emprestado) {
            this.emprestado = true;
            System.out.println("\nLivro emprestado com sucesso!");
        } else {
            System.out.println("\nLivro já está emprestado!");
        }
    }

    public void devolver() {
        if (this.emprestado) {
            this.emprestado = false;
            System.out.println("\nLivro devolvido com sucesso!");
        } else {
            System.out.println("\nLivro está na estante (já foi devolvido!)");
        }
    }

    public void mostrarInfo() {
        System.out.println("\n---- Mostar Info Livro ----");
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano: " + this.ano);
        System.out.println("Emprestado: " + (this.emprestado ? "Sim" : "Não"));
    }
}
