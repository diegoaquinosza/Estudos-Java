package entidade;

import java.util.ArrayList;
import java.util.List;

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
    public void criarCadastro(){}

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



