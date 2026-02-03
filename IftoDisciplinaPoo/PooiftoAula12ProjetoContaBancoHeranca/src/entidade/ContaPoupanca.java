package entidade;

public class ContaPoupanca extends Conta {
    private double taxaRend;

    //Construtor----------------
    public ContaPoupanca() {}

    public ContaPoupanca(String numConta, String titular, double saldo, double taxaRend) {
        super(numConta, titular, saldo);
        this.taxaRend = taxaRend;
    }

    //Métodos-------------------
    public void ganhoMes(int mes){}

    //Getters e Setters---------
    public double getTaxaRend() {
        return taxaRend;
    }

    public void setTaxaRend(double taxaRend) {
        this.taxaRend = taxaRend;
    }
}
