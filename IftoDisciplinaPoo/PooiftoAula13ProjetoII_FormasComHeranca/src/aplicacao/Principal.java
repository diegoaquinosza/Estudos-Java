package aplicacao;

import entidade.Circulo;
import entidade.Forma;
import entidade.Retangulo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    // CAMINHO DO ARQUIVO: Ajustado conforme sua solicitação
    public static String obj = "IftoDisciplinaPoo/PooiftoAula13ProjetoII_FormasComHeranca/objetos.txt";

    // "throws IOException": O main não trata o erro, ele avisa que pode falhar e para o programa.
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (true) {
            System.out.println("\n--- SISTEMA DE FORMAS (PROJETO II - HERANÇA) ---");
            System.out.println("1 - Ler Arquivo (Carregar Lista)");
            System.out.println("2 - Listar Retangulos (Área e Diagonal)");
            System.out.println("3 - Listar Circulos (Área e Diâmetro)");
            System.out.println("4 - Sair");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();

            if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:
                    lerArquivo();
                    break;
                case 2:
                    listarRetangulos();
                    break;
                case 3:
                    listarCirculos();
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        scanner.close();
    }

    public static void lerArquivo() throws IOException {
        // Limpa a lista estática localizada na superclasse Forma
        Forma.limparLista();

        BufferedReader leitor = new BufferedReader(new FileReader(obj));
        String linha;

        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");

            // Validação básica para evitar linhas vazias
            if(dados.length < 3) continue;

            String tipo = dados[0];
            String nome = dados[1];
            String cor = dados[2];

            // POLIMORFISMO NA ESCRITA:
            // Criamos um objeto específico (new Retangulo) mas guardamos na lista
            // genérica da classe mãe (Forma.adicionar).
            if (tipo.equalsIgnoreCase("Retangulo")) {
                double larg = Double.parseDouble(dados[3]);
                double alt = Double.parseDouble(dados[4]);

                Forma.adicionar(new Retangulo(nome, cor, larg, alt));
            }
            else if (tipo.equalsIgnoreCase("Circulo")) {
                double raio = Double.parseDouble(dados[3]);

                Forma.adicionar(new Circulo(nome, cor, raio));
            }
        }
        leitor.close();
        System.out.println("Carga efetuada! Total na memória: " + Forma.getLista().size());
    }

    public static void listarRetangulos() {
        System.out.println("\n--- RELATÓRIO: RETANGULOS ---");

        // Percorremos a lista genérica de Formas
        for (Forma f : Forma.getLista()) {

            // INSTANCEOF: Verifica se a forma "f" é, na verdade, um Retângulo
            if (f instanceof Retangulo) {

                // CASTING: Converte de "Forma" para "Retangulo".
                // Necessário para acessar o método exclusivo .diagonal()
                Retangulo r = (Retangulo) f;

                // Imprime usando o toString() que já mostra a Área
                System.out.println(r);

                // Imprime a diagonal (método exclusivo)
                System.out.printf("   -> Diagonal: %.2f\n", r.diagonal());
            }
        }
    }

    public static void listarCirculos() {
        System.out.println("\n--- RELATÓRIO: CIRCULOS ---");
        for (Forma f : Forma.getLista()) {

            // Verifica se é Circulo
            if (f instanceof Circulo) {

                // Casting para acessar o método exclusivo .diametro()
                Circulo c = (Circulo) f;

                System.out.println(c);
                System.out.printf("   -> Diâmetro: %.2f\n", c.diametro());
            }
        }
    }
}