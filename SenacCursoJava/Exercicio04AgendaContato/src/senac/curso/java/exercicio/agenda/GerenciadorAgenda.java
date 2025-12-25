package senac.curso.java.exercicio.agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorAgenda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Contato> listacontatos = new ArrayList<>();

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
                    System.out.print("Nome: ");
                    String nome = input.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = input.nextLine();
                    System.out.print("Email: ");
                    String email = input.nextLine();
                    Contato novoContato = new Contato(nome,telefone,email);
                    listacontatos.add(novoContato);
                    System.out.println("...Contato adicionado com sucesso!");
                    break;
                case "2":
                    System.out.println("Listando contatos...");
                    if(listacontatos.isEmpty()){
                        System.out.println("Agenda vazia, adicione contatos!");
                        break;
                    }
                    listacontatos.forEach(contato -> System.out.println(contato));
                    break;
                case "3":
                    System.out.println("Removendo contato...");
                    if(listacontatos.isEmpty()){
                        System.out.println("Agenda vazia, adicione contatos!");
                        break;
                    }
                    System.out.println("Qual contato que deseja remover?");
                    int delContato;
                    while(true) {
                        for(int i = 0; i < listacontatos.size(); i++) {
                            System.out.println(i + 1 + "- " + listacontatos.get(i));
                        }
                        System.out.print("Digite uma opcao: ");
                        if(input.hasNextInt()) {
                            delContato = input.nextInt();
                            input.nextLine();
                            if(delContato - 1 < listacontatos.size() && delContato - 1 >= 0) {
                                break;
                            } else {
                                System.out.println("Opcao invalida!");
                            }
                        } else {
                            System.out.println("Opcao invalida!");
                        }
                    }
                    listacontatos.remove(delContato - 1);
                    System.out.println("...Contato removido com sucesso!");
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
