package entidade;

public class Circulo {
    // Repetição dos atributos nome e cor
    private String nome;
    private String cor;
    private double raio;

    public Circulo() {
    }

    public Circulo(String nome, String cor, double raio) {
        this.nome = nome;
        this.cor = cor;
        this.raio = raio;
    }

    public double area(){
        return Math.PI * raio * raio;
    }

    public double diametro(){
        return 2 * raio;
    }

    @Override
    public String toString() {
        return "Nome: "+nome + "  Cor: "+cor + " Raio: "+raio;
    }
}