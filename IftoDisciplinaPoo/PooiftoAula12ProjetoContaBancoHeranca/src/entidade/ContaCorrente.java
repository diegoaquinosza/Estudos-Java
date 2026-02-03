package entidade;

public class ContaCorrente extends Conta {
    private double limiteEmp;

    //Construtor----------------
    public ContaCorrente(){}

    public ContaCorrente(String numConta, String titular, double saldo, double limiteEmp) {
        super(numConta, titular, saldo);
        this.limiteEmp = limiteEmp;
    }

    //Métodos-------------------
    public void emprestimo(double valorEmp){}

    //Getters e setters---------
    public double getLimiteEmp() {
        return limiteEmp;
    }

    public void setLimiteEmp(double limiteEmp) {
        this.limiteEmp = limiteEmp;
    }
}
