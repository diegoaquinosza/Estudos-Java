package senac.curso.java.exercicio.agenda;

import java.util.Scanner;

public class Contato {
    Scanner input = new Scanner(System.in);
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        System.out.print("Digite o nome do contato: ");
        this.nome = nome = input.nextLine();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        System.out.print("Digite o número do telefone: ");
        this.telefone = telefone = input.nextLine();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.print("Digite o endereço de e-mail: ");
        this.email = email  = input.nextLine();
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " | Telefone: " + this.telefone + " | E-mail: " + this.email;
    }
}
