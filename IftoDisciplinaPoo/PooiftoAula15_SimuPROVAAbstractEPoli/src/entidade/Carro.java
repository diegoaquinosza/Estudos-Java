package entidade;

public class Carro extends Veiculo {
    private double valorDiaria;
    private double potencia; // Campo extra que só Carro tem no arquivo

    public Carro() {
    }

    public Carro(String modelo, String placa, double valorDiaria, double potencia) {
        super(modelo, placa);
        this.valorDiaria = valorDiaria;
        this.potencia = potencia;
    }

    @Override
    public double calcularAluguel(int dias) {
        // Regra: (Dias * Diária) + Seguro Privado
        double totalBruto = dias * valorDiaria;
        return totalBruto + calcularSeguro(totalBruto);
    }

    // Método Privado (Encapsulamento estilo Aula 15)
    private double calcularSeguro(double valorTotal){
        return valorTotal * 0.05; // 5% de seguro
    }

    // ToString limpo (estilo nossa última versão), devolvendo só dados fixos.
    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10s", super.getModelo(), super.getPlaca(), "CARRO");
    }
}