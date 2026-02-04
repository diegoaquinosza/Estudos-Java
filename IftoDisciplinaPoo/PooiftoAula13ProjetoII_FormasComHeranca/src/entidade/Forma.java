package entidade;

import java.util.ArrayList;
import java.util.List;

// CLASSE ABSTRATA: Serve de modelo. Não pode ser instanciada (new Forma() é proibido).
// Ela define o "contrato" que as filhas (Retangulo/Circulo) devem obedecer.
public abstract class Forma {

    // Atributos comuns a todas as formas (evita repetição nas filhas)
    private String nome;
    private String cor;

    // REGRA DO PDF: "A lista de objetos deverá ficar como atributo da super classe"
    // STATIC: A lista pertence à CLASSE, funcionando como um banco de dados compartilhado.
    // PROTECTED: Permite acesso direto pelas classes filhas se necessário, mas usaremos métodos publicos.
    private static List<Forma> lista = new ArrayList<>();

    // Construtor
    public Forma(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    // --- MÉTODOS DE GERENCIAMENTO DA LISTA (STATIC) ---
    // Adiciona qualquer objeto que seja filho de Forma (Polimorfismo)
    public static void adicionar(Forma f) {
        lista.add(f);
    }

    // Retorna a lista completa para o Main
    public static List<Forma> getLista() {
        return lista;
    }

    public static void limparLista() {
        lista.clear();
    }

    // --- MÉTODO ABSTRATO ---
    // Definimos que toda Forma TEM QUE TER uma área, mas cada uma calcula do seu jeito.
    // Isso obriga as filhas (Retangulo e Circulo) a implementarem a lógica delas.
    // Isso permite chamarmos "f.area()" na lista genérica sem saber quem é quem.
    public abstract double area();

    // Getters e toString Comuns
    public String getNome() { return nome; }
    public String getCor() { return cor; }

    @Override
    public String toString() {
        return String.format("Nome: %-15s | Cor: %-10s", nome, cor);
    }
}