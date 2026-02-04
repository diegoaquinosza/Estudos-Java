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

            // ... TESTES ...
            // ... depois do criarCadastro ...

            // Teste: Mostra só as Correntes
            aux.listar(0);

            // Teste: Mostra só as Poupanças
            aux.listar(1);

            // ... códigos anteriores ...

            System.out.println("\n--- TESTE DE PESQUISA ---");
            // Tente pegar um número que EXISTA no seu arquivo cc.txt
            // Exemplo: Vou buscar a conta "1111-X" (troque pelo número real do seu arquivo)
            String numeroBusca = "001245-8"; // Use um número que existe no seu cc.txt

            // Busca do tipo 0 (Corrente)
            Conta encontrada = aux.pesquisar(numeroBusca, 0);

            if (encontrada != null) {
                System.out.println("✅ Conta Localizada!");
                System.out.println("Titular: " + encontrada.getTitular());
                System.out.println("Saldo: " + encontrada.getSaldo());
            } else {
                System.out.println("❌ Conta não encontrada (ou tipo incorreto).");
            }
        }
    }
