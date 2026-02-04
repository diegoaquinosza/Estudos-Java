package aplicacao;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;

import java.io.IOException;
import java.util.Scanner;

public class Iniciar {
    // Definição dos arquivos
    public static String cc = "IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHerancaProf/cc.txt";
    public static String cp = "IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHerancaProf/cp.txt";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // Objeto auxiliar usado apenas para carregar os dados e acessar a lista estática
        Conta contaAuxiliar = new Conta();

        contaAuxiliar.criarCadastro(); // Lê os arquivos e preenche a lista

        String menuGeral = "1 - Conta Corrente\n"+
                "2 - Conta Poupança\n"+
                "3 - Sair\n"+
                "Opção: ";

        String menuCC = "1 - Saque\n"+
                "2 - Deposito\n"+
                "3 - Emprestimo\n"+
                "Opção: ";

        String menuCP = "1 - Saque\n"+
                "2 - Deposito\n"+
                "3 - Rendimento\n"+
                "Opção: ";

        // Loop infinito (roda até encontrar o break)
        while(true){

            System.out.print(menuGeral);
            int opcaoMenu = scanner.nextInt();

            // Sair do sistema
            if(opcaoMenu >= 3)
                break;

            // --- OPÇÃO 1: CONTA CORRENTE ---
            if(opcaoMenu == 1){
                System.out.printf(menuCC);
                opcaoMenu = scanner.nextInt(); // Lê a sub-opção (Saque/Depósito...)

                // Lista as contas correntes (Tipo 0)
                contaAuxiliar.listar(0);

                System.out.print("Conta: ");
                String numeroConta = scanner.next();

                // Pesquisa e faz o CASTING (Converte Conta -> ContaCorrente)
                ContaCorrente contaEncontrada = (ContaCorrente) contaAuxiliar.pesquisar(numeroConta, 0);

                // Se não achou (null), volta para o começo do while
                if(contaEncontrada == null)
                    continue;

                // Executa a ação na conta encontrada
                switch (opcaoMenu){
                    case 1:
                        contaEncontrada.saque(1000);
                        break;
                    case 2:
                        contaEncontrada.deposito(2000);
                        break;
                    case 3:
                        contaEncontrada.emprestimo(5000);
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
            // --- OPÇÃO 2: CONTA POUPANÇA ---
            else {
                if(opcaoMenu == 2){
                    System.out.printf(menuCP);
                    opcaoMenu = scanner.nextInt();

                    // Lista poupanças (Tipo 1)
                    contaAuxiliar.listar(1);

                    System.out.print("Conta: ");
                    String numeroConta = scanner.next();

                    // Pesquisa e faz o CASTING (Converte Conta -> ContaPoupanca)
                    ContaPoupanca contaEncontrada = (ContaPoupanca) contaAuxiliar.pesquisar(numeroConta, 1);

                    if(contaEncontrada == null)
                        continue;

                    switch (opcaoMenu){
                        case 1:
                            contaEncontrada.saque(1000);
                            break;
                        case 2:
                            contaEncontrada.deposito(2000);
                            break;
                        case 3:
                            contaEncontrada.ganhoMes(10);
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } else {
                    System.out.println("OPÇÃO INVÁLIDA");
                }
            }
        } // Fim do While
    }
}