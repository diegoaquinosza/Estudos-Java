package entidade;

// ABSTRACT: Garante que não teremos um "Veículo" genérico, apenas Carros ou Motos.
public abstract class Veiculo {

    // ENCAPSULAMENTO: Atributos privados. Só a própria classe vê.
    // As filhas acessam via getters ou construtor (super).
    private String modelo;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    // MÉTODO ABSTRATO: O "Contrato".
    // Obriga as filhas a terem esse método público.
    // O 'Principal' vai chamar este método sem saber a regra interna de cada um.
    public abstract double calcularAluguel(int dias);

    // Getters públicos para permitir leitura controlada dos dados
    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }
}