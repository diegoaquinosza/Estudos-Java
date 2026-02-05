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

    // Caminho do arquivo definido como estático (Static = pertence à classe)
    public static String caminhoArquivo = "IftoDisciplinaPoo/PooiftoAula15_ProfAbstractEPoli/Func.txt";

    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);

        // MAPA: A estrutura de dados pedida na Aula 15[cite: 169].
        // Chave (String) = Nome do funcionário.
        // Valor (Colaborador) = Objeto completo (PF ou PJ).
        Map<String, Colaborador> mapaColaboradores = new HashMap<>();

        String menu = "\n1 - Gerar base de dados\n"+
                "2 - Listar Colaborador - Pessoa Física (Informe Horas)\n"+
                "3 - Listar Colaborador - Pessoa Jurídica (Informe Dias)\n"+
                "4 - Sair\n"+
                "Opção: ";

        while(true){
            System.out.print(menu);
            int opcao = scanner.nextInt();

            if(opcao == 4) break; // Sai do loop

            switch (opcao){
                case 1:
                    // Evita recarregar o arquivo se o mapa já tiver dados
                    if(!mapaColaboradores.isEmpty()){
                        System.out.println("AVISO: O mapa já está preenchido.");
                    }else{
                        gerarMapa(mapaColaboradores);
                    }
                    break;

                case 2: // --- RELATÓRIO PESSOA FÍSICA ---
                    // Validação de segurança
                    if(mapaColaboradores.isEmpty()){
                        System.out.println("Erro: Base vazia. Execute a opção 1 primeiro.");
                        break;
                    }

                    // INTERAÇÃO COM USUÁRIO (A novidade!):
                    // Perguntamos as horas para calcular na hora, em vez de usar valor fixo.
                    System.out.print("Digite a quantidade de HORAS NOTURNAS trabalhadas: ");
                    double horasInformadas = scanner.nextDouble();

                    System.out.println(String.format("%-30s %-20s %10s","NOME","CPF", "LÍQUIDO"));

                    // Loop pelo Mapa (EntrySet traz o par Chave+Valor)
                    for(Map.Entry<String,Colaborador> entrada : mapaColaboradores.entrySet()){
                        Colaborador colab = entrada.getValue(); // Pega o objeto

                        // Verifica se é PF antes de imprimir
                        if(colab instanceof FuncionarioPF){
                            // 1. Calcula o salário usando as horas digitadas pelo usuário
                            double salarioLiquido = colab.calcularPgto(horasInformadas);

                            // 2. Chama o toString() (que só tem nome/CPF) e cola o valor calculado no final
                            System.out.println(colab.toString() + String.format(" %10.2f", salarioLiquido));
                        }
                    }
                    System.out.println("********************************************");
                    break;

                case 3: // --- RELATÓRIO PESSOA JURÍDICA ---
                    if(mapaColaboradores.isEmpty()){
                        System.out.println("Erro: Base vazia. Execute a opção 1 primeiro.");
                        break;
                    }

                    // INTERAÇÃO COM USUÁRIO:
                    System.out.print("Digite a quantidade de DIAS trabalhados: ");
                    double diasInformados = scanner.nextDouble();

                    System.out.println(String.format("%-30s %-20s %10s","NOME","CNPJ", "LÍQUIDO"));

                    for(Map.Entry<String,Colaborador> entrada : mapaColaboradores.entrySet()){
                        Colaborador colab = entrada.getValue();

                        // Verifica se é PJ
                        if(colab instanceof FuncionarioPJ){
                            // 1. Calcula o faturamento usando os dias digitados
                            double pagamentoLiquido = colab.calcularPgto(diasInformados);

                            // 2. Imprime Nome/CNPJ + Valor calculado
                            System.out.println(colab.toString() + String.format(" %10.2f", pagamentoLiquido));
                        }
                    }
                    System.out.println("********************************************");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }
        }
    }

    // Método estático para ler o arquivo (Refatorado do código do professor)
    public static void gerarMapa(Map<String,Colaborador> mapa) throws IOException {
        BufferedReader leitorBuffer = new BufferedReader(new FileReader(caminhoArquivo));
        String linha;

        while((linha = leitorBuffer.readLine()) != null){
            String[] dadosLinha = linha.split(";");

            // LÓGICA DE IDENTIFICAÇÃO (Do Professor):
            // Verifica o tamanho da String do documento (Coluna 1).
            // CPF formatado (ex: 111.222.333-44) tem 14 caracteres.
            if(dadosLinha[1].length() == 14){

                // É Pessoa Física
                double salBase = Double.parseDouble(dadosLinha[2]);
                double adNot = Double.parseDouble(dadosLinha[3]);

                // Cria PF e guarda no Mapa (Chave=Nome)
                mapa.put(dadosLinha[0], new FuncionarioPF(dadosLinha[0], dadosLinha[1], salBase, adNot));
            }else{

                // Se não é 14, é CNPJ (18 caracteres) -> Pessoa Jurídica
                double valorDia = Double.parseDouble(dadosLinha[2]);

                // Cria PJ e guarda no Mapa
                mapa.put(dadosLinha[0], new FuncionarioPJ(dadosLinha[0], dadosLinha[1], valorDia));
            }
        }
        System.out.println("BASE DE DADOS CARREGADA COM SUCESSO!");
        leitorBuffer.close(); // Sempre fechar o arquivo!
    }
}