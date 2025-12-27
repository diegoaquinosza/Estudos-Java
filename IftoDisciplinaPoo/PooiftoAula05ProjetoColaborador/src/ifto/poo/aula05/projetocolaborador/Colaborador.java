package ifto.poo.aula05.projetocolaborador;

import java.util.List;

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
    public void gerarColaborador(List<Colaborador> lista) {

    }

    public void listarColaborador(int filtro) {

    }

    public String localizarColaborador(String colaborador) {
        return colaborador;
    }

    public void deletarColaborador(Colaborador colaborador) {

    }


}
