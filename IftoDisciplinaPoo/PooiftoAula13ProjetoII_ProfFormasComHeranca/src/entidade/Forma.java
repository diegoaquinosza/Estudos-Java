package entidade;

public abstract class Forma {
    private String nome;
    private String cor;

    public Forma() {
    }

    public Forma(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    // Método abstrato: Obriga as filhas a terem uma área.
    public abstract double area();

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }
}