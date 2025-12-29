package ifto.poo.aula05.projetocolaborador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Colaborador {
    private String nome;
    private String cpf;
    private int idade;

//    Constructors
    public Colaborador() {
    }

    public Colaborador(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

//    Getter and setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

//    Métodos
    public void gerarColaborador(List<Colaborador> listaRecebida) {
        File arquivo = new File(Programa.arq);

        try {
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(",");

                String nome = partes[0];
                String cpf = partes[1];
                int idade = Integer.parseInt(partes[2]);

                Colaborador colaborador = new Colaborador(nome, cpf, idade);
                listaRecebida.add(colaborador);
            }
            leitor.close();
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: Arquivo não encontrado em " + arquivo.getAbsolutePath());
        }
    }

    public void listarColaborador(List<Colaborador> lista, int filtroIdade) {
        System.out.println("\n--- Colaboradores com idade maior ou igual a " + filtroIdade + " ---");
        int total = 0;
        for (Colaborador colaborador : lista) {
            if (colaborador.getIdade() >= filtroIdade) {
                System.out.println(colaborador.getNome() + " | " + colaborador.getCpf() + " | " + colaborador.getIdade());
                total++;
            }
        }
        System.out.println("Total de colaboradores: " + total);
    }

    public String localizarColaborador(String colaborador) {
        return colaborador;
    }

    public void deletarColaborador(Colaborador colaborador) {

    }


}
