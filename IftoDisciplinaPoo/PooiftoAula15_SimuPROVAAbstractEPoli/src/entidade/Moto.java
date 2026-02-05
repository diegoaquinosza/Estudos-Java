package entidade;

public class Moto extends Veiculo {
    private double valorDiaria;

    public Moto() {
    }

    public Moto(String modelo, String placa, double valorDiaria) {
        super(modelo, placa);
        this.valorDiaria = valorDiaria;
    }

    @Override
    public double calcularAluguel(int dias) {
        // Regra: (Dias * Diária) - Desconto de Fidelidade
        double totalBruto = dias * valorDiaria;
        return totalBruto - calcularDescontoFidelidade(totalBruto);
    }

    // Método Privado (Encapsulamento)
    private double calcularDescontoFidelidade(double valorTotal){
        return valorTotal * 0.10; // 10% de desconto
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10s", super.getModelo(), super.getPlaca(), "MOTO");
    }
}