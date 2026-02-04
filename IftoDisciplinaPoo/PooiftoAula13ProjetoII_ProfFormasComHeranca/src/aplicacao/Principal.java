package aplicacao;

import entidade.Circulo;
import entidade.Forma;
import entidade.Retangulo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    // Caminho do arquivo. Note que não é static.
    private String nomeArquivo = "IftoDisciplinaPoo/PooiftoAula13ProjetoII_ProfFormasComHeranca/Objetos.csv";

    // Método STATIC que recebe a lista vazia criada no Main
    public static void preencherLista(List<Forma> lista) throws IOException {

        // TRUQUE DO PROFESSOR:
        // Como o método é static e a variável 'nomeArquivo' não é static,
        // ele instanciou a própria classe (new Principal()) só para pegar o nome do arquivo.
        // O original era: new FileReader(new Principal().obj)
        BufferedReader leitorBuffer = new BufferedReader(new FileReader(new Principal().nomeArquivo));

        String linha;
        while((linha = leitorBuffer.readLine()) != null){

            // v -> dadosLinha
            String[] dadosLinha = linha.split(";");

            // LÓGICA DE IDENTIFICAÇÃO PELO TAMANHO:
            // O arquivo do professor tem:
            // Retangulo;Azul;4;6 (4 partes)
            // Circulo;Vermelho;3; (O split do Java ignora o vazio final, então vira 3 partes)

            if(dadosLinha.length == 4){
                // É RETANGULO (tem largura e altura)
                double largura = Double.parseDouble(dadosLinha[2]);
                double altura = Double.parseDouble(dadosLinha[3]);

                // Adiciona na lista de Formas
                lista.add(new Retangulo(dadosLinha[0], dadosLinha[1], largura, altura));
            } else {
                // É CIRCULO (só tem raio, tamanho do vetor é 3)
                double raio = Double.parseDouble(dadosLinha[2]);

                // UPCASTING IMPLÍCITO:
                // Estamos guardando um 'Circulo' dentro de uma 'List<Forma>'.
                // O filho está sendo tratado como o pai.
                lista.add(new Circulo(dadosLinha[0], dadosLinha[1], raio));
            }
        }
        leitorBuffer.close(); // Sempre fechar o arquivo
    }

    public static void main(String[] args) throws IOException {

        String menu = "\n1 - Gerar objetos\n"+
                "2 - Listar área retângulo\n"+
                "3 - Listar área circulo\n"+
                "4 - Listar diagonal retângulo\n"+
                "5 - Listar diâmetro circulo\n"+
                "6 - Sair\n"+
                "Opção: ";

        // dd -> scanner
        Scanner scanner = new Scanner(System.in);

        // A lista é criada aqui e passada como referência
        List<Forma> lista = new ArrayList<>();

        // flag -> listaJaCarregada
        // Serve para impedir que o usuário carregue o arquivo 2 vezes e duplique os dados
        int listaJaCarregada = 0;

        while(true){
            System.out.print(menu);
            // op -> opcao
            int opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    if(listaJaCarregada == 1){
                        System.out.println("⚠️ Atenção: A lista já foi preenchida anteriormente!");
                    } else {
                        // Passa a lista vazia para o método preencher
                        preencherLista(lista);
                        // Marca que já carregou para travar na próxima vez
                        listaJaCarregada = 1;
                        System.out.println("Sucesso! Objetos carregados: " + lista.size());
                    }
                    break;

                case 2:
                    System.out.println("--- ÁREAS DOS RETÂNGULOS ---");
                    // x -> formaAtual
                    for(Forma formaAtual : lista){
                        // INSTANCEOF: Só imprime se for Retângulo
                        if(formaAtual instanceof Retangulo){
                            // POLIMORFISMO: formaAtual.area() usa a fórmula do Retângulo
                            System.out.println(formaAtual.toString() + " | Area: " + formaAtual.area());
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- ÁREAS DOS CIRCULOS ---");
                    for(Forma formaAtual : lista){
                        if(formaAtual instanceof Circulo){
                            // POLIMORFISMO: formaAtual.area() usa a fórmula do Círculo
                            System.out.println(formaAtual.toString() + " | Area: " + formaAtual.area());
                        }
                    }
                    break;

                case 4:
                    System.out.println("--- DIAGONAL DOS RETANGULOS ---");
                    for(Forma formaAtual : lista){
                        if(formaAtual instanceof Retangulo){
                            // DOWNCASTING: (Retangulo) formaAtual
                            // Precisamos converter a Forma genérica em Retangulo para acessar .diagonal()
                            // O método diagonal() NÃO existe na classe Forma.
                            System.out.println(formaAtual.toString() + " | Diagonal: " + ((Retangulo) formaAtual).diagonal());
                        }
                    }
                    break;

                case 5:
                    System.out.println("--- DIAMETRO DOS CIRCULOS ---");
                    for(Forma formaAtual : lista){
                        if(formaAtual instanceof Circulo){
                            // DOWNCASTING: Converter para Circulo para acessar .diametro()
                            System.out.println(formaAtual.toString() + " | Diametro: " + ((Circulo) formaAtual).diametro());
                        }
                    }
                    break;

                default:
                    System.out.println("Saindo...");
                    System.exit(0); // Encerra o programa
            }
        }
    }
}