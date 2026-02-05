package aplicacao;

import entidade.Carro;
import entidade.Moto;
import entidade.Veiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    // Caminho do arquivo estático
    public static String arquivo = "IftoDisciplinaPoo/PooiftoAula15_SimuPROVAAbstractEPoli/Veiculos.txt";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // MAP: Chave = Placa (String), Valor = Veiculo (Abstract)
        Map<String, Veiculo> mapaVeiculos = new HashMap<>();

        String menu = "\n--- LOCADORA (SIMULADO PROVA) ---\n"+
                "1 - Carregar Veículos (Ler Arquivo)\n"+
                "2 - Simular Aluguel de Carros\n"+
                "3 - Simular Aluguel de Motos\n"+
                "4 - Sair\n"+
                "Opção: ";

        while(true){
            System.out.print(menu);
            int op = scanner.nextInt();

            if(op == 4) break;

            switch (op){
                case 1:
                    // Verifica se já carregou para não duplicar
                    if(!mapaVeiculos.isEmpty()){
                        System.out.println("ERRO: O mapa já foi carregado.");
                    } else {
                        carregarDados(mapaVeiculos);
                    }
                    break;

                case 2: // CARROS
                    if(mapaVeiculos.isEmpty()){
                        System.out.println("Carregue o arquivo primeiro!");
                        break;
                    }

                    // Interação com usuário (Estilo Aula 15 Final)
                    System.out.print("Quantos dias de aluguel? ");
                    int diasCarro = scanner.nextInt();

                    System.out.println(String.format("\n%-20s %-15s %-10s %10s", "MODELO", "PLACA", "TIPO", "TOTAL(R$)"));

                    // Loop no Map (Estilo Professor)
                    for(Map.Entry<String, Veiculo> entrada : mapaVeiculos.entrySet()){
                        Veiculo v = entrada.getValue();

                        // Verifica se é Carro
                        if(v instanceof Carro){
                            // Polimorfismo: O Java sabe usar o cálculo do Carro (com seguro)
                            double valorFinal = v.calcularAluguel(diasCarro);

                            // Imprime toString + Valor Calculado
                            System.out.println(v.toString() + String.format(" %10.2f", valorFinal));
                        }
                    }
                    System.out.println("-------------------------------------------------------");
                    break;

                case 3: // MOTOS
                    if(mapaVeiculos.isEmpty()){
                        System.out.println("Carregue o arquivo primeiro!");
                        break;
                    }

                    System.out.print("Quantos dias de aluguel? ");
                    int diasMoto = scanner.nextInt();

                    System.out.println(String.format("\n%-20s %-15s %-10s %10s", "MODELO", "PLACA", "TIPO", "TOTAL(R$)"));

                    for(Map.Entry<String, Veiculo> entrada : mapaVeiculos.entrySet()){
                        Veiculo v = entrada.getValue();

                        if(v instanceof Moto){
                            // Polimorfismo: O Java sabe usar o cálculo da Moto (com desconto)
                            double valorFinal = v.calcularAluguel(diasMoto);
                            System.out.println(v.toString() + String.format(" %10.2f", valorFinal));
                        }
                    }
                    System.out.println("-------------------------------------------------------");
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }

    // Método de Leitura (Estilo Professor Aula 13 + Aula 15)
    public static void carregarDados(Map<String, Veiculo> mapa) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while((linha = br.readLine()) != null){
            String[] v = linha.split(";");

            // LOGICA DE IDENTIFICAÇÃO PELAS COLUNAS (Estilo Aula 13):
            // Carro tem 4 campos (Modelo, Placa, Valor, Potencia)
            // Moto tem 3 campos (Modelo, Placa, Valor)
            if(v.length == 4){
                // É CARRO
                String mod = v[0];
                String pla = v[1];
                double val = Double.parseDouble(v[2]);
                double pot = Double.parseDouble(v[3]);

                // Map.put(CHAVE, VALOR) -> Chave é a Placa
                mapa.put(pla, new Carro(mod, pla, val, pot));

            } else {
                // É MOTO (Tamanho 3)
                String mod = v[0];
                String pla = v[1];
                double val = Double.parseDouble(v[2]);

                mapa.put(pla, new Moto(mod, pla, val));
            }
        }
        System.out.println("VEÍCULOS CARREGADOS: " + mapa.size());
        br.close();
    }
}