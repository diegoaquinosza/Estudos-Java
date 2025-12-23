package senac.curso.java.exercicio.laboratorio;

import java.util.Scanner;

public class SistemaLaboratorio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            System.out.print("\n" +
                    "==== SISTEMA DE SEGURANÇA DO LABORÁTORIO ==== +" +
                    "1 - Abrir/Fechar porta\n" +
                    "2 - Alterar temperatura (normal/alta)\n" +
                    "3 - Alterar nível de gases tóxicos (presentes/ausentes)\n" +
                    "4 - Ativar/Desativar alarme\n" +
                    "5 - Relatório de Segurança\n" +
                    "6 - Resetar sistema\n" +
                    "7 – Sair" +
                    "\n\nEscolha uma opcao: ");
            opcao = input.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Abrir/Fechar porta");
                    break;
                case "2":
                    System.out.println("Alterar temperatura (normal/alta)");
                    break;
                case "3":
                    System.out.println("Alterar nível de gases tóxicos (presentes/ausentes)");
                    break;
                case "4":
                    System.out.println("Ativar/Desativar alarme");
                    break;
                case "5":
                    System.out.println("Relatório de Segurança");
                    break;
                case "6":
                    System.out.println("Resetar sistema");
                    break;
                case "7":
                    System.out.println("Sair");
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (!opcao.equals("7"));
    }
}
