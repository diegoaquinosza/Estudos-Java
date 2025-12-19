package senac.curso.java.exercicio.catraca;

import java.util.Scanner;

public class SistemaCatraca {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int capacidadeMaxima = 45;
        int passageiro = 0;
        boolean lotado = false;
        String opcao;

        do {
            System.out.print("\n===== CATRACA ELETRÔNICA =====\n" +
                    "1 - Registrar entrada de passageiro\n" +
                    "2 - Registrar saída de passageiro\n" +
                    "3 - Mostrar situação atual do ônibus\n" +
                    "4 - Resetar ônibus (zerar passageiros)\n" +
                    "5 - Sair\n\n" +
                    "Escolha uma opção: ");
            opcao = input.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("- Registrar entrada de passageiro");
                    if (passageiro == 45) {
                        lotado = true;
                        System.out.println("Ônibus lotado! Ninguém pode entrar.");
                    } else {
                        passageiro++;
                        capacidadeMaxima--;
                        System.out.println("Passageiro embarcado");
                    }
                    break;

                case "2":
                    System.out.println(" - Registrar saída de passageiro");
                    if (passageiro == 0) {
                        lotado = false;
                        System.out.println("Ônibus vazio! Não há passageiros para sair.");
                    } else {
                        passageiro--;
                        capacidadeMaxima++;
                        System.out.println("Passageiro desembarcado");
                    }
                    break;

                case "3":
                    System.out.println(" - Mostrar situação atual do ônibus");
                    System.out.println("Passageiros atuais: " + passageiro);
                    System.out.println("Lugares disponíveis: " + capacidadeMaxima);
                    if (passageiro > 0 && passageiro < 45 ) {
                        System.out.println("Satus: Movimento normal");
                    } else {
                        System.out.println("Satus: " + (lotado ? "Lotado" : "Vazio"));
                    }
                    break;

                case "4":
                    System.out.println(" - Resetar ônibus");
                    passageiro = 0;
                    capacidadeMaxima = 45;
                    System.out.println("Passageiros zerados");
                    break;

                case "5":
                    System.out.println(" - Sair");
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("5"));

    }
}
