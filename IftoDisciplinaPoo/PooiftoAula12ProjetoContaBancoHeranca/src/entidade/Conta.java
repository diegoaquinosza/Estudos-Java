package entidade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    // Atributos Encapsulados (private): Só a própria classe acessa diretamente.
    private String numConta;
    private String titular;
    private double saldo;

    // STATIC: Significa que esta lista pertence à CLASSE Conta, e não a um objeto específico.
    // É uma memória compartilhada por todo o sistema.
    // O polimorfismo acontece aqui: List<Conta> aceita ContaCorrente e ContaPoupanca.
    private static List<Conta> lista = new ArrayList<>();

    // --- Construtores ---
    public Conta() {
        // Construtor vazio: Útil para criar um objeto "auxiliar" apenas para chamar métodos.
    }

    public Conta(String numConta, String titular, double saldo) {
        this.numConta = numConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // --- Métodos de Regra de Negócio ---

    // "throws IOException": Avisa que se der erro de leitura (arquivo não existe),
    // quem chamou este método (Main) que se vire para tratar. Não usamos try-catch aqui.
    public void criarCadastro() throws IOException {

        // --- Leitura de Conta Corrente ---
        // Cria o vínculo com o arquivo físico no disco
        File arquivoCC = new File("IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHeranca/cc.txt");
        Scanner leitorCC = new Scanner(arquivoCC);

        while (leitorCC.hasNextLine()) { // Enquanto houver linhas no arquivo...
            String linha = leitorCC.nextLine(); // Lê a linha inteira
            String[] partes = linha.split(";"); // Quebra a linha onde tem ";" criando um vetor

            // .trim(): Remove espaços em branco antes e depois (ex: " João" vira "João")
            String num = partes[0].trim();
            String nome = partes[1].trim();
            // Double.parseDouble: Converte o texto "100.00" para o número 100.00
            double saldo = Double.parseDouble(partes[2].trim());
            double limite = Double.parseDouble(partes[3].trim());

            // Cria o objeto filho (Corrente)
            ContaCorrente cc = new ContaCorrente(num, nome, saldo, limite);

            // Adiciona na lista Genérica (Polimorfismo: A lista é de Conta, mas aceita Corrente)
            lista.add(cc);
        }
        leitorCC.close(); // Libera o arquivo

        // --- Leitura de Conta Poupança ---
        File arquivoCP = new File("IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHeranca/cp.txt");
        Scanner leitorCP = new Scanner(arquivoCP);

        while (leitorCP.hasNextLine()) {
            String linha = leitorCP.nextLine();
            String[] partes = linha.split(";");

            // Repete o processo de limpeza e conversão
            String num = partes[0].trim();
            String nome = partes[1].trim();
            double saldo = Double.parseDouble(partes[2].trim());
            double taxa = Double.parseDouble(partes[3].trim());

            // Cria o objeto filho (Poupança)
            ContaPoupanca cp = new ContaPoupanca(num, nome, saldo, taxa);
            lista.add(cp);
        }
        leitorCP.close();

        System.out.println("Cadastro carregado com sucesso! Total: " + lista.size());
    }

    public void saque(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque realizado. Novo saldo: " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void deposito(double valor) {
        this.saldo += valor;
        System.out.println("Depósito realizado. Novo saldo: " + this.saldo);
    }

    // Método para filtrar relatórios
    public void listar(int tipo) {
        // Cabeçalhos de organização
        if (tipo == 0) System.out.println("\n--- LISTAGEM: CONTA CORRENTE ---");
        else if (tipo == 1) System.out.println("\n--- LISTAGEM: CONTA POUPANÇA ---");

        // Percorre a lista mista
        for (Conta c : lista) {

            // INSTANCEOF: O "Raio-X" do Java.
            // Verifica se o objeto genérico "c" é, na verdade, uma ContaCorrente.
            if (tipo == 0 && c instanceof ContaCorrente) {
                System.out.println("CC: " + c.getNumConta() + " | Titular: " + c.getTitular());
            }
            // Verifica se é ContaPoupanca
            else if (tipo == 1 && c instanceof ContaPoupanca) {
                System.out.println("CP: " + c.getNumConta() + " | Titular: " + c.getTitular());
            }
        }
    }

    // Retorna o objeto Conta encontrado (ou null se não achar)
    public Conta pesquisar(String numContaProcurado, int tipo) {
        for (Conta c : lista) {
            // 1. Verifica se o número é igual (equals para Strings)
            if (c.getNumConta().equals(numContaProcurado)) {

                // 2. Verifica se o tipo é o desejado (instanceof)
                if (tipo == 0 && c instanceof ContaCorrente) {
                    return c; // Retorna o objeto e para a busca
                }
                else if (tipo == 1 && c instanceof ContaPoupanca) {
                    return c;
                }
            }
        }
        return null; // Não encontrou ninguém
    }

    // --- Getters e Setters (Encapsulamento) ---
    public String getNumConta() { return numConta; }
    public void setNumConta(String numConta) { this.numConta = numConta; }
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public static List<Conta> getLista() { return lista; }
    public static void setLista(List<Conta> lista) { Conta.lista = lista; }
}