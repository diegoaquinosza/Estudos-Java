package aplicacao;

import entidade.Conta;
import java.io.IOException;

    public class Iniciar {
        // Atributos estáticos pedidos no diagrama
        public static String cc = "cc.txt";
        public static String cp = "cp.txt";

        // O "throws IOException" aqui é obrigatório porque o criarCadastro avisa que pode dar erro
        public static void main(String[] args) throws IOException {
            System.out.println("--- SISTEMA BANCÁRIO ---");

            // 1. Instancia uma conta vazia apenas para chamar os métodos de gerenciamento
            // (Lembre-se: o criarCadastro preenche a lista estática que pertence à classe toda)
            Conta aux = new Conta();

            // 2. Chama o método que lê os arquivos
            System.out.println("Lendo arquivos...");
            aux.criarCadastro();

            // Teste para ver se deu certo (acessando a lista estática)
            System.out.println("\nVerificação Final:");
            if (!Conta.getLista().isEmpty()) {
                System.out.println("Sucesso! A lista contém " + Conta.getLista().size() + " contas.");

                // Vamos espiar o primeiro elemento para ver se é Corrente ou Poupança
                Conta primeira = Conta.getLista().get(0);
                System.out.println("Primeira conta carregada: " + primeira.getTitular() + " - Saldo: " + primeira.getSaldo());
            } else {
                System.out.println("Erro: A lista está vazia.");
            }
        }
    }
