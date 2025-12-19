package senac.curso.java.exercicio.catracapoo;

import java.util.Scanner;

public class SistemaCatracaPoo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Catraca onibus1 = new Catraca();
        Catraca onibus2 = new Catraca();


        String opcao;

        do {
            System.out.print("\n===== CATRACA ELETRÔNICA =====\n" +
                    "1 - Registrar entrada de passageiro\n" +
                    "2 - Registrar saída de passageiro\n" +
                    "3 - Mostrar situação atual do ônibus\n" +
                    "4 - Mostrar total de ticket vendidos\n" +
                    "5 - Resetar ônibus (zerar passageiros)\n" +
                    "6 - Resetar frota (zerar dados da frota)\n" +
                    "7 - Sair\n" +
                    "Escolha uma opção: ");
            opcao = input.nextLine();
            switch (opcao) {
                case "1":
                    System.out.print("\n- Registrar entrada de passageiro");
                    String select;
                    do {
                        System.out.println("""
                            \n=== Escolha um Ônibus ===
                            1 - Ônibus 1
                            2 - Ônibus 2
                            3 - voltar
                            \s""");
                        System.out.print("Escolha um ônibus: ");
                        select = input.nextLine();
                        switch (select) {
                            case "1":
                                System.out.println("---> Ônibus 1");
                                onibus1.registrarEntrada();
                                break;
                            case "2":
                                System.out.println("---> Ônibus 2");
                                onibus2.registrarEntrada();
                                break;
                            case "3":
                                System.out.println("<- voltar");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (!select.equals("3"));
                    break;

                case "2":
                    System.out.println("\n - Registrar saída de passageiro");
                    do {
                        System.out.print("""
                            \n=== Escolha um Ônibus ===
                            1 - Ônibus 1
                            2 - Ônibus 2
                            3 - voltar
                            \s""");
                        System.out.print("Escolha um ônibus: ");
                        select = input.nextLine();
                        switch (select) {
                            case "1":
                                System.out.println("---> Ônibus 1");
                                onibus1.registrarSaida();
                                break;
                            case "2":
                                System.out.println("---> Ônibus 2");
                                onibus2.registrarSaida();
                                break;
                            case "3":
                                System.out.println("<- voltar");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (!select.equals("3"));
                    break;

                case "3":
                    System.out.println("\n - Mostrar situação do ônibus atual");
                    do {
                        System.out.print("""
                            \n=== Escolha um Ônibus ===
                            1 - Ônibus 1
                            2 - Ônibus 2
                            3 - voltar
                            \s""");
                        System.out.print("Escolha um ônibus: ");
                        select = input.nextLine();
                        switch (select) {
                            case "1":
                                System.out.println("\n---> Ônibus 1");
                                onibus1.mostrarSituacao();
                                break;
                            case "2":
                                System.out.println("\n---> Ônibus 2");
                                onibus2.mostrarSituacao();
                                break;
                            case "3":
                                System.out.println("<- voltar");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (!select.equals("3"));
                    break;

                case "4":
                    System.out.println("\n - Mostrar total de ticket vendidos");
                    Catraca.mostrarSituacaoGeral();
                    break;

                case "5":
                    System.out.println("\n - Resetar ônibus");
                    do {
                        System.out.print("""
                            \n=== Escolha um Ônibus ===
                            1 - Ônibus 1
                            2 - Ônibus 2
                            3 - voltar
                            \s""");
                        System.out.print("Escolha um ônibus: ");
                        select = input.nextLine();
                        switch (select) {
                            case "1":
                                System.out.print("\n---> Ônibus 1");
                                onibus1.resetar();
                                break;
                            case "2":
                                System.out.print("\n---> Ônibus 2");
                                onibus2.resetar();
                                break;
                            case "3":
                                System.out.println("<- voltar");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (!select.equals("3"));
                    break;

                case "6":
                    System.out.println("\n - Resetar frota");
                    Catraca.resetarFrota();
                    break;

                case "7":
                    System.out.println("\n - Sair");
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (!opcao.equals("7"));

    }
}