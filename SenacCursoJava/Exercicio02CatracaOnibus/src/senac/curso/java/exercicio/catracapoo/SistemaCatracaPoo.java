package senac.curso.java.exercicio.catracapoo;

import java.util.Scanner;

public class SistemaCatracaPoo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Catraca onibus = new Catraca();

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
                    onibus.registrarEntrada();
                    break;

                case "2":
                    System.out.println(" - Registrar saída de passageiro");
                    onibus.registrarSaida();
                    break;

                case "3":
                    System.out.println(" - Mostrar situação atual do ônibus");
                    onibus.mostrarSituacao();
                    break;

                case "4":
                    System.out.println(" - Resetar ônibus");
                    onibus.resetar();
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