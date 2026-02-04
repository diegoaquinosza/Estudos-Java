package entidade;

// Herda de Forma
public class Circulo extends Forma {

    // Atributo exclusivo
    private double raio;

    public Circulo(String nome, String cor, double raio) {
        super(nome, cor);
        this.raio = raio;
    }

    // Implementação obrigatória
    @Override
    public double area() {
        return Math.PI * (raio * raio);
    }

    // Método Exclusivo (precisará de Casting para usar)
    public double diametro() {
        return 2 * raio;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| Tipo: Circulo   | Área: %.2f", area());
    }
}