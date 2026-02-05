package entidade;

public class FuncionarioPF extends Colaborador{
    private String cpf;
    private double salBase;   // Salário Fixo
    private double adNot;     // Adicional Noturno

    public FuncionarioPF() {
    }

    // Construtor Completo
    public FuncionarioPF(String nome, String cpf, double salBase, double adNot) {
        super(nome); // Envia o nome para a classe Pai (Colaborador)
        this.cpf = cpf;
        this.salBase = salBase;
        this.adNot = adNot;
    }

    // SOBRESCRITA (Override): Implementação obrigatória do método abstrato da mãe.
    // Aqui, o parâmetro 'horasTrabalhadas' representa as horas extras noturnas.
    @Override
    public double calcularPgto(double horasTrabalhadas) {
        // Regra de Negócio:
        // 1. Calcula ganho extra: Horas * Adicional Noturno
        // 2. Soma ao Salário Base
        // 3. Desconta o INSS (calculado apenas sobre o salário base nesta regra)
        return salBase + horasTrabalhadas * adNot - calcularINSS(salBase);
    }

    // Método auxiliar PRIVADO (Encapsulamento): Só a própria classe sabe calcular o imposto.
    public double calcularINSS(double valor){
        return valor * 0.11; // 11% de desconto
    }

    // MUDANÇA ESTRATÉGICA:
    // Removemos o cálculo de salário fixo daqui.
    // Agora o toString retorna APENAS os dados cadastrais (Nome e CPF).
    // O valor monetário será calculado e exibido pela classe Principal.
    @Override
    public String toString() {
        return String.format("%-30s %-20s", super.getNome(), cpf);
    }
}