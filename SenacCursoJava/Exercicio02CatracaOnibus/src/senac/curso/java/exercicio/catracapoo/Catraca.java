package senac.curso.java.exercicio.catracapoo;

public class Catraca {
    private int totalPassageiros;
    private final int LIMITE = 45;
    private boolean lotado;

    public Catraca() {
        this.totalPassageiros = 0;
        this.lotado = false;
    }

    public void registrarEntrada() {
        if (totalPassageiros == 45) {
            lotado = true;
            System.out.println("Ônibus lotado! Ninguém pode entrar.");
        } else {
            totalPassageiros++;
            System.out.println("Passageiro embarcado");
        }
    }

    public void registrarSaida() {
        if (totalPassageiros == 0) {
            lotado = false;
            System.out.println("Ônibus vazio! Não há passageiros para sair.");
        } else {
            totalPassageiros--;
            System.out.println("Passageiro desembarcado");
        }
    }

    public void mostrarSituacao() {
        System.out.println("Passageiros atuais: " + totalPassageiros);
        System.out.println("Lugares disponíveis: " + (LIMITE - totalPassageiros));
        if (totalPassageiros >= 1 && totalPassageiros <= 44) {
            System.out.println("Satus: Movimento normal");
        } else if (totalPassageiros == 0) {
            System.out.println("Satus: " + (lotado ? "Lotado" : "Vazio"));
        } else if (totalPassageiros == 45) {
            System.out.println("Satus: " + (lotado ? "Lotado" : "Vazio"));
        }
    }

    public void resetar() {
        totalPassageiros = 0;
        lotado = false;
        System.out.println("Passageiros zerados");
    }
}
