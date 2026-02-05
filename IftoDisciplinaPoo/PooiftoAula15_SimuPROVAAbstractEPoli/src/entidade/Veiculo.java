package entidade;

public abstract class Veiculo {
    private String modelo;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    // Método Abstrato: Obriga Carro e Moto a dizerem como calculam o aluguel.
    // 'dias' é o valor que o usuário vai digitar no Principal.
    public abstract double calcularAluguel(int dias);

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }
}