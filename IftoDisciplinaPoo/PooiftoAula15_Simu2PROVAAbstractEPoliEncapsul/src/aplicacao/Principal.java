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

    // Nome do arquivo estático (estilo professor)
    public static String arquivo = "IftoDisciplinaPoo/PooiftoAula15_Simu2PROVAAbstractEPoliEncapsul/Veiculos.txt";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // MAP: A estrutura de dados oficial da prova (Aula 15)
        // Chave: Placa (String) | Valor: Veículo Genérico (Abstract)
        Map<String, Veiculo> mapaVeiculos = new HashMap<>();

        String menu = "\n--- LOCADORA SIMULADA (ENCAPSULAMENTO) ---\n"+
                "1 - Carregar Sistema\n"+
                "2 - Alugar Carro (Informe Dias)\n"+
                "3 - Alugar Moto (Informe Dias)\n"+
                "4 - Sair\n"+
                "Opção: ";

        while(true){
            System.out.print(menu);
            int opcao = scanner.nextInt();

            if(opcao == 4) break;

            switch (opcao){
                case 1:
                    // Validação para não duplicar dados
                    if(!mapaVeiculos.isEmpty()){
                        System.out.println("SISTEMA JÁ CARREGADO.");
                    } else {
                        carregarBaseDados(mapaVeiculos);
                    }
                    break;

                case 2: // SIMULAR CARRO
                    if(mapaVeiculos.isEmpty()){
                        System.out.println("Erro: Carregue o sistema primeiro.");
                        break;
                    }

                    // Input do usuário (Dinâmico)
                    System.out.print("Informe quantos dias ficará com o carro: ");
                    int diasCarro = scanner.nextInt();

                    System.out.println(String.format("%-20s %-15s %-10s %10s", "MODELO", "PLACA", "TIPO", "TOTAL"));

                    // Itera sobre o Mapa
                    for(Map.Entry<String, Veiculo> entrada : mapaVeiculos.entrySet()){
                        Veiculo v = entrada.getValue();

                        if(v instanceof Carro){
                            // O método calcularAluguel é público, mas internamente ele chama
                            // o método privado calcularSeguro. O Principal não vê isso.
                            double valorFinal = v.calcularAluguel(diasCarro);

                            System.out.println(v.toString() + String.format(" %10.2f", valorFinal));
                        }
                    }
                    System.out.println("-----------------------------------------------------");
                    break;

                case 3: // SIMULAR MOTO
                    if(mapaVeiculos.isEmpty()){
                        System.out.println("Erro: Carregue o sistema primeiro.");
                        break;
                    }

                    System.out.print("Informe quantos dias ficará com a moto: ");
                    int diasMoto = scanner.nextInt();

                    System.out.println(String.format("%-20s %-15s %-10s %10s", "MODELO", "PLACA", "TIPO", "TOTAL"));

                    for(Map.Entry<String, Veiculo> entrada : mapaVeiculos.entrySet()){
                        Veiculo v = entrada.getValue();

                        if(v instanceof Moto){
                            // Internamente chama o método privado calcularDesconto
                            double valorFinal = v.calcularAluguel(diasMoto);

                            System.out.println(v.toString() + String.format(" %10.2f", valorFinal));
                        }
                    }
                    System.out.println("-----------------------------------------------------");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }
        }
    }

    // Método de leitura separado
    public static void carregarBaseDados(Map<String, Veiculo> mapa) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while((linha = br.readLine()) != null){
            String[] v = linha.split(";");

            // Lógica de identificação pelas colunas (Aula 13)
            // Carro = 4 colunas | Moto = 3 colunas
            if(v.length == 4){
                // CARRO
                String mod = v[0];
                String pla = v[1];
                double val = Double.parseDouble(v[2]);
                double pot = Double.parseDouble(v[3]);

                mapa.put(pla, new Carro(mod, pla, val, pot));

            } else {
                // MOTO
                String mod = v[0];
                String pla = v[1];
                double val = Double.parseDouble(v[2]);

                mapa.put(pla, new Moto(mod, pla, val));
            }
        }
        System.out.println("DADOS CARREGADOS COM SUCESSO!");
        br.close();
    }
}