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

    private String nomeArquivo = "IftoDisciplinaPoo/PooiftoAula13ProjetoI_ProfFormasSemHeranca/Objetos.csv";

    // LISTA GENÉRICA (Object):
    // Como não temos a classe pai "Forma", usamos "Object" para aceitar qualquer coisa.
    // Isso nos obriga a fazer Castings (conversões) manuais depois.
    public static void preencherLista(List<Object> lista) throws IOException {

        // Instancia Principal apenas para pegar o nome do arquivo (Truque do professor)
        BufferedReader leitorBuffer = new BufferedReader(new FileReader(new Principal().nomeArquivo));
        String linha;

        while((linha = leitorBuffer.readLine()) != null){
            String[] dadosLinha = linha.split(";");

            // Lógica: Se tiver 4 partes é Retângulo, se tiver 3 é Círculo.
            if(dadosLinha.length == 4){
                double largura = Double.parseDouble(dadosLinha[2]);
                double altura = Double.parseDouble(dadosLinha[3]);

                // Adiciona Retangulo na lista de Objects
                lista.add(new Retangulo(dadosLinha[0], dadosLinha[1], largura, altura));
            }else{
                double raio = Double.parseDouble(dadosLinha[2]);

                // Adiciona Circulo na lista de Objects
                lista.add(new Circulo(dadosLinha[0], dadosLinha[1], raio));
            }
        }
        leitorBuffer.close();
    }

    public static void main(String[] args) throws IOException {
        String menu = "\n1 - Gerar objetos\n"+
                "2 - Listar área retângulo\n"+
                "3 - Listar área circulo\n"+
                "4 - Listar diagonal retângulo\n"+
                "5 - Listar diâmetro circulo\n"+
                "6 - Sair\n"+
                "Opção: ";

        Scanner scanner = new Scanner(System.in);

        // Lista de OBJECT: O Java sabe que tem objetos aí, mas não sabe quais métodos eles têm.
        List<Object> listaGenerica = new ArrayList<>();

        int listaJaPreenchida = 0; // Flag de controle

        while(true){
            System.out.print(menu);
            int opcao = scanner.nextInt();

            switch(opcao){
                case 1: // Ler arquivo
                    if(listaJaPreenchida == 1){
                        System.out.println("Lista já preenchida");
                    }else{
                        preencherLista(listaGenerica);
                        listaJaPreenchida = 1;
                        System.out.println("Carga realizada! Itens: " + listaGenerica.size());
                    }
                    break;

                case 2: // ÁREA RETÂNGULO
                    System.out.println("--- ÁREAS DOS RETÂNGULOS ---");
                    for(Object objAtual : listaGenerica){
                        // Precisamos checar um por um
                        if(objAtual instanceof Retangulo){
                            // CASTING OBRIGATÓRIO ((Retangulo) objAtual).area():
                            // O "objAtual" é do tipo Object. Object não tem método .area().
                            // Temos que "avisar" o Java: "Trate isso como Retângulo agora".
                            System.out.println(objAtual.toString() + " Area: "+ ((Retangulo) objAtual).area());
                        }
                    }
                    break;

                case 3: // ÁREA CÍRCULO
                    System.out.println("--- ÁREAS DOS CIRCULOS ---");
                    for(Object objAtual : listaGenerica){
                        if(objAtual instanceof Circulo){
                            // CASTING OBRIGATÓRIO novamente
                            System.out.println(objAtual.toString() + " Area: "+ ((Circulo) objAtual).area());
                        }
                    }
                    break;

                case 4: // DIAGONAL (Só Retângulo tem)
                    System.out.println("--- DIAGONAL DOS RETANGULOS ---");
                    for(Object objAtual : listaGenerica){
                        if(objAtual instanceof Retangulo){
                            System.out.println(objAtual.toString() + " Diagonal: "+ ((Retangulo) objAtual).diagonal());
                        }
                    }
                    break;

                case 5: // DIÂMETRO (Só Círculo tem)
                    System.out.println("--- DIAMETRO DOS CIRCULOS ---");
                    for(Object objAtual : listaGenerica){
                        if(objAtual instanceof Circulo){
                            System.out.println(objAtual.toString() + " Diametro: "+ ((Circulo) objAtual).diametro());
                        }
                    }
                    break;

                default:
                    System.out.println("Saindo...");
                    System.exit(0);
            }
        }
    }
}