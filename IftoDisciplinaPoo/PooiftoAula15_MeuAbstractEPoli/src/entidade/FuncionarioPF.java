package entidade;

// Herda de Colaborador (é obrigado a ter nome e o método calcularPgto)
public class FuncionarioPF extends Colaborador {

    // Atributos exclusivos do diagrama [cite: 163]
    private String cpf;           // Cadastro de Pessoa Física
    private double salarioBase;   // O salário fixo mensal
    private double adicionalNoturno; // Valor pago por hora extra noturna

    // Construtor: Recebe dados e repassa o nome para a classe Pai (super)
    public FuncionarioPF(String nome, String cpf, double salarioBase, double adicionalNoturno) {
        super(nome); // Manda o nome para Colaborador
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.adicionalNoturno = adicionalNoturno;
    }

    // MÉTODO PRIVADO: Só esta classe pode ver. [cite: 189]
    // Regra: Salário Bruto * 0.11 (11%)
    private double calcularINSS(double salarioBruto){
        return salarioBruto * 0.11;
    }

    // IMPLEMENTAÇÃO OBRIGATÓRIA (Override)
    // O parâmetro "qtdTrabalhada" aqui representa as "Horas Noturnas" trabalhadas.
    @Override
    public double calcularPgto(double horasNoturnas) {
        // 1. Calcula quanto ganhou de extra: horas * valor da hora noturna
        double valorExtras = horasNoturnas * adicionalNoturno;

        // 2. Soma ao salário base
        double salarioBruto = salarioBase + valorExtras;

        // 3. Calcula o desconto chamando o método privado interno
        double descontoINSS = calcularINSS(salarioBruto);

        // 4. Retorna o Líquido (Bruto - Desconto) [cite: 187]
        return salarioBruto - descontoINSS;
    }

    // ToString para facilitar a impressão no relatório
    @Override
    public String toString() {
        return "Nome: " + super.getNome() + " | CPF: " + cpf;
    }
}