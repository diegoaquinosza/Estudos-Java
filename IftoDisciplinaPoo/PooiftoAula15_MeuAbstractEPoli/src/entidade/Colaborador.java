package entidade;

// CLASSE ABSTRATA: Serve de modelo. Não pode dar "new Colaborador()".
// Define o contrato que PF e PJ devem seguir.
public abstract class Colaborador {

    // Atributo protegido ou privado (Diagrama diz privado -)
    // Armazena o nome da pessoa ou da empresa.
    private String nome;

    // Construtor para obrigar a passar o nome ao criar qualquer filho.
    public Colaborador(String nome) {
        this.nome = nome;
    }

    // MÉTODO ABSTRATO: Não tem corpo {}.
    // Obriga as classes filhas (PF e PJ) a implementarem sua própria lógica de pagamento.
    // Recebe um parâmetro genérico (pode ser horas ou dias) e retorna o valor líquido.
    public abstract double calcularPgto(double qtdTrabalhada);

    // Getter para acessar o nome (necessário pois o atributo é private)
    public String getNome() {
        return nome;
    }
}