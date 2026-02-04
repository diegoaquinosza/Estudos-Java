package entidade;

public class Retangulo extends Forma{

    private double largura;
    private double altura;

    public Retangulo() {
        // Construtor vazio
    }

    public Retangulo(String nome, String cor, double largura, double altura) {
        super(nome, cor); // Envia nome e cor para a classe Forma (Pai)
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double area(){
        return largura * altura;
    }

    // Método exclusivo (precisa de Casting para usar na lista genérica)
    public double diagonal(){
        return Math.sqrt(largura * largura + altura * altura);
    }

    @Override
    public String toString() {
        // Usa super.getNome() pois os atributos são private na mãe
        return "Nome: "+super.getNome() + "  Cor: "+super.getCor() + " Altura: "+altura + " Largura: "+ largura;
    }
}