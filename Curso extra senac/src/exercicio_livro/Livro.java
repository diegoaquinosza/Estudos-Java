package exercicio_livro;

public class Livro {

    public String titulo;
    public String autor;
    public int ano;
    public boolean emprestado = false;

    //Construtores
    public Livro() {
    }

    public Livro(String titulo, String autor, int ano, boolean emprestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
    }

    //Métodos
    public void emprestar() {
        if (this.emprestado == false) {
            this.emprestado = true;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro já está emprestado!");
        }
    }

    public void devolver() {
        if (this.emprestado == true) {
            this.emprestado = false;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Livro está na estante (já foi devolvido)");
        }
    }

    public void mostarInfo() {
        System.out.println("\n---- Mostar Info Livro ----");
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano: " + this.ano);
        System.out.println("Emprestado: " + this.emprestado);
    }
}
