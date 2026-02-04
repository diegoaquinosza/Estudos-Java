package aplicacao;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;

import java.io.IOException;
import java.util.Scanner;

public class Iniciar {
    public static String cc = "cc.txt";
    public static String cp = "cp.txt";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // MUDANÇA IMPORTANTE (ABSTRACT):
        // Não existe mais "Conta c = new Conta()".
        // Motivo: Conta é abstrata e não pode ser instanciada.

        System.out.println("--- INICIANDO SISTEMA BANCÁRIO (AULA 13 - ABSTRACT) ---");

        // CHAMADA ESTÁTICA:
        // Acessamos o método direto pela Classe (Conta.), sem precisar de objeto.
        Conta.criarCadastro();

        String menuPrincipal = "\n1 - Conta Corrente\n2 - Conta Poupança\n3 - Sair\nOpção: ";
        String menuCC = "\n[CONTA CORRENTE]\n1 - Saque\n2 - Deposito\n3 - Emprestimo\nOpção: ";
        String menuCP = "\n[CONTA POUPANÇA]\n1 - Saque\n2 - Deposito\n3 - Rendimento\nOpção: ";

        while(true){
            System.out.print(menuPrincipal);
            int opcao = scanner.nextInt();

            if(opcao >= 3) {
                System.out.println("Saindo...");
                break;
            }

            // --- OPÇÃO 1: CONTA CORRENTE ---
            if(opcao == 1){
                System.out.print(menuCC);
                int acao = scanner.nextInt();

                // Chama o método estático para listar apenas as correntes (tipo 0)
                Conta.listar(0);
                System.out.print("Digite o Número da Conta: ");
                String num = scanner.next();

                // CONCEITO: CASTING (Conversão Forçada)
                // O método Conta.pesquisar retorna um objeto genérico "Conta".
                // Precisamos converter para "(ContaCorrente)" para acessar métodos exclusivos como 'emprestimo'.
                ContaCorrente cc = (ContaCorrente) Conta.pesquisar(num, 0);

                if(cc != null) {
                    switch (acao){
                        case 1: cc.saque(1000); break;     // Método herdado de Conta
                        case 2: cc.deposito(2000); break;  // Método herdado de Conta
                        case 3: cc.emprestimo(5000); break;// Método EXCLUSIVO de ContaCorrente
                        default: System.out.println("Opção Inválida");
                    }
                }
            }
            // --- OPÇÃO 2: CONTA POUPANÇA ---
            else if(opcao == 2){
                System.out.print(menuCP);
                int acao = scanner.nextInt();

                Conta.listar(1);
                System.out.print("Digite o Número da Conta: ");
                String num = scanner.next();

                // CASTING: Converte a Conta genérica encontrada para ContaPoupanca
                ContaPoupanca cp = (ContaPoupanca) Conta.pesquisar(num, 1);

                if(cp != null) {
                    switch (acao){
                        case 1: cp.saque(1000); break;
                        case 2: cp.deposito(2000); break;
                        case 3: cp.ganhoMes(10); break; // Método EXCLUSIVO de ContaPoupanca
                        default: System.out.println("Opção Inválida");
                    }
                }
            }
        }
    }
}