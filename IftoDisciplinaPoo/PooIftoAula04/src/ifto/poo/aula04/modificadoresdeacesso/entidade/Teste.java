package ifto.poo.aula04.modificadoresdeacesso.entidade;

public class Teste {

    private int a = 1;
    protected int b = 2;
    int c = 3;
    public int d = 4;
    private static int e = 5;

    public int somar() {
        return a + b + c + d + e;
    }

}
