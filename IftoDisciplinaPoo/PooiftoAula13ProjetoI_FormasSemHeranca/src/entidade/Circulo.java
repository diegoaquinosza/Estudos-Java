package entidade;

public class Circulo {
    private String nome;
    private String cor;
    private double raio;

    // Construtor
    public Circulo(String nome, String cor, double raio) {
        this.nome = nome;
        this.cor = cor;
        this.raio = raio;
    }

    // Regra: PI * raio * raio
    public double area() {
        return Math.PI * (raio * raio);
    }

    // Regra: 2 * raio
    public double diametro() {
        return 2 * raio;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public double getRaio() { return raio; }

    @Override
    public String toString() {
        return String.format("CIRCULO [Nome: %s | Cor: %s | Raio: %.2f]",
                nome, cor, raio);
    }
}