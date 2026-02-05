package entidade;

public class FuncionarioPJ extends Colaborador{
    private String cnpj;
    private double valorDia; // Quanto a empresa cobra por dia

    public FuncionarioPJ() {
    }

    public FuncionarioPJ(String nome, String cnpj, double valorDia) {
        super(nome); // Envia o nome para a classe Pai
        this.cnpj = cnpj;
        this.valorDia = valorDia;
    }

    // SOBRESCRITA (Override): Implementação obrigatória.
    // Aqui, o parâmetro 'diasTrabalhados' representa a quantidade de dias.
    @Override
    public double calcularPgto(double diasTrabalhados) {
        // Regra de Negócio:
        // 1. Faturamento Bruto = Dias * Valor da Diária
        // 2. Desconta o IRPJ sobre o total
        double faturamento = diasTrabalhados * valorDia;
        return faturamento - calcularIRPJ(faturamento);
    }

    // Método auxiliar PRIVADO (Encapsulamento)
    public double calcularIRPJ(double faturamento){
        return faturamento * 0.17; // 17% de imposto
    }

    // MUDANÇA ESTRATÉGICA:
    // Retorna apenas dados cadastrais (Nome e CNPJ).
    // Deixa o cálculo financeiro para o momento da impressão no Principal.
    @Override
    public String toString() {
        return String.format("%-30s %-20s", super.getNome(), cnpj);
    }
}