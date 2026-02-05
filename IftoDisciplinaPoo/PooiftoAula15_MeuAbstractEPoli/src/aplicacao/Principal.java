package aplicacao;

import entidade.Colaborador;
import entidade.FuncionarioPF;
import entidade.FuncionarioPJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    // Atributo estático com o nome do arquivo [cite: 154]
    public static String obj = "IftoDisciplinaPoo/PooiftoAula15_MeuAbstractEPoli/Func.txt";

    // MAPA ESTÁTICO: Substitui a List.
    // <Chave, Valor> -> <Nome(String), Objeto(Colaborador)>
    private static Map<String, Colaborador> mapaColaboradores = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Flag para garantir que só carregamos o arquivo uma vez
        boolean dadosCarregados = false;

        while(true){
            System.out.println("\n--- SISTEMA DE RH (MAP & ABSTRACT) ---");
            System.out.println("1 - Gerar Base de Dados (Ler Arquivo)");
            System.out.println("2 - Listar Funcionários PF (Salários)");
            System.out.println("3 - Listar Funcionários PJ (Faturamento)");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();

            if(opcao == 4) break;

            // Tratamento das opções
            switch (opcao){
                case 1:
                    if(dadosCarregados){
                        System.out.println("Erro: A base de dados já foi carregada!");
                    } else {
                        lerArquivo();
                        dadosCarregados = true; // Trava para não carregar de novo
                    }
                    break;

                case 2:
                    listarPessoaFisica();
                    break;

                case 3:
                    listarPessoaJuridica();
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
        scanner.close(); // Boa prática: fechar o scanner
    }

    // Método de leitura separado conforme sugestão [cite: 171]
    public static void lerArquivo() throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(obj));
        String linha;

        System.out.println("Carregando arquivo...");

        while((linha = leitor.readLine()) != null){
            String[] dados = linha.split(";");

            // Lógica de distinção pelo tamanho do vetor (igual aula passada)
            // PF tem 4 campos (Nome, CPF, Salario, Adicional)
            if(dados.length == 4){
                String nome = dados[0];
                String cpf = dados[1];
                double salario = Double.parseDouble(dados[2]);
                double adicional = Double.parseDouble(dados[3]);

                // Cria o objeto PF
                FuncionarioPF pf = new FuncionarioPF(nome, cpf, salario, adicional);

                // MAP: Adiciona usando .put(CHAVE, VALOR)
                // Chave = Nome (dados[0]), Valor = Objeto PF
                mapaColaboradores.put(nome, pf);
            }
            // PJ tem 3 campos (Nome, CNPJ, ValorDia)
            else {
                String nome = dados[0];
                String cnpj = dados[1];
                double valorDia = Double.parseDouble(dados[2]);

                // Cria o objeto PJ
                FuncionarioPJ pj = new FuncionarioPJ(nome, cnpj, valorDia);

                // MAP: Adiciona usando .put
                mapaColaboradores.put(nome, pj);
            }
        }
        leitor.close();
        System.out.println("Sucesso! Total importado: " + mapaColaboradores.size());
    }

    public static void listarPessoaFisica(){
        System.out.println("\n--- RELATÓRIO: PESSOA FÍSICA ---");
        double totalSalarios = 0;

        // Percorrer um MAP é diferente de percorrer LISTA.
        // mapa.values() retorna uma coleção apenas com os objetos (valores).
        for(Colaborador colab : mapaColaboradores.values()){

            // Verifica se é PF
            if(colab instanceof FuncionarioPF){

                // Casting (Conversão) não é estritamente necessário para calcularPgto
                // pois ele existe na classe pai, mas é bom para garantir o tipo.

                // Regra do PDF: Passar valor fixo para horas noturnas [cite: 185]
                // Vamos simular que todos fizeram 10 horas extras noturnas.
                double salarioLiquido = colab.calcularPgto(10);

                System.out.println(colab.toString()); // Chama o toString do PF
                System.out.printf("   -> Salário Líquido (Base + 10h extras - INSS): R$ %.2f\n", salarioLiquido);

                totalSalarios += salarioLiquido;
            }
        }
        System.out.printf("\n>>> TOTAL PAGO EM SALÁRIOS (PF): R$ %.2f\n", totalSalarios);
    }

    public static void listarPessoaJuridica(){
        System.out.println("\n--- RELATÓRIO: PESSOA JURÍDICA ---");
        double totalPagamentos = 0;

        // Loop nos valores do Mapa
        for(Colaborador colab : mapaColaboradores.values()){

            if(colab instanceof FuncionarioPJ){

                // Regra do PDF: Passar valor fixo para dias trabalhados [cite: 193]
                // Vamos simular que as empresas trabalharam 20 dias no mês.
                double pagamentoLiquido = colab.calcularPgto(20);

                System.out.println(colab.toString()); // Chama o toString do PJ
                System.out.printf("   -> Recebimento Líquido (20 dias - IRPJ): R$ %.2f\n", pagamentoLiquido);

                totalPagamentos += pagamentoLiquido;
            }
        }
        System.out.printf("\n>>> TOTAL PAGO A EMPRESAS (PJ): R$ %.2f\n", totalPagamentos);
    }
}