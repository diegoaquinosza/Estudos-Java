package entidade;

// EXTENDS: Herança. ContaCorrente herda tudo (atributos e métodos) de Conta.
public class ContaCorrente extends Conta {

    // Atributo exclusivo desta classe (que a mãe não tem)
    private double limiteEmp;

    // --- Construtores ---
    public ContaCorrente(){}

    public ContaCorrente(String numConta, String titular, double saldo, double limiteEmp) {
        // SUPER: Chama o construtor da classe Mãe (Conta) para inicializar a parte dela.
        // É como dizer: "Mãe, cuida do número, nome e saldo que eu cuido do limite".
        super(numConta, titular, saldo);
        this.limiteEmp = limiteEmp;
    }

    // --- Métodos Específicos ---
    public void emprestimo(double valorEmp) {
        if (valorEmp <= this.limiteEmp) {
            // getSaldo(): Como saldo é private na mãe, usamos o GET para ler.
            // setSaldo(): Usamos o SET para alterar.
            double novoSaldo = getSaldo() + valorEmp;
            setSaldo(novoSaldo);
            System.out.println("Empréstimo concedido!");
        } else {
            System.out.println("Valor acima do limite permitido.");
        }
    }

    // Getter e Setter exclusivo
    public double getLimiteEmp() { return limiteEmp; }
    public void setLimiteEmp(double limiteEmp) { this.limiteEmp = limiteEmp; }
}