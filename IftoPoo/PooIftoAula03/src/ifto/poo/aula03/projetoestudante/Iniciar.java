package ifto.poo.aula03.projetoestudante;

import java.util.ArrayList;
import java.util.Scanner;

public class Iniciar {
    public static void main(String[] args) {
        ArrayList<Estudante> turma = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            System.out.print("\n\n==== Escolha uma opção ====" +
                    "\n 1 - Cadastrar estudante" +
                    "\n 2 - Imprimir todos os estudantes" +
                    "\n 0 - Sair" +
                    "\n\n Escolha uma opção: ");

            opcao = input.nextLine();

            switch (opcao) {

                case "1":
                    System.out.println("\n ---- Cadastrar estudante ----");
                    turma.add(Estudante.cadastrarEstudante(input));
                    break;

                case "2":
                    System.out.println("\n ---- Imprimir todos os estudantes ----");
                    if (turma.isEmpty()){
                        System.out.println("\nLista vázia!");
                        break;
                    }

                    for (Estudante aluno : turma) {
                        //Estudante.imprimir(aluno);
                        aluno.imprimir2();
                    }
                    break;

                case "0":
                    System.out.println("\n ---- Sair ----" +
                            "\n Saindo... até logo!");
                    break;

                default:
                    System.out.println("\n Opção inválida! tente novamente.");
                    break;
            }
        } while (!opcao.equals("0"));


    }


}
