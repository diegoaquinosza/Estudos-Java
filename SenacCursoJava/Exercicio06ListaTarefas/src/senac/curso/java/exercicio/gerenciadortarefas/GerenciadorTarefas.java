package senac.curso.java.exercicio.gerenciadortarefas;

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
                    System.out.print("Digite o nome da tarefa: ");
                    String newTarefa = input.nextLine();
                    tarefas.add(newTarefa);
                    System.out.print("Tarefa adicionada com sucesso!");
                    break;

                case "2":
                    System.out.println("\n--- Remover tarefa ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista de tarefas está vázia!");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println("Nº " + (i + 1) + " - " + tarefas.get(i));
                        }

                        System.out.print("Digite o número da tarefa que quer remover: ");
                        int delTarefa = input.nextInt();
                        input.nextLine();

                        if (delTarefa > 0 && delTarefa <= tarefas.size()) {
                            tarefas.remove(delTarefa - 1);
                            System.out.println("Tarefa removida com sucesso!");
                        } else {
                            System.out.println("número de tarefa inválido!");
                        }

                    }
                    break;

                case "3":
                    System.out.println("\n--- Marcar tarefa como concluída ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista de tarefas está vázia!");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println("Nº " + (i + 1) + " - " + tarefas.get(i));
                        }

                        System.out.print("Digite o número da tarefa que quer concluir: ");
                        int numOkTarefa = input.nextInt();
                        input.nextLine();

                        if (numOkTarefa > 0 && numOkTarefa <= tarefas.size()) {
                            int indiceReal = numOkTarefa - 1;
                            String tarefaAntiga = tarefas.get(indiceReal);
                            String tarefaOk = "[OK]" + tarefaAntiga;
                            tarefas.set(indiceReal, tarefaOk);
                            System.out.println("Tarefa concluída com sucesso!");
                        } else {
                            System.out.println("número de tarefa inválido!");
                        }

                    }

                    break;

                case "4":
                    System.out.println("\n--- Listar todas as tarefas ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista de tarefas está vázia!");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println("Nº " + (i + 1) + " - " + tarefas.get(i));
                        }
                    }
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
