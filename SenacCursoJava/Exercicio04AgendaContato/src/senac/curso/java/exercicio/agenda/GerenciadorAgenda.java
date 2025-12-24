package senac.curso.java.exercicio.agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorAgenda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Contato> contatos = new ArrayList<>();

        String opcao;
        do {
            System.out.print("\n" +
                    "==== Menu Agenda ====\n" +
                    "1 - Adicionar contato\n" +
                    "2 - Listar contatos\n" +
                    "3 - Remover contato\n" +
                    "4 - Sair\n\n" +
                    "Escolha uma opcao: ");
            opcao = input.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Adicionando contato...");
                    Contato novoContato = new Contato("","","");
                    novoContato.setNome("nome");
                    novoContato.setTelefone("telefone");
                    novoContato.setEmail("email");
                    contatos.add(novoContato);
                    System.out.println("...Contato adicionado com sucesso!");
                    break;
                case "2":
                    System.out.println("Listando contatos...");
                    break;
                case "3":
                    System.out.println("Removendo contato...");
                    break;
                case "4":
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (!opcao.equals("4"));
    }
}
