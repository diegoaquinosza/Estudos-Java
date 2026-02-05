package entidade;

public class Carro extends Veiculo {

    // Atributos exclusivos e privados
    private double valorDiaria;
    private double potencia;

    public Carro() {
    }

    public Carro(String modelo, String placa, double valorDiaria, double potencia) {
        super(modelo, placa); // Repassa dados comuns para a classe pai
        this.valorDiaria = valorDiaria;
        this.potencia = potencia;
    }

    // SOBRESCRITA (Override): Implementação pública obrigatória
    @Override
    public double calcularAluguel(int dias) {
        // 1. Calcula o bruto
        double totalBruto = dias * valorDiaria;

        // 2. Chama o método PRIVADO para somar o seguro
        // Note que quem chama calcularAluguel não sabe que calcularSeguro existe.
        return totalBruto + calcularSeguro(totalBruto);
    }

    // MÉTODO PRIVADO (ENCAPSULAMENTO PURO):
    // Regra: 5% do valor total é cobrado como seguro obrigatório.
    // Ninguém de fora da classe Carro consegue chamar esse método.
    private double calcularSeguro(double valorTotal){
        return valorTotal * 0.05;
    }

    // ToString retornando apenas dados cadastrais (Segurança: não expõe valores fixos)
    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10s", super.getModelo(), super.getPlaca(), "CARRO");
    }
}