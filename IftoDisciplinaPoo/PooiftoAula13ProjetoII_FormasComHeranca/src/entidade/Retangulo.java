package entidade;

// EXTENDS: Herda atributos (nome, cor) e a lista da classe Forma.
public class Retangulo extends Forma {

    // Atributos exclusivos do Retângulo
    private double largura;
    private double altura;

    public Retangulo(String nome, String cor, double largura, double altura) {
        // SUPER: Envia nome e cor para o construtor da classe Pai (Forma)
        super(nome, cor);
        this.largura = largura;
        this.altura = altura;
    }

    // OVERRIDE: Obrigatório implementar o cálculo da área definido na mãe abstrata.
    @Override
    public double area() {
        return largura * altura;
    }

    // Método Exclusivo: Só existe no Retângulo (precisará de Casting para usar)
    public double diagonal() {
        return Math.sqrt(Math.pow(largura, 2) + Math.pow(altura, 2));
    }

    @Override
    public String toString() {
        // Aproveita a formatação da mãe (super.toString) e adiciona os dados específicos
        // Como o método area() existe, já podemos mostrá-lo aqui direto.
        return super.toString() + String.format("| Tipo: Retangulo | Área: %.2f", area());
    }
}