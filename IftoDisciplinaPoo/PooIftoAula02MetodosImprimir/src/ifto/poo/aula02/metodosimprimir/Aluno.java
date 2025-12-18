package ifto.poo.aula02.metodosimprimir;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private static String nomeCurso;
    private static String disciplina;
    private String nomeAluno;
    private int idade;

    public static void configurarCurso(String nomeCurso, String disciplina) {
        Aluno.nomeCurso = nomeCurso;
        Aluno.disciplina = disciplina;
    }

    public void cadastrarAluno(Scanner input) {
        System.out.print("\n==== Cadastrar Aluno ==== ");
        System.out.print("\nDigite o nome do Aluno: ");
        this.nomeAluno = input.nextLine();
        System.out.print("Digite a idade do Aluno: ");
        this.idade = input.nextInt();
        input.nextLine();
        System.out.println(" ------------------------");
    }

    public void imprimirFicha() {
        System.out.println("\n ---- Ficha do Aluno ----");
        System.out.println("Curso: "+Aluno.nomeCurso);
        System.out.println("Disciplina: "+Aluno.disciplina);
        System.out.println("Nome do Aluno: "+this.nomeAluno);
        System.out.println("Idade do Aluno: "+this.idade);
        System.out.println(" ------------------------");
    }

    public static void imprimirLista(ArrayList<Aluno> lista) {
        for (Aluno aluno : lista) {
            aluno.imprimirFicha();
        }
    }

}
