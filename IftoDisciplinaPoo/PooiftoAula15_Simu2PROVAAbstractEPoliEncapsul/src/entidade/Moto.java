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
        double totalBruto = dias * valorDiaria;

        // Chama método PRIVADO para aplicar desconto
        return totalBruto - calcularDescontoCapacete(totalBruto);
    }

    // MÉTODO PRIVADO (ENCAPSULAMENTO):
    // Regra: Motos têm 10% de desconto promocional (simulação).
    private double calcularDescontoCapacete(double valorTotal){
        return valorTotal * 0.10;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10s", super.getModelo(), super.getPlaca(), "MOTO");
    }
}