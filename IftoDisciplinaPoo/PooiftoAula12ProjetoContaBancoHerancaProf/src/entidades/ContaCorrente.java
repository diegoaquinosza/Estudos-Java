package entidades;

public class ContaCorrente extends entidades.Conta {

    private double limiteEmp;

    // Construtor
    public ContaCorrente(String numConta, String titular, double saldo, double limiteEmp) {
        // super: Chama o construtor da classe Conta para guardar nome, numero e saldo
        super(numConta, titular, saldo);
        this.limiteEmp = limiteEmp;
    }

    public void emprestimo(double valor){
        System.out.printf("SALDO ATUAL: R$ %.2f\n", super.getSaldo());
        System.out.printf("LIMITE PARA EMPRÉSTIMO: R$ %.2f\n", limiteEmp);

        if(valor > limiteEmp){
            System.out.println("EMPRESTIMO RECUSADO.");
        } else {
            // Nota: O setSaldo do professor soma (+=), então isso funciona como depósito
            super.setSaldo(valor);
            System.out.printf("SALDO APÓS O EMPRÉSTIMO: R$ %.2f\n", super.getSaldo());
        }
    }

    @Override
    public String toString() {
        // Reaproveita o toString da mãe (Conta) e adiciona o limite no final
        return super.toString() + String.format("%-8.2f", limiteEmp);
    }
}