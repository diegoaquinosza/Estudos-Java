package entidades;

public class ContaPoupanca extends entidades.Conta {

    private double taxaRend;

    public ContaPoupanca() {
    }

    public ContaPoupanca(String numConta, String titular, double saldo, double taxaRend) {
        super(numConta, titular, saldo);
        this.taxaRend = taxaRend;
    }

    public void ganhoMes(int meses){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", super.getSaldo());

        double saldoProjetado = super.getSaldo();

        // Loop para calcular Juros Compostos mês a mês
        for(int i=1; i <= meses; i++){
            // Novo Saldo = Saldo Atual + (Saldo Atual * Taxa)
            saldoProjetado = saldoProjetado * taxaRend + saldoProjetado;
        }

        System.out.printf("SALDO APÓS %d MESES: R$ %.2f\n", meses, saldoProjetado);
        System.out.printf("RENDIMENTO DE: %.2f\n", (saldoProjetado - super.getSaldo()));
    }

    @Override
    public String toString() {
        // Reaproveita toString da mãe e adiciona a taxa no final
        return super.toString() + String.format("%-8.2f", taxaRend);
    }
}