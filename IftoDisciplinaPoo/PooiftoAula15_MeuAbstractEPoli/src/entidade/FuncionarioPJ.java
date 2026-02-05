package entidade;

// Herda de Colaborador
public class FuncionarioPJ extends Colaborador {

    // Atributos exclusivos do diagrama [cite: 162]
    private String cnpj;      // Cadastro Nacional de Pessoa Jurídica
    private double valorDia;  // Quanto a empresa cobra por dia de trabalho

    // Construtor
    public FuncionarioPJ(String nome, String cnpj, double valorDia) {
        super(nome); // Envia nome para o pai
        this.cnpj = cnpj;
        this.valorDia = valorDia;
    }

    // MÉTODO PRIVADO: Uso interno apenas [cite: 197]
    // Regra: Faturamento * 0.17 (17%)
    private double calcularIRPJ(double faturamento){
        return faturamento * 0.17;
    }

    // IMPLEMENTAÇÃO OBRIGATÓRIA (Override)
    // O parâmetro "qtdTrabalhada" aqui representa "Dias Trabalhados" no mês.
    @Override
    public double calcularPgto(double diasTrabalhados) {
        // 1. Calcula o faturamento bruto: dias trabalhados * valor da diária
        double faturamentoBruto = diasTrabalhados * valorDia;

        // 2. Calcula o imposto chamando o método privado
        double imposto = calcularIRPJ(faturamentoBruto);

        // 3. Retorna o Líquido (Faturamento - Imposto) [cite: 194]
        return faturamentoBruto - imposto;
    }

    @Override
    public String toString() {
        return "Empresa: " + super.getNome() + " | CNPJ: " + cnpj;
    }
}