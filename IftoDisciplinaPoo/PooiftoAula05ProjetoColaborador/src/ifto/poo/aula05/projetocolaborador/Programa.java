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

        input.nextLine();
        System.out.println("Digite um nome para localizar na lista: ");
        String nomeBusca = input.nextLine();
        Colaborador encontrado = aux.localizarColaborador(lista, nomeBusca);

        if (encontrado != null) {
            System.out.println("--- Colaborador Encontrado ---");
            System.out.println("Nome: " + encontrado.getNome());
            System.out.println("CPF: " + encontrado.getCpf());
            System.out.println("Idade: " + encontrado.getIdade());
            System.out.println("------------------------------");

            System.out.println("Deseja DELETAR este colaborador? (S/N)");
            String resposta = input.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                aux.deletarColaborador(lista, encontrado);
                System.out.println("--- Colaborador Deletado ---");
                System.out.println("Total atualizado de colaboradores: " + lista.size());
            } else {
                System.out.println("Operação cancelada! Ninguém foi removido.");
            }
        } else {
            System.out.println("Colaborador não encontrado com o nome " + nomeBusca);
        }

        System.out.println("Sistema finalizado.");

    }
}
