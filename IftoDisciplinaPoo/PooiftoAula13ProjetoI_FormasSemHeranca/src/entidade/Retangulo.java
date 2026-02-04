package entidade;

public class Retangulo {
    private String nome;
    private String cor;
    private double largura;
    private double altura;

    // Construtor
    public Retangulo(String nome, String cor, double largura, double altura) {
        this.nome = nome;
        this.cor = cor;
        this.largura = largura;
        this.altura = altura;
    }

    // Regra: altura * largura
    public double area() {
        return largura * altura;
    }

    // Regra: Raiz Quadrada de (largura² + altura²)
    public double diagonal() {
        // Math.sqrt = Raiz Quadrada
        // Math.pow(base, 2) = Eleva ao quadrado
        return Math.sqrt(Math.pow(largura, 2) + Math.pow(altura, 2));
    }

    // Getters
    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public double getLargura() { return largura; }
    public double getAltura() { return altura; }

    @Override
    public String toString() {
        return String.format("RETANGULO [Nome: %s | Cor: %s | L: %.2f | A: %.2f]",
                nome, cor, largura, altura);
    }
}