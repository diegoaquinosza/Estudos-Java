package entidades;

import aplicacao.Iniciar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// CONCEITO 1: CLASSE ABSTRATA
// A palavra 'abstract' define que esta classe é um MODELO.
// REGRA: É proibido dar "new Conta()". Só podemos instanciar as filhas (Corrente/Poupanca).
public abstract class Conta {

    // Atributos de Instância: Cada objeto tem o seu próprio número, nome e saldo.
    private String numConta;
    private String titular;
    private double saldo;

    // CONCEITO 2: STATIC (Compartilhado)
    // Esta lista pertence à CLASSE Conta, não a um objeto específico.
    // Funciona como o "Banco de Dados" na memória, compartilhado por todo o sistema.
    private static List<Conta> lista = new ArrayList<>();

    public Conta() {}

    public Conta(String numConta, String titular, double saldo) {
        this.numConta = numConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método auxiliar de leitura
    // É STATIC porque é chamado pelo 'criarCadastro' (que também é static).
    // Não precisa de dados de uma conta específica ("this") para funcionar.
    private static void gravar(BufferedReader leitorBuffer, int tipoConta) throws IOException{
        String linha;
        while ((linha = leitorBuffer.readLine()) != null){
            String[] dados = linha.split(";");
            String num = dados[0];
            String nome = dados[1];
            double saldoLido = Double.parseDouble(dados[2]);

            // POLIMORFISMO NA PRÁTICA:
            // Dependendo da flag (0 ou 1), criamos o objeto específico (filho)
            // e guardamos na lista genérica List<Conta>.
            if(tipoConta == 0) {
                double limite = Double.parseDouble(dados[3]);
                lista.add(new ContaCorrente(num, nome, saldoLido, limite));
            } else {
                double taxa = Double.parseDouble(dados[3]);
                lista.add(new ContaPoupanca(num, nome, saldoLido, taxa));
            }
        }
        leitorBuffer.close();
    }

    // CONCEITO 3: MÉTODO DE CLASSE (STATIC)
    // Como a classe é abstrata, não temos um objeto para chamar "c.criarCadastro()".
    // Por isso usamos STATIC, para chamar direto da classe: "Conta.criarCadastro()".
    public static void criarCadastro() throws IOException {
        // DICA PROVA: Verifique se o caminho da pasta está exato!
        String caminhoBase = "IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHAbstrato/";

        BufferedReader leitorCC = new BufferedReader(new FileReader(caminhoBase + Iniciar.cc));
        gravar(leitorCC, 0);

        BufferedReader leitorCP = new BufferedReader(new FileReader(caminhoBase + Iniciar.cp));
        gravar(leitorCP, 1);

        System.out.println("Base de dados carregada! Total de contas: " + lista.size());
    }

    // CONCEITO 4: MÉTODO DE INSTÂNCIA (NÃO É STATIC)
    // Por que saque NÃO é static?
    // R: Porque ele precisa mexer no "this.saldo". O saldo pertence a CADA conta individualmente.
    // Se fosse static, todos os clientes mexeriam no mesmo saldo compartilhado.
    public void saque(double valor){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", saldo);
        if(valor <= saldo){
            saldo -= valor;
            System.out.println("VALOR DEBITADO: R$ " + valor);
            System.out.printf("SALDO APÓS O SAQUE: R$ %.2f\n", saldo);
        } else {
            System.out.println("SALDO INSUFICIENTE.");
        }
    }

    public void deposito(double valor){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", saldo);
        saldo += valor;
        System.out.printf("SALDO APÓS O DEPOSITO: R$ %.2f\n", saldo);
    }

    // Getters e Setters
    public String getNumConta() { return numConta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    // Nota: Lógica do professor onde setSaldo acumula (+=)
    public void setSaldo(double valor) { this.saldo += valor; }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15.2f", numConta, titular, saldo);
    }

    // STATIC: Listar é uma função do "Sistema", não de uma conta específica.
    // Recebe 0 ou 1 para filtrar qual tipo imprimir.
    public static void listar(int tipoConta){
        if(tipoConta == 0) {
            System.out.println("\n--- RELATÓRIO CONTA CORRENTE ---");
            System.out.printf("%-10s %-20s %-15s %-8s", "Conta", "Titular", "Saldo", "Limite\n");
            for (Conta c : lista)
                // INSTANCEOF: Verifica se o objeto genérico "c" é do tipo ContaCorrente
                if(c instanceof ContaCorrente) System.out.println(c);
        } else {
            System.out.println("\n--- RELATÓRIO CONTA POUPANÇA ---");
            System.out.printf("%-10s %-20s %-15s %-8s", "Conta","Titular","Saldo","Taxa Mensal\n");
            for(Conta c: lista)
                if(c instanceof ContaPoupanca) System.out.println(c);
        }
    }

    // STATIC: Busca na lista global. Retorna um objeto "Conta" genérico.
    public static Conta pesquisar(String numeroBusca, int tipoConta){
        for(Conta c : lista){
            // Compara String usando .equals()
            if(c.numConta.equals(numeroBusca)) {
                // Só retorna se o número bater E o tipo for o correto
                if(tipoConta == 0 && c instanceof ContaCorrente) return c;
                if(tipoConta == 1 && c instanceof ContaPoupanca) return c;
            }
        }
        System.out.println("CONTA NÃO ENCONTRADA OU TIPO INCORRETO.");
        return null;
    }
}