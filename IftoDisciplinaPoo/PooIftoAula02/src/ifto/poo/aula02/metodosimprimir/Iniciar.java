package ifto.poo.aula02.metodosimprimir;

import java.util.ArrayList;
import java.util.Scanner;

public class Iniciar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Aluno> lista = new ArrayList<>();

        Aluno.configurarCurso("Sistemas para Internet", "POO");

        for (int i = 0; i<3; i++) {
            Aluno aluno = new Aluno();
            aluno.cadastrarAluno(input);
            lista.add(aluno);
        }

        Aluno.imprimirLista(lista);
    }
}
