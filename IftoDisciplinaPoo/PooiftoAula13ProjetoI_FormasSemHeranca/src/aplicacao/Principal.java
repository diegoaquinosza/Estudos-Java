package aplicacao;

import entidade.Circulo;
import entidade.Retangulo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    // Atributo pedido no diagrama
    public static String obj = "IftoDisciplinaPoo/PooiftoAula13ProjetoI_FormasSemHeranca/objetos.txt";

    // Lista genérica de Objetos (pois ainda não temos Herança)
    private static List<Object> listaObjetos = new ArrayList<>();

    // MUDANÇA: Adicionado "throws IOException" aqui.
    // Se der erro de arquivo, o programa encerra e mostra o erro no console (Stack Trace).
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Loop do Menu
        while (true) {
            System.out.println("\n--- MENU DE FORMAS GEOMÉTRICAS ---");
            System.out.println("1 - Gerar Objetos (Ler Arquivo)");
            System.out.println("2 - Listar Area Retangulo");
            System.out.println("3 - Listar Area Circulo");
            System.out.println("4 - Listar Diagonal Retangulo");
            System.out.println("5 - Listar Diametro Circulo");
            System.out.println("6 - Sair");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();

            if (opcao == 6) {
                System.out.println("Encerrando sistema...");
                break;
            }

            // MUDANÇA: Removemos o try-catch.
            // Se lerArquivo() falhar, o erro sobe para o main e para a execução.
            switch (opcao) {
                case 1:
                    lerArquivo();
                    break;
                case 2:
                    listarAreaRetangulos();
                    break;
                case 3:
                    listarAreaCirculos();
                    break;
                case 4:
                    listarDiagonalRetangulos();
                    break;
                case 5:
                    listarDiametroCirculos();
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        scanner.close();
    }

    public static void lerArquivo() throws IOException {
        // Limpa a lista para não duplicar dados
        listaObjetos.clear();

        BufferedReader leitor = new BufferedReader(new FileReader(obj));
        String linha;

        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");

            // Validação simples para evitar linhas em branco
            if(dados.length < 3) continue;

            String tipo = dados[0];
            String nome = dados[1];
            String cor = dados[2];

            // CORREÇÃO: Ajustado para "Retangulo" conforme seu arquivo objetos.txt
            if (tipo.equalsIgnoreCase("Retangulo")) {
                double larg = Double.parseDouble(dados[3]);
                double alt = Double.parseDouble(dados[4]);
                Retangulo r = new Retangulo(nome, cor, larg, alt);
                listaObjetos.add(r);
            }
            // CORREÇÃO: Ajustado para "Circulo"
            else if (tipo.equalsIgnoreCase("Circulo")) {
                double raio = Double.parseDouble(dados[3]);
                Circulo c = new Circulo(nome, cor, raio);
                listaObjetos.add(c);
            }
        }
        leitor.close();
        System.out.println("Objetos carregados! Total: " + listaObjetos.size());
    }

    // LISTAR AREA RETANGULO
    public static void listarAreaRetangulos() {
        System.out.println("\n--- AREA DOS RETANGULOS ---");
        for (Object obj : listaObjetos) {
            if (obj instanceof Retangulo) {
                Retangulo r = (Retangulo) obj; // Casting
                System.out.printf("%s | Área: %.2f\n", r.toString(), r.area());
            }
        }
    }

    // LISTAR AREA CIRCULO
    public static void listarAreaCirculos() {
        System.out.println("\n--- AREA DOS CIRCULOS ---");
        for (Object obj : listaObjetos) {
            if (obj instanceof Circulo) {
                Circulo c = (Circulo) obj; // Casting
                System.out.printf("%s | Área: %.2f\n", c.toString(), c.area());
            }
        }
    }

    // LISTAR DIAGONAL RETANGULO
    public static void listarDiagonalRetangulos() {
        System.out.println("\n--- DIAGONAL DOS RETANGULOS ---");
        for (Object obj : listaObjetos) {
            if (obj instanceof Retangulo) {
                Retangulo r = (Retangulo) obj;
                System.out.printf("Nome: %s | Diagonal: %.2f\n", r.getNome(), r.diagonal());
            }
        }
    }

    // LISTAR DIAMETRO CIRCULO
    public static void listarDiametroCirculos() {
        System.out.println("\n--- DIAMETRO DOS CIRCULOS ---");
        for (Object obj : listaObjetos) {
            if (obj instanceof Circulo) {
                Circulo c = (Circulo) obj;
                System.out.printf("Nome: %s | Diâmetro: %.2f\n", c.getNome(), c.diametro());
            }
        }
    }
}