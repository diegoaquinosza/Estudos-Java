package entidades;

public class ContaPoupanca extends Conta {

    private double taxaRend;

    public ContaPoupanca() {}

    public ContaPoupanca(String numConta, String titular, double saldo, double taxaRend) {
        super(numConta, titular, saldo);
        this.taxaRend = taxaRend;
    }

    // Método Exclusivo (Só existe na ContaPoupanca)
    public void ganhoMes(int meses){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", super.getSaldo());

        double saldoProjetado = super.getSaldo();

        // Loop de Juros Compostos: O rendimento do mês 1 rende juros no mês 2
        for(int i=1; i <= meses; i++){
            // Novo Saldo = Anterior + (Anterior * Taxa)
            saldoProjetado = saldoProjetado * taxaRend + saldoProjetado;
        }

        System.out.printf("SALDO APÓS %d MESES: R$ %.2f\n", meses, saldoProjetado);
        System.out.printf("RENDIMENTO TOTAL: R$ %.2f\n", (saldoProjetado - super.getSaldo()));
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-8.2f", taxaRend);
    }
}