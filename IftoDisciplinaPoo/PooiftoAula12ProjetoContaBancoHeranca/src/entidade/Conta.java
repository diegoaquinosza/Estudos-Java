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

    public void saque(double valor){}

    public void deposito(double valor){}

    public void listar(int tipo){}

    public Conta pesquisar(String numConta, int tipo){
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



