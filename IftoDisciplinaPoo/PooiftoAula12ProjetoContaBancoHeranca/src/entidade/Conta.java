package entidade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private String numConta;
    private String titular;
    private double saldo;
    private static List<Conta> lista = new ArrayList<>();

    //Construtores-----------
    public Conta() {
    }

    public Conta(String numConta, String titular, double saldo) {
        this.numConta = numConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    //Métodos-----------------
    public void criarCadastro() throws IOException {
        File arquivoCC = new File("IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHeranca/cc.txt");
        Scanner leitorCC = new Scanner(arquivoCC);

        while (leitorCC.hasNextLine()) {
            String linha = leitorCC.nextLine();
            String[] partes = linha.split(";");

            // O .trim() é vital aqui para limpar os espaços: "; João" vira "João"
            String num = partes[0].trim();
            String nome = partes[1].trim();
            double saldo = Double.parseDouble(partes[2].trim());
            double limite = Double.parseDouble(partes[3].trim());

            ContaCorrente cc = new ContaCorrente(num, nome, saldo, limite);
            lista.add(cc);
        }
        leitorCC.close();

        File arquivoCP = new File("IftoDisciplinaPoo/PooiftoAula12ProjetoContaBancoHeranca/cp.txt");
        Scanner leitorCP = new Scanner(arquivoCP);

        while (leitorCP.hasNextLine()) {
            String linha = leitorCP.nextLine();
            String[] partes = linha.split(";");

            String num = partes[0].trim();
            String nome = partes[1].trim();
            double saldo = Double.parseDouble(partes[2].trim());
            double taxa = Double.parseDouble(partes[3].trim());

            ContaPoupanca cp = new ContaPoupanca(num, nome, saldo, taxa);
            lista.add(cp);
        }
        leitorCP.close();

        System.out.println("Cadastro carregado! Total de contas: " + lista.size());

    }

    public void saque(double valor) {
        // Verifica se tem saldo suficiente
        if (this.saldo >= valor) {
            this.saldo -= valor; // Debita
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
        }
    }

    public void deposito(double valor) {
        // Apenas soma
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado!");
    }

    // Recebe 0 para Corrente e 1 para Poupança
    public void listar(int tipo) {

        // 1. Cabeçalho para ficar organizado no console
        if (tipo == 0) {
            System.out.println("\n--- RELATÓRIO: CONTAS CORRENTES ---");
        } else if (tipo == 1) {
            System.out.println("\n--- RELATÓRIO: CONTAS POUPANÇA ---");
        } else {
            System.out.println("Opção inválida (Use 0 ou 1)");
            return; // Sai do método se o número for errado
        }

        // 2. Percorre a lista inteira (que tem os dois tipos misturados)
        for (Conta c : lista) {

            // CENÁRIO A: O usuário quer Conta Corrente (0)
            // E (&&) o objeto atual "c" É UMA (instanceof) ContaCorrente
            if (tipo == 0 && c instanceof ContaCorrente) {
                System.out.println("CC: " + c.getNumConta() + " | Titular: " + c.getTitular() + " | Saldo: " + c.getSaldo());
            }

            // CENÁRIO B: O usuário quer Conta Poupança (1)
            // E (&&) o objeto atual "c" É UMA (instanceof) ContaPoupanca
            else if (tipo == 1 && c instanceof ContaPoupanca) {
                System.out.println("CP: " + c.getNumConta() + " | Titular: " + c.getTitular() + " | Saldo: " + c.getSaldo());
            }
        }
    }

    public Conta pesquisar(String numContaProcurado, int tipo) {

        for (Conta c : lista) {
            // 1. Verifica se o número bate (Use equals para String!)
            if (c.getNumConta().equals(numContaProcurado)) {

                // 2. Verifica se o tipo bate com o que foi pedido
                if (tipo == 0 && c instanceof ContaCorrente) {
                    return c; // ACHOU Conta Corrente! Retorna ela.
                }
                else if (tipo == 1 && c instanceof ContaPoupanca) {
                    return c; // ACHOU Conta Poupança! Retorna ela.
                }
            }
        }
        // Se rodou a lista toda e não achou ou o tipo estava errado
        return null;
    }

    //Getters e Setters-------
    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static List<Conta> getLista() {
        return lista;
    }

    public static void setLista(List<Conta> lista) {
        Conta.lista = lista;
    }
}



