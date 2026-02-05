package entidade;

// CLASSE ABSTRATA: Serve de modelo. Não pode ser instanciada (new Colaborador() é proibido).
// Ela define o "contrato" que as filhas (PF e PJ) devem obedecer.
public abstract class Colaborador {

    // Atributo privado encapsulado. Todas as filhas terão, mas só acessam via getNome().
    private String nome;

    // Construtor vazio (obrigatório para boas práticas)
    public Colaborador() {
    }

    // Construtor que força a passagem do nome na criação
    public Colaborador(String nome) {
        this.nome = nome;
    }

    // MÉTODO ABSTRATO: Não tem corpo {}.
    // A classe mãe diz: "Todo colaborador tem que calcular pagamento",
    // mas não sabe como. As filhas (PF e PJ) são OBRIGADAS a escrever esse código.
    // 'valorRef' será genérico: horas para PF e dias para PJ.
    public abstract double calcularPgto(double valorRef);

    // Getter para acessar o nome (necessário pois o atributo é private)
    public String getNome() {
        return nome;
    }
}