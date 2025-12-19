package senac.curso.java.exercicio.catracapoo;

public class Catraca {
    private int totalPassageiros;
    private final int LIMITE = 5;
    private String status;
    private static int totalEmpresa = 0;

    public Catraca() {
        this.totalPassageiros = 0;
    }

    public void registrarEntrada() {
        if (totalPassageiros == 5) {
            System.out.println("Ônibus lotado! Ninguém pode entrar.");
        } else {
            totalPassageiros++;
            totalEmpresa++;
            System.out.println("Passageiro embarcado");
        }
    }

    public void registrarSaida() {
        if (totalPassageiros == 0) {
            System.out.println("Ônibus vazio! Não há passageiros para sair.");
        } else {
            totalPassageiros--;
            System.out.println("Passageiro desembarcado");
        }
    }

    public void mostrarSituacao() {
        System.out.println("------- Status do atual ---------");
        System.out.println("Passageiros atuais: " + totalPassageiros);
        System.out.println("Lugares disponíveis: " + (LIMITE - totalPassageiros));
        if (totalPassageiros >= 1 && totalPassageiros <= 4) {
            status = "Normal";
        }
        if (totalPassageiros == 0) {
            status = "Vazio";
        }
        if (totalPassageiros == LIMITE) {
            status = "Lotado";
        }
        System.out.println("Satus: " + status);
        System.out.println("--------------------------------");
    }

    public static void mostrarSituacaoGeral() {
        System.out.println("\n------- Status atual ---------");
        System.out.println("TOTAL DA FROTA (EMPRESA): " + totalEmpresa);
        System.out.println("-----------------------------------");
    }

    public void resetar() {
        totalPassageiros = 0;
        System.out.println("\nPassageiros zerados");
        System.out.println("-------------------");
    }

    public static void resetarFrota() {
        totalEmpresa = 0;
        System.out.println("Dados da Frota zerados");
        System.out.println("----------------------");
    }
}
