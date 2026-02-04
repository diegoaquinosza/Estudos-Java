package entidades;

// EXTENDS: Herda atributos e métodos (saque, deposito) da classe Conta.
public class ContaCorrente extends Conta {

    private double limiteEmp;

    // Construtor
    public ContaCorrente(String numConta, String titular, double saldo, double limiteEmp) {
        // SUPER: Chama o construtor da mãe (Conta) para configurar nome, numero e saldo.
        // O limite é configurado aqui na filha.
        super(numConta, titular, saldo);
        this.limiteEmp = limiteEmp;
    }

    // Método Exclusivo (Só existe na ContaCorrente)
    public void emprestimo(double valor){
        // Usa super.getSaldo() pois o atributo saldo é private na mãe
        System.out.printf("SALDO ATUAL: R$ %.2f\n", super.getSaldo());
        System.out.printf("LIMITE PARA EMPRÉSTIMO: R$ %.2f\n", limiteEmp);

        if(valor > limiteEmp){
            System.out.println("EMPRESTIMO RECUSADO: Acima do limite.");
        } else {
            // Usa super.setSaldo: Como na lógica do professor o set soma (+=),
            // isso funciona como depositar o dinheiro do empréstimo.
            super.setSaldo(valor);
            System.out.printf("SALDO APÓS O EMPRÉSTIMO: R$ %.2f\n", super.getSaldo());
        }
    }

    @Override
    public String toString() {
        // Aproveita a formatação da mãe e adiciona o limite no final
        return super.toString() + String.format("%-8.2f", limiteEmp);
    }
}