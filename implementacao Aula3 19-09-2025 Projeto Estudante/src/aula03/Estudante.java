package aula03;

import java.util.Scanner;

public class Estudante {
    // Atributos privados (Encapsulamento)
    private String nome;
    private String telefone;

    //construtores
    public Estudante() {
    }

    public Estudante(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    //Metodo Estático (Fábrica: cria e devolve um novo estudante)
    public static Estudante cadastrarEstudante(Scanner input){
        System.out.print("\n Digite o nome: ");
        String nome = input.nextLine();
        System.out.print("\n Digite o telefone: ");
        String telefone = input.nextLine();
        System.out.print("\n Estudante cadastrado com sucesso!");
        return new Estudante(nome, telefone);
    }

    // Metodo de Instância (O objeto fala sobre si mesmo)
    public void imprimir2(){
        System.out.println("nome: "+this.nome+", telefone: "+this.telefone);
    }

    public static void imprimir(Estudante aluno){
        System.out.println("nome: "+aluno.nome+", telefone: "+aluno.telefone);
    }


}
