package ifto.poo.aula05.projetocolaborador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static String arq = "IftoDisciplinaPoo/PooiftoAula05ProjetoColaborador/dados.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Colaborador> lista = new ArrayList<>();

        Colaborador aux = new Colaborador();

        System.out.println("Inicianndo o sistema...");
        aux.gerarColaborador(lista);

        if (lista.isEmpty()) {
            System.out.println("A lista está vazia. Verifique o caminho do arquivo 'dados.txt'.");
        } else {
            System.out.println("Foram carregados " + lista.size() + " colaboradores.");
        }

        System.out.print("Digite uma idade para filtrar: ");
        int filtroIdade = input.nextInt();
        aux.listarColaborador(lista, filtroIdade);



        System.out.println("Sistema finalizado.");

    }
}
