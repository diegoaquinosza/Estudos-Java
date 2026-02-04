package entidade;

public class Circulo extends Forma {
    private double raio;

    public Circulo() {
    }

    public Circulo(String nome, String cor, double raio) {
        super(nome, cor);
        this.raio = raio;
    }

    @Override
    public double area(){
        return Math.PI * raio * raio;
    }

    // Método exclusivo
    public double diametro(){
        return 2 * raio;
    }

    @Override
    public String toString() {
        return "Nome: "+super.getNome()+ "  Cor: "+super.getCor() + " Raio: "+raio;
    }
}