package exercicio_tarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();

        String opcao;

        do {
            System.out.print("\n\n==== Gerenciador de tarefas ====" +
                    "\n1 - Adicionar tarefa" +
                    "\n2 - Remover tarefa" +
                    "\n3 - Marcar tarefa como concluída" +
                    "\n4 - Listar todas as tarefas" +
                    "\n5 - Sair" +
                    "\n\nEscolha uma opção: ");
            opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\n--- Adicionar tarefa ---");
                    break;
                    
                case "2":
                    System.out.println("\n--- Remover tarefa ---");
                    break;

                case "3":
                    System.out.println("\n--- Marcar tarefa como concluída ---");
                    break;

                case "4":
                    System.out.println("\n--- Listar todas as tarefas ---");
                    break;

                case "5":
                    System.out.println("--- Sair ---");
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("!!! Opção inválida!");
            }


        } while (!opcao.equals("5"));
    }
}
