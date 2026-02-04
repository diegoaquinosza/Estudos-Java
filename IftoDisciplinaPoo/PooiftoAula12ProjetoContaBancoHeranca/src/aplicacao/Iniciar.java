package aplicacao;

import entidade.Conta;
import entidade.ContaCorrente;
import entidade.ContaPoupanca;

import java.io.IOException;
import java.util.Scanner;

public class Iniciar {
    // Caminhos dos arquivos
    public static String cc = "cc.txt";
    public static String cp = "cp.txt";

    public static void main(String[] args) throws IOException {

        // Scanner para leitura do teclado
        Scanner scanner = new Scanner(System.in);

        // Objeto auxiliar criado apenas para carregar os dados e acessar a lista
        Conta contaAuxiliar = new Conta();

        System.out.println("Carregando arquivos de dados...");
        contaAuxiliar.criarCadastro(); // Carrega cc.txt e cp.txt para a memoria

        // --- DEFINICAO DOS MENUS (Textos) ---
        String menuGeral = "\n--- MENU PRINCIPAL ---\n"+
                "1 - Conta Corrente\n"+
                "2 - Conta Poupanca\n"+
                "3 - Sair\n"+
                "Opcao: ";

        String menuContaCorrente = "\n--- OPERACOES CONTA CORRENTE ---\n"+
                "1 - Saque (R$ 1000 fixo)\n"+
                "2 - Deposito (R$ 2000 fixo)\n"+
                "3 - Emprestimo (R$ 5000 fixo)\n"+
                "Opcao: ";

        String menuContaPoupanca = "\n--- OPERACOES CONTA POUPANCA ---\n"+
                "1 - Saque (R$ 1000 fixo)\n"+
                "2 - Deposito (R$ 2000 fixo)\n"+
                "3 - Rendimento (Simulacao 10 meses)\n"+
                "Opcao: ";

        // --- LOOP INFINITO DO SISTEMA ---
        while(true){

            // Exibe menu principal e le a escolha
            System.out.print(menuGeral);
            int opcaoPrincipal = scanner.nextInt();

            // Condicao de saida (Opcao 3 ou maior)
            if(opcaoPrincipal >= 3){
                System.out.println("Sistema finalizado.");
                break;
            }

            // --- FLUXO 1: CONTA CORRENTE ---
            if(opcaoPrincipal == 1){
                System.out.print(menuContaCorrente);
                int opcaoSubMenu = scanner.nextInt();

                // Mostra a lista para o usuario saber qual numero digitar
                contaAuxiliar.listar(0);

                System.out.print("Digite o Numero da Conta: ");
                String numeroContaBusca = scanner.next();

                // BUSCA E CASTING
                // 1. Pesquisa a conta pelo numero e tipo 0 (Corrente)
                // 2. (ContaCorrente): Forca a conversao (Cast) pois o metodo pesquisar retorna "Conta" generica
                ContaCorrente contaCorrenteEncontrada = (ContaCorrente) contaAuxiliar.pesquisar(numeroContaBusca, 0);

                // Validacao: Se nao encontrou (null), volta para o inicio do loop
                if(contaCorrenteEncontrada == null){
                    System.out.println("Conta nao encontrada.");
                    continue;
                }

                // Executa a acao na conta encontrada
                switch (opcaoSubMenu){
                    case 1:
                        contaCorrenteEncontrada.saque(1000);
                        break;
                    case 2:
                        contaCorrenteEncontrada.deposito(2000);
                        break;
                    case 3:
                        // Metodo exclusivo de ContaCorrente
                        contaCorrenteEncontrada.emprestimo(5000);
                        break;
                    default:
                        System.out.println("Opcao invalida");
                }
            }
            // --- FLUXO 2: CONTA POUPANCA ---
            else if(opcaoPrincipal == 2){
                System.out.print(menuContaPoupanca);
                int opcaoSubMenu = scanner.nextInt();

                contaAuxiliar.listar(1); // Lista as poupancas

                System.out.print("Digite o Numero da Conta: ");
                String numeroContaBusca = scanner.next();

                // Busca e Casting para Poupanca
                ContaPoupanca contaPoupancaEncontrada = (ContaPoupanca) contaAuxiliar.pesquisar(numeroContaBusca, 1);

                if(contaPoupancaEncontrada == null){
                    System.out.println("Conta nao encontrada.");
                    continue;
                }

                switch (opcaoSubMenu){
                    case 1:
                        contaPoupancaEncontrada.saque(1000);
                        break;
                    case 2:
                        contaPoupancaEncontrada.deposito(2000);
                        break;
                    case 3:
                        // Metodo exclusivo de ContaPoupanca
                        contaPoupancaEncontrada.ganhoMes(10);
                        break;
                    default:
                        System.out.println("Opcao invalida");
                }

            } else {
                System.out.println("Opcao invalida no menu principal.");
            }
        } // Fim do While

        scanner.close(); // Boa pratica: fechar o scanner ao sair
    }
}