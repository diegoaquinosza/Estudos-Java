package entidades;

// EXTENDS: Herda de Conta
public class ContaPoupanca extends Conta {

    // Atributo exclusivo
    private double taxaRend;

    // --- Construtores ---
    public ContaPoupanca() {}

    public ContaPoupanca(String numConta, String titular, double saldo, double taxaRend) {
        // Delega para a superclasse
        super(numConta, titular, saldo);
        this.taxaRend = taxaRend;
    }

    // --- Métodos Específicos ---
    public void ganhoMes(int mes) {
        // Calcula quanto o dinheiro vai render baseado na taxa e tempo
        double rendimento = getSaldo() * this.taxaRend * mes;
        System.out.println("Rendimento projetado em " + mes + " meses: R$ " + rendimento);
        System.out.println("Saldo Total: " + (getSaldo() + rendimento));
    }

    // Getter e Setter exclusivo
    public double getTaxaRend() { return taxaRend; }
    public void setTaxaRend(double taxaRend) { this.taxaRend = taxaRend; }
}