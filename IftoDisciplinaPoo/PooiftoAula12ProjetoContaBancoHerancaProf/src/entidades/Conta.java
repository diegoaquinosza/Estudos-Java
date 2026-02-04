package entidades;

import aplicacao.Iniciar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    // Atributos protegidos (private + getters/setters)
    private String numConta;
    private String titular;
    private double saldo;

    // Lista Estática: Compartilhada por todas as contas (o "Banco de Dados" em memória)
    private static List<Conta> lista = new ArrayList<>();

    // Construtores
    public Conta() {
    }

    public Conta(String numConta, String titular, double saldo) {
        this.numConta = numConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método auxiliar para ler o arquivo (chamado de 'gravar' pelo professor, mas ele 'Lê e Grava na Lista')
    // flag/tipoConta: 0 = Corrente, 1 = Poupança
    private void gravar(BufferedReader leitorBuffer, int tipoConta) throws IOException{
        double limiteEmp = 0, taxaRend = 0;
        String linha;

        // Enquanto tiver linhas no arquivo...
        while ((linha = leitorBuffer.readLine()) != null){
            // Quebra a linha "123;Diego;500" em um vetor ["123", "Diego", "500"]
            String[] dadosLinha = linha.split(";");

            double saldoLido = Double.parseDouble(dadosLinha[2]);

            // Se for Tipo 0 (Corrente), lê o limite e cria ContaCorrente
            if(tipoConta == 0) {
                limiteEmp = Double.parseDouble(dadosLinha[3]);
                lista.add(new ContaCorrente(dadosLinha[0], dadosLinha[1], saldoLido, limiteEmp));
            }
            // Se for Tipo 1 (Poupança), lê a taxa e cria ContaPoupanca
            else {
                taxaRend = Double.parseDouble(dadosLinha[3]);
                lista.add(new ContaPoupanca(dadosLinha[0], dadosLinha[1], saldoLido, taxaRend));
            }
        }
        leitorBuffer.close(); // Fecha o arquivo
    }

    public void criarCadastro() throws IOException {
        // BufferedReader é uma alternativa ao Scanner, mais rápido para ler linhas inteiras
        BufferedReader leitorBuffer = new BufferedReader(new FileReader(Iniciar.cc));
        gravar(leitorBuffer, 0); // Carrega Contas Correntes

        leitorBuffer = new BufferedReader(new FileReader(Iniciar.cp));
        gravar(leitorBuffer, 1); // Carrega Contas Poupança
    }

    public void saque(double valor){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", saldo);

        if(valor <= saldo){
            saldo -= valor; // Debita do saldo
            System.out.println("VALOR DEBITADO: R$ " + valor);
            System.out.printf("SALDO APÓS O SAQUE: R$ %.2f\n", saldo);
        } else {
            System.out.println("SALDO INSUFICIENTE.");
        }
    }

    public void deposito(double valor){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", saldo);
        saldo += valor; // Soma ao saldo
        System.out.printf("SALDO APÓS O DEPOSITO: R$ %.2f\n", saldo);
    }

    // Getters e Setters
    public double getSaldo() {
        return saldo;
    }

    // ATENÇÃO: O professor implementou o setSaldo como um "adicionar saldo" (+=)
    // Normalmente um set substitui o valor, mas aqui ele acumula.
    public void setSaldo(double valor) {
        this.saldo += valor;
    }

    // toString: Formata como o objeto aparece quando damos System.out.println(c)
    @Override
    public String toString() {
        // %-10s: String alinhada à esquerda com 10 espaços
        // %.2f: Número com 2 casas decimais
        return String.format("%-10s %-20s %-15.2f", numConta, titular, saldo);
    }

    public void listar(int tipoConta){
        if(tipoConta == 0) {
            System.out.println("LISTANDO CORRENTISTAS (CONTA CORRENTE):");
            // Cabeçalho da tabela
            System.out.printf("%-10s %-20s %-15s %-8s", "Conta", "Titular", "Saldo", "Limite para Emprestimo\n");

            for (Conta c : lista)
                // instanceof: Verifica se este item genérico da lista é uma Conta Corrente
                if(c instanceof ContaCorrente)
                    System.out.println(c); // Chama o toString()
        } else {
            System.out.println("LISTANDO CORRENTISTAS (CONTA POUPANÇA):");
            System.out.printf("%-10s %-20s %-15s %-8s", "Conta","Titular","Saldo","% Ganho mês\n");

            for(Conta c: lista)
                if(c instanceof ContaPoupanca) // O professor não pôs o if aqui no original, mas a lógica implica filtrar
                    System.out.println(c);
        }
    }

    // Retorna a conta encontrada ou null
    public Conta pesquisar(String numeroContaBusca, int tipoConta){
        ContaCorrente cc;
        ContaPoupanca cp;

        for(Conta c: lista){
            if(tipoConta == 0){
                // Verifica se é Corrente E se o número bate
                if(c instanceof ContaCorrente){
                    cc = (ContaCorrente) c; // Casting (Converte Conta -> ContaCorrente)
                    if(c.numConta.equals(numeroContaBusca))
                        return c;
                }
            } else {
                // Verifica se é Poupança E se o número bate
                if(c instanceof ContaPoupanca){
                    cp = (ContaPoupanca) c; // Casting
                    if(c.numConta.equals(numeroContaBusca))
                        return c;
                }
            }
        }

        System.out.println("CONTA INVÁLIDA");
        return null;
    }
}