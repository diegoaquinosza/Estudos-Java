package entidade;

public class Retangulo {
    // Sem herança, precisamos declarar nome e cor aqui (repetição de código)
    private String nome;
    private String cor;
    private double largura;
    private double altura;

    public Retangulo() {
    }

    public Retangulo(String nome, String cor, double largura, double altura) {
        this.nome = nome;
        this.cor = cor;
        this.largura = largura;
        this.altura = altura;
    }

    public double area(){
        return largura * altura;
    }

    public double diagonal(){
        return Math.sqrt(largura * largura + altura * altura);
    }

    @Override
    public String toString() {
        return "Nome: "+nome + "  Cor: "+cor + " Altura: "+altura + " Largura: "+ largura;
    }
}